package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.MarcaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import br.facom.ufms.locacaoautomoveis.ui.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MarcaAutomovelBean implements Serializable {

    private MarcaAutomovel marca;
    private MarcaAutomovelDAO marcaAutomovelDAO;

    @PostConstruct
    public void init() {
        marca = new MarcaAutomovel();
        marcaAutomovelDAO = new MarcaAutomovelDAOImpl();
    }

    public MarcaAutomovel getMarca() {
        return marca;
    }

    public void setMarca(MarcaAutomovel marca) {
        this.marca = marca;
    }

    public List<MarcaAutomovel> getListaMarcaAutomovel() {
        return marcaAutomovelDAO.list();
    }

    public String novaMarca() {
        marca = new MarcaAutomovel();

        return Constantes.PAGE_MARCAAUTOMOVEL_FORM;
    }

    public void salvarMarcaAutomovel() {
        if (marca.getId() == null) {
            marcaAutomovelDAO.create(marca);
        } else {
            marcaAutomovelDAO.update(marca);
        }

        FacesUtil.mensInfo(Constantes.MSG_INFO_MARCA_SALVA);
    }
}
