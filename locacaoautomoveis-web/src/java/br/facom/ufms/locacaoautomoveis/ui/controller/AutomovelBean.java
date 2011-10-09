/**
 * 
 */
package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.AutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ModeloAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;


/**
 * Interface principal para gerenciar automóveis
 */
@ManagedBean
@ViewScoped
public class AutomovelBean implements Serializable{
    
    private AutomovelDAO automovelDao;
    private Automovel automovel;
    private ModeloAutomovelDAO modelo;
    
    @PostConstruct
    public void init() {
        automovelDao = new AutomovelDAOImpl();
        automovel = new Automovel();
        modelo = new ModeloAutomovelDAOImpl();
    }
    
    public Automovel getAutomovel() {
        return automovel;
    }
    
    public List<Automovel> getListaAutomoveis() {
        return automovelDao.list();
    } 
    
    public void create() {
          if (automovel.getId() == null) {
            automovelDao.create(automovel);
        } else {
            automovelDao.create(automovel);
        }
    }
    
    public List<ModeloAutomovel> getListaModelos() {
        return modelo.list();
    }
    
}
