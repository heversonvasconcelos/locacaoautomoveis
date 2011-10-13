package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ModeloAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "modeloAutomovelConverter")
public class ModeloAutomovelConverter implements Converter {

    private ModeloAutomovelDAO modeloAutomovelDAO = new ModeloAutomovelDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Integer id = Integer.parseInt(value);

            return modeloAutomovelDAO.retrieve(id);
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            ModeloAutomovel modeloAutomovel = (ModeloAutomovel) value;

            return modeloAutomovel.getId().toString();
        }

        return (String) value;
    }
}
