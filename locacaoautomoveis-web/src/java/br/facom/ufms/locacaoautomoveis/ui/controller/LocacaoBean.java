package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.LocacaoDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.LocacaoDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LocacaoBean implements Serializable {

    private Locacao locacao;
    private LocacaoDAO locacaoDAO;

    @PostConstruct
    public void init() {
        locacao = new Locacao();
        locacaoDAO = new LocacaoDAOImpl();
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public List<Locacao> getListaLocacoes() {
        return locacaoDAO.list();
    }

    public String novaLocacao() {
        locacao = new Locacao();

        return Constantes.PAGE_LOCACOES_FORM;
    }
}
