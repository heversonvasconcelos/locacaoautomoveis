package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private ClienteDAO clienteDAO;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        clienteDAO = new ClienteDAOImpl();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return clienteDAO.list();
    }

    public String novoCliente() {
        cliente = new Cliente();

        return Constantes.PAGE_CLIENTE_FORM;
    }

    public String salvarCliente() {
        if (cliente.getId() == null) {
            clienteDAO.create(cliente);
        } else {
            clienteDAO.update(cliente);
        }

        return Constantes.PAGE_CLIENTES;
    }

    public void gerarPDFRelatorioClientes() throws IOException, JRException {
        String nomeRelatorio = "../relatorios/relatorio-clientes.jasper";
        String nomeSaida = "Clientes.pdf";

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext ctx = (ServletContext) externalContext.getContext();

        //pega o caminho do arquivo .jasper da aplicação
        InputStream reportStream = getClass().getResourceAsStream(nomeRelatorio);

        if (reportStream == null) {
            System.out.println("Erro ao gerar relatório: " + nomeRelatorio);
        }

        //envia a resposta com o MIME Type PDF
        response.setContentType("application/pdf");
        /* força a abertura de download */
        response.setHeader("Content-Disposition", "attachment;filename=" + nomeSaida);

        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();

            List<Cliente> listaClientes = getListaClientes();

            //envia o título para o relatório, usando o parâmetro criado
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("QTD_REGISTROS", listaClientes.size());

            //cria uma fonte de dados para coleções
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(listaClientes);

            //envia para o navegador o PDF gerado
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parametros, fonteDados);

            servletOutputStream.flush();
            servletOutputStream.close();

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        context.responseComplete();

    }
}
