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

    private AutomovelDAO automovelDao;
    private Automovel automovel;
    private ModeloAutomovelDAO modelo;
    private CategoriaAutomovelDAO categoria;

    @PostConstruct
    public void init() {
        automovelDao = new AutomovelDAOImpl();
        automovel = new Automovel();
        modelo = new ModeloAutomovelDAOImpl();
        categoria = new CategoriaAutomovelDAOImpl();
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public List<Automovel> getListaAutomoveis() {
        return automovelDao.list();
    }

    public String salvarAutomovel() {
        if (automovel.getId() == null) {
            automovelDao.create(automovel);
        } else {
            automovelDao.update(automovel);
        }

        return Constantes.PAGE_AUTOMOVEIS;
    }

    public List<ModeloAutomovel> getListaModelos() {
        return modelo.list();
    }

    public List<CategoriaAutomovel> getListaCategorias() {
        return categoria.list();
    }
}
