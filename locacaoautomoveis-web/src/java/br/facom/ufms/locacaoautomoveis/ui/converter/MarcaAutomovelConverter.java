package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.MarcaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "marcaAutomovelConverter")
public class MarcaAutomovelConverter implements Converter {

    private MarcaAutomovelDAO marcaAutomovelDAO = new MarcaAutomovelDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Integer id = Integer.parseInt(value);

            return marcaAutomovelDAO.retrieve(id);
        }

        return null;

    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            MarcaAutomovel marcaAutomovel = (MarcaAutomovel) value;

            return marcaAutomovel.getId().toString();
        }

        return (String) value;
    }
}
