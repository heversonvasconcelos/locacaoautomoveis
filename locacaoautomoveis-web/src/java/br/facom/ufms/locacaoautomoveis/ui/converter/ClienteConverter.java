package br.facom.ufms.locacaoautomoveis.ui.converter;

import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "clienteConverter")
public class ClienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
        Cliente cliente = new Cliente();
        cliente.setId(Long.parseLong(value));

        return cliente;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
        Cliente cliente = (Cliente) object;

        return cliente.getId().toString();

    }
}
