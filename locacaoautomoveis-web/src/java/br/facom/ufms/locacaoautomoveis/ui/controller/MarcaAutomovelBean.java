package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.MarcaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ModeloAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MarcaAutomovelBean implements Serializable {

    private MarcaAutomovel marca;
    private MarcaAutomovelDAO marcaDAO;

    @PostConstruct
    public void init() {
	marca = new MarcaAutomovel();
	marcaDAO = new MarcaAutomovelDAOImpl();
    }

    public MarcaAutomovel getMarca() {
	return marca;
    }

    public void setModelo(MarcaAutomovel marca) {
	this.marca = marca;
    }
    
    public void setMarcaDAO(MarcaAutomovelDAO marcaDAO) {
	this.marcaDAO = marcaDAO;
    }

    public String salvarMarcaAutomovel() {
	if (marca.getId() == null) {
	    marcaDAO.create(marca);
	} else {
	    marcaDAO.update(marca);
	}

	return Constantes.PAGE_MARCAAUTOMOVEIS;
    }

    public List<MarcaAutomovel> getListaMarcaAutomovel() {
	return marcaDAO.list();
    }
}
