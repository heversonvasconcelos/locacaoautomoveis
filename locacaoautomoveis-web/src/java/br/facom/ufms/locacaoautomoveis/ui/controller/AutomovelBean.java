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
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

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
}
