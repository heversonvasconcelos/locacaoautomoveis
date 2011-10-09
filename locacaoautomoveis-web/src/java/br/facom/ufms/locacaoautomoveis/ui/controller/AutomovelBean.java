/**
 * 
 */
package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.AutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
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
    
    @PostConstruct
    public void init() {
        automovelDao = new AutomovelDAOImpl();
        automovel = new Automovel();
    }
    
    public Automovel getAutomovel() {
        return automovel;
    }
    
    public List<Automovel> getListaAutomoveis() {
        return automovelDao.list();
    } 
    
}
