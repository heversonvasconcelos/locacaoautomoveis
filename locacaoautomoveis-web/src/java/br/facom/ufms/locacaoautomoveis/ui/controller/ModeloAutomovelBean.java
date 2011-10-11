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
public class ModeloAutomovelBean implements Serializable {

    private ModeloAutomovel modelo;
    private ModeloAutomovelDAO modeloDAO;
    private MarcaAutomovelDAO marcaAutomovel;

    @PostConstruct
    public void init() {
	modelo = new ModeloAutomovel();
	modeloDAO = new ModeloAutomovelDAOImpl();
	marcaAutomovel = new MarcaAutomovelDAOImpl();
    }

    public ModeloAutomovel getModelo() {
	return modelo;
    }

    public void setModelo(ModeloAutomovel modelo) {
	this.modelo = modelo;
    }
    
    public void setModeloDAO(ModeloAutomovelDAO modeloDAO) {
	this.modeloDAO = modeloDAO;
    }

    public String salvarModeloAutomovel() {
	if (modelo.getId() == null) {
	    modeloDAO.create(modelo);
	} else {
	    modeloDAO.update(modelo);
	}

	return Constantes.PAGE_MODELOAUTOMOVEIS;
    }

    public List<ModeloAutomovel> getListaModeloAutomovel() {
	return modeloDAO.list();
    }

    public List<MarcaAutomovel> getListaMarcasAutomovel() {
	return marcaAutomovel.list();
    }
}
