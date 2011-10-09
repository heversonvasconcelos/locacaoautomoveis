/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test;

import br.facom.ufms.locacaoautomoveis.model.dao.UsuarioDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.UsuarioDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Usuario;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class UsuarioDAOTest extends PrintList {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Test
    public void testeListaTodosUsuarios() {
        List<Usuario> userList = usuarioDAO.list();

        printList(userList, "TodosUsuarios");
    }

    @Test
    public void testeSalvarUsuario() {
        Usuario usuario00 = new Usuario();
        usuario00.setNomeLogin("joao");
        usuario00.setSenha("joao");
        usuarioDAO.create(usuario00);
        Assert.assertNotNull(usuario00.getId());


        Usuario usuario01 = new Usuario();
        usuario01.setNomeLogin("joana");
        usuario01.setSenha("joana");
        usuarioDAO.create(usuario01);
        Assert.assertNotNull(usuario01.getId());

        Usuario usuario02 = new Usuario();
        usuario02.setNomeLogin("julio");
        usuario02.setSenha("julio");
        usuarioDAO.create(usuario02);
        Assert.assertNotNull(usuario02.getId());


    }

    @Test
    public void testeBuscarUsuarioPeloNomeLogin() {
        String nomeLogin = "joao";
        Usuario usuario = usuarioDAO.buscarUsuarioPeloNomeLogin(nomeLogin);

        System.out.println("----------------------------------------------");
        System.out.println("Usuario buscado: " + nomeLogin);
        System.out.println("Usuario encontrado: " + usuario);
        Assert.assertNotNull(usuario.getId());
    }
}
