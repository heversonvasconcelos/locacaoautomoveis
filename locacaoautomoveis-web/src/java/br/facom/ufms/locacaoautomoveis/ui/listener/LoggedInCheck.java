package br.facom.ufms.locacaoautomoveis.ui.listener;

import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import br.facom.ufms.locacaoautomoveis.ui.util.SessionUtil;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author heverson.vasconcelos
 */
public class LoggedInCheck implements PhaseListener {

    public static final String PAGE_INDEX_FILENAME = Constantes.PAGE_INDEX + ".xhtml";
    public static final String PAGE_USER_NOT_LOGGED_FILENAME = Constantes.PAGE_USER_NOT_LOGGED + ".xhtml";

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();

        boolean isLoginPage = (currentPage.lastIndexOf(PAGE_INDEX_FILENAME) > -1);
        boolean isUserNotLogged = (currentPage.lastIndexOf(PAGE_USER_NOT_LOGGED_FILENAME) > -1);
        Object currentUser = SessionUtil.getAttribute(Constantes.LOGGED_USER);

        if (!isLoginPage && !isUserNotLogged && currentUser == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, Constantes.PAGE_USER_NOT_LOGGED);
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
