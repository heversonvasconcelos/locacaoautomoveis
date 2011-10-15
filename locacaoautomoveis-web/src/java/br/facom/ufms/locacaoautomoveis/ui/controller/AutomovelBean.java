/**
 * 
 */
package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.AutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.CategoriaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ModeloAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.model.entities.CategoriaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import br.facom.ufms.locacaoautomoveis.ui.util.FacesUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * Interface principal para gerenciar automóveis
 */
@ManagedBean
@SessionScoped
public class AutomovelBean implements Serializable {

    private Automovel automovel;
    private AutomovelDAO automovelDAO;
    private ModeloAutomovelDAO modeloAutomovelDAO;
    private CategoriaAutomovelDAO categoriaAutomovelDAO;

    @PostConstruct
    public void init() {
        automovel = new Automovel();
        automovelDAO = new AutomovelDAOImpl();
        modeloAutomovelDAO = new ModeloAutomovelDAOImpl();
        categoriaAutomovelDAO = new CategoriaAutomovelDAOImpl();
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public List<Automovel> getListaAutomoveis() {
        return automovelDAO.list();
    }

    public List<ModeloAutomovel> getListaModelos() {
        return modeloAutomovelDAO.list();
    }

    public List<CategoriaAutomovel> getListaCategorias() {
        return categoriaAutomovelDAO.list();
    }

    public String novoAutomovel() {
        automovel = new Automovel();

        return Constantes.PAGE_AUTOMOVEIS_FORM;
    }

    public String salvarAutomovel() {
        if (automovel.getId() == null) {
            automovelDAO.create(automovel);
        } else {
            automovelDAO.update(automovel);
        }

        return Constantes.PAGE_AUTOMOVEIS;
    }

    public void gerarPDFRelatorioAutomoveis() throws IOException, JRException {
        String nomeRelatorio = "../relatorios/relatorio-automoveis.jasper";
        String nomeSaida = "Automoveis.pdf";

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext ctx = (ServletContext) externalContext.getContext();

        //pega o caminho do arquivo .jasper da aplicação
        InputStream reportStream = getClass().getResourceAsStream(nomeRelatorio);

        if (reportStream == null) {
            FacesUtil.mensErro(Constantes.MSG_ERRO_GERAR_RELATORIO_RECIBO);
        }

        //envia a resposta com o MIME Type PDF
        response.setContentType("application/pdf");
        /* força a abertura de download */
        response.setHeader("Content-Disposition", "attachment;filename=" + nomeSaida);

        try {
            ServletOutputStream servletOutputStream = response.getOutputStream();

            List<Automovel> listaAutomoveis = getListaAutomoveis();

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("QTD_REGISTROS", listaAutomoveis.size());

            //cria uma fonte de dados para coleções
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(listaAutomoveis);

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
