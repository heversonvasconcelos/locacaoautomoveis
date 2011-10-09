/**
 * 
 */
package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.AutomovelDAOImpl;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
/**
 * Interface principal para gerenciar automóveis
 */

public class AutomovelBean {
    
    private AutomovelDAO automovel = new AutomovelDAOImpl();
    
    
    
}
