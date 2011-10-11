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
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LocacaoBean implements Serializable {

    private Locacao locacao;
    private Cliente cliente;
    private Automovel automovel;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
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

    public List<Automovel> getListaAutomoveis() {
        return automovelDAO.list();
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
        }

        if (!locacaoDAO.finalizarLocacao(locacao)) {
            FacesUtil.mensErro(Constantes.MSG_ERRO_LOCACAO);
        }

        return Constantes.PAGE_LOCACOES;
    }
}
