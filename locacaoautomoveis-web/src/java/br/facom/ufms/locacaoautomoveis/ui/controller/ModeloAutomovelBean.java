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
    private ModeloAutomovelDAO modeloAutomovelDAO;
    private MarcaAutomovelDAO marcaAutomovelDAO;

    @PostConstruct
    public void init() {
        modelo = new ModeloAutomovel();
        modeloAutomovelDAO = new ModeloAutomovelDAOImpl();
        marcaAutomovelDAO = new MarcaAutomovelDAOImpl();
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloAutomovel modelo) {
        this.modelo = modelo;
    }

    public List<ModeloAutomovel> getListaModeloAutomovel() {
        return modeloAutomovelDAO.list();
    }

    public List<MarcaAutomovel> getListaMarcasAutomovel() {
        return marcaAutomovelDAO.list();
    }

    public String novoModelo() {
        modelo = new ModeloAutomovel();

        return Constantes.PAGE_MODELOAUTOMOVEL_FORM;
    }

    public String salvarModeloAutomovel() {
        if (modelo.getId() == null) {
            modeloAutomovelDAO.create(modelo);
        } else {
            modeloAutomovelDAO.update(modelo);
        }

        return Constantes.PAGE_MODELOSAUTOMOVEL;
    }
}
