package br.facom.ufms.locacaoautomoveis.ui.validator;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "cpfcnpjValidator")
public class CPFCNPJValidator implements Validator {

    @Override
    public void validate(FacesContext arg0, UIComponent arg1, Object value)
            throws ValidatorException {

        String cpfcnpj = value.toString();
        br.com.caelum.stella.validation.Validator validator;

        if (cpfcnpj.length() == 11) {
            validator = new CPFValidator(false);

            try {
                validator.assertValid(cpfcnpj);
            } catch (InvalidStateException e) {
                FacesMessage msg = new FacesMessage(Constantes.MSG_INVALID_CPF);
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        } else if (cpfcnpj.length() == 14) {
            validator = new CNPJValidator(false);

            try {
                validator.assertValid(cpfcnpj);
            } catch (InvalidStateException e) {
                FacesMessage msg = new FacesMessage(Constantes.MSG_INVALID_CNPJ);
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        } else {
            FacesMessage msg = new FacesMessage(Constantes.MSG_INVALID_CP);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }


    }
}
