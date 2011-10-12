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

    private CategoriaAutomovel categoria;
    private CategoriaAutomovelDAO categoriaAutomovelDAO;

    @PostConstruct
    public void init() {
        categoria = new CategoriaAutomovel();
        categoriaAutomovelDAO = new CategoriaAutomovelDAOImpl();
    }

    public CategoriaAutomovel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAutomovel categoria) {
        this.categoria = categoria;
    }

    public List<CategoriaAutomovel> getListaCategorias() {
        return categoriaAutomovelDAO.list();
    }

    public String novaCategoria() {
        categoria = new CategoriaAutomovel();

        return Constantes.PAGE_CATEGORIAAUTOMOVEL_FORM;
    }

    public String salvarCategoriaAutomovel() {
        if (categoria.getId() == null) {
            categoriaAutomovelDAO.create(categoria);
        } else {
            categoriaAutomovelDAO.update(categoria);
        }

        return Constantes.PAGE_CATEGORIASAUTOMOVEL;
    }
}