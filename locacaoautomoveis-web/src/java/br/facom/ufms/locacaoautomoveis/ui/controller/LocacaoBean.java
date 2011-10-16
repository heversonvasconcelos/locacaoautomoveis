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
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import br.facom.ufms.locacaoautomoveis.ui.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

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

    public void gerarRegistroLocacao() {
        /*
         * Nome do arquivo
         */
        String registroLocacaoFileName = "registrolocacao-" + locacao.getId() + ".txt";

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response =
                (HttpServletResponse) context.getExternalContext().getResponse();
        response.setContentType("application/txt");
        response.setHeader("Content-disposition", "attachment; filename=" + registroLocacaoFileName);

        try {
            response.getOutputStream().write(getInformacaoesRegistroLocacao());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            context.responseComplete();
        } catch (IOException e) {
        }
    }

    private byte[] getInformacaoesRegistroLocacao() {
        /*
         * Preparando o conteúdo do registro de locação
         */
        DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");

        StringBuilder conteudoRegistroLocacao = new StringBuilder();
        conteudoRegistroLocacao.append("Identificação da locação: ");
        conteudoRegistroLocacao.append(locacao.getId());
        conteudoRegistroLocacao.append("\tData/Hora: ");
        conteudoRegistroLocacao.append(df1.format(locacao.getDataHoraLocacao()));
        conteudoRegistroLocacao.append("\nNome cliente: ");
        conteudoRegistroLocacao.append(locacao.getCliente().getNome());
        conteudoRegistroLocacao.append("\tCPF/CNPJ: ");
        conteudoRegistroLocacao.append(locacao.getCliente().getCpfcnpj());
        conteudoRegistroLocacao.append("\nPlaca Automovel: ");
        conteudoRegistroLocacao.append(locacao.getAutomovel().getPlaca());
        if (locacao.getAutomovel().getModelo() != null) {
            conteudoRegistroLocacao.append("\tModelo: ");
            conteudoRegistroLocacao.append(locacao.getAutomovel().getModelo().getDescricao());
        }
        if (locacao.getAutomovel().getCategoria() != null) {
            conteudoRegistroLocacao.append("\nCategoria: ");
            conteudoRegistroLocacao.append(locacao.getAutomovel().getCategoria().getDescricao());
            conteudoRegistroLocacao.append("\tValor diária: ");
            conteudoRegistroLocacao.append(locacao.getAutomovel().getCategoria().getValorDiario());
        }
        if (locacao.getDataPrevistaDevolucao() != null) {
            conteudoRegistroLocacao.append("\nData prevista devolução: ");
            conteudoRegistroLocacao.append(df2.format(locacao.getDataPrevistaDevolucao()));
        }
        if (locacao.getStatus() == Status.FECHADO) {
            conteudoRegistroLocacao.append("\nData locação finalizada: ");
            conteudoRegistroLocacao.append(df1.format(locacao.getDataHoraLocacaoFinalizada()));
            conteudoRegistroLocacao.append("\tValor locação: ");
            conteudoRegistroLocacao.append(locacao.getValor());
        }

        return conteudoRegistroLocacao.toString().getBytes();
    }
}
