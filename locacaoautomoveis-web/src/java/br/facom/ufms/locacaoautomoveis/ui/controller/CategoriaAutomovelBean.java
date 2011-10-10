package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.CategoriaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.CategoriaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CategoriaAutomovelBean implements Serializable {
    private CategoriaAutomovelDAO categoriaDAO;
    private CategoriaAutomovel categoria;
    
    @PostConstruct
    public void init() {
	categoriaDAO = new CategoriaAutomovelDAOImpl();
	categoria = new CategoriaAutomovel();	
    }

    public CategoriaAutomovel getCategoria() {
	return categoria;
    }

    public void setCategoria(CategoriaAutomovel categoria) {
	this.categoria = categoria;
    }

    public CategoriaAutomovelDAO getCategoriaDAO() {
	return categoriaDAO;
    }

    public void setCategoriaDAO(CategoriaAutomovelDAO categoriaDAO) {
	this.categoriaDAO = categoriaDAO;
    }
    
    public String salvarCategoriaAutomovel() {
	if (categoria.getId() == null) {
	   categoriaDAO.create(categoria);
	} else {
	    categoriaDAO.update(categoria);
	}
	
	return Constantes.PAGE_CATEGORIAAUTOMOVEIS;
    }
    
    public List<CategoriaAutomovel> getListaCategorias() {
	return categoriaDAO.list();
    }
}