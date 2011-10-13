package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.CategoriaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.CategoriaAutomovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaAutomovelConverter")
public class CategoriaAutomovelConverter implements Converter {

    private CategoriaAutomovelDAO categoriaAutomovelDAO = new CategoriaAutomovelDAOImpl();

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            Integer id = Integer.parseInt(value);

            return categoriaAutomovelDAO.retrieve(id);
        }

        return null;

    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            CategoriaAutomovel categoria = (CategoriaAutomovel) value;

            return categoria.getId().toString();
        }

        return (String) value;
    }
}
