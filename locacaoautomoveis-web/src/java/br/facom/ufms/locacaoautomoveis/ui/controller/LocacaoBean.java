package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.LocacaoDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.AutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.LocacaoDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import br.facom.ufms.locacaoautomoveis.model.util.DateCalculator;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import br.facom.ufms.locacaoautomoveis.ui.util.FacesUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@ManagedBean
@SessionScoped
public class LocacaoBean implements Serializable {

    private Locacao locacao;
    private Date dataPrevistaDevolucao;
    private LocacaoDAO locacaoDAO;
    private ClienteDAO clienteDAO;
    private AutomovelDAO automovelDAO;

    @PostConstruct
    public void init() {
        locacao = new Locacao();
        locacaoDAO = new LocacaoDAOImpl();
        clienteDAO = new ClienteDAOImpl();
        automovelDAO = new AutomovelDAOImpl();
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public List<Locacao> getListaLocacoes() {
        return locacaoDAO.list();
    }

    public List<Cliente> getListaClientes() {
        return clienteDAO.list();
    }

    public List<Automovel> getListaAutomoveisDisponiveis() {
        return automovelDAO.buscarAutomoveisPelaDisponibilidade(true);

    }

    public String novaLocacao() {
        locacao = new Locacao();

        return Constantes.PAGE_LOCACAO_FORM;
    }

    public String salvarLocacao() {
        if (locacao.getId() == null) {
            locacaoDAO.create(locacao);
        } else {
            locacaoDAO.update(locacao);
        }

        return Constantes.PAGE_LOCACOES;
    }

    public String fecharLocacao() {
        if (locacao.getStatus() == Status.FECHADO) {
            FacesUtil.mensErro(Constantes.MSG_ERRO_LOCACAO_PREVIAMENTE_FECHADA);
        } else if (!locacaoDAO.finalizarLocacao(locacao)) {
            FacesUtil.mensErro(Constantes.MSG_ERRO_LOCACAO);
        }

        return Constantes.PAGE_LOCACOES;
    }

    public void gerarPDFRelatorioAutomoveis() throws IOException, JRException {
        String nomeRelatorio = "../relatorios/registro-locacao.jasper";
        String nomeSaida = "RegistroLocacao-" + locacao.getId() + ".pdf";

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

            Map<String, Object> parametros = getInformacaoesRegistroLocacao();

            //envia para o navegador o PDF gerado
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parametros, new JREmptyDataSource());

            servletOutputStream.flush();
            servletOutputStream.close();

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        context.responseComplete();

    }

    private Map<String, Object> getInformacaoesRegistroLocacao() {
        Map<String, Object> parametros = new HashMap<String, Object>();
        Locale.setDefault(new Locale("pt","BR"));
        
        DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        parametros.put("locacao.id", locacao.getId());
        parametros.put("locacao.dataHoraLocacao", df1.format(locacao.getDataHoraLocacao()));
        parametros.put("locacao.dataPrevistaDevolucao", df2.format(locacao.getDataPrevistaDevolucao()));

        parametros.put("locacao.cliente.nome", locacao.getCliente().getNome());
        parametros.put("locacao.cliente.cpfcnpj", locacao.getCliente().getCpfcnpj());

        parametros.put("locacao.automovel.placa", locacao.getAutomovel().getPlaca());
        parametros.put("locacao.automovel.marca", locacao.getAutomovel().getModelo().getMarca().getDescricao());
        parametros.put("locacao.automovel.modelo", locacao.getAutomovel().getModelo().getDescricao());

        parametros.put("locacao.automovel.categoria", locacao.getAutomovel().getCategoria().getDescricao());
        parametros.put("locacao.automovel.categoria.valorDiario",  nf.format(locacao.getAutomovel().getCategoria().getValorDiario()));

        if (locacao.getDataHoraLocacaoFinalizada() != null) {
            parametros.put("locacao.dataHoraLocacaoFinalizada", df1.format(locacao.getDataHoraLocacaoFinalizada()));
            parametros.put("locacao.qtdDiasLocacao",
                    DateCalculator.calcularQtdDiasEntreDuasDatas(locacao.getDataHoraLocacao(), locacao.getDataHoraLocacaoFinalizada()));
            parametros.put("locacao.valor", nf.format(locacao.getValor()));
        }

        return parametros;
    }
}
