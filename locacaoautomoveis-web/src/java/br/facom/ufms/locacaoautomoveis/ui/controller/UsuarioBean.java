package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.UsuarioDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.UsuarioDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Usuario;
import br.facom.ufms.locacaoautomoveis.model.util.StringUtil;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import br.facom.ufms.locacaoautomoveis.ui.util.FacesUtil;
import br.facom.ufms.locacaoautomoveis.ui.util.SessionUtil;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author heverson.vasconcelos
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario usuarioLogado;
    private UsuarioDAO usuarioDAO;

    @PostConstruct
    public void init() {
        usuarioLogado = (Usuario) SessionUtil.getAttribute(Constantes.LOGGED_USER);
        usuarioDAO = new UsuarioDAOImpl();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void salvarUsuario() {
    }
}
