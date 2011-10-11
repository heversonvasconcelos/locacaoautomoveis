package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "automovelConverter")
public class AutomovelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        Automovel automovel = new Automovel();
        automovel.setId(Integer.parseInt(value));

        return automovel;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
        Automovel automovel = (Automovel) object;

        return automovel.getId().toString();

    }
}
