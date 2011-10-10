package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.entities.CategoriaAutomovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaAutomovelConverter")
public class CategoriaAutomovelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        CategoriaAutomovel categoriaAutomovel = new CategoriaAutomovel();
        categoriaAutomovel.setId(Integer.parseInt(value));

        return categoriaAutomovel;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
        CategoriaAutomovel categoriaAutomovel = (CategoriaAutomovel) object;

        return String.valueOf(categoriaAutomovel.getId());

    }
}
