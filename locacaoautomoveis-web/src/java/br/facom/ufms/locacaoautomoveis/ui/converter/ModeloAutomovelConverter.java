package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "modeloAutomovelConverter")
public class ModeloAutomovelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        ModeloAutomovel modeloAutomovel = new ModeloAutomovel();
        modeloAutomovel.setId(Integer.parseInt(value));

        return modeloAutomovel;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
        ModeloAutomovel modeloAutomovel = (ModeloAutomovel) object;

        return String.valueOf(modeloAutomovel.getId());

    }
}
