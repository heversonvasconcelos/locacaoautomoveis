package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "marcaAutomovelConverter")
public class MarcaAutomovelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        MarcaAutomovel marcaAutomovel = new MarcaAutomovel();
        marcaAutomovel.setId(Integer.parseInt(value));

        return marcaAutomovel;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
        MarcaAutomovel marcaAutomovel = (MarcaAutomovel) object;

        return marcaAutomovel.getId().toString();

    }
}
