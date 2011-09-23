/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.test;

import br.facom.ufms.locacaoautomoveis.persistence.dao.UsuarioDAO;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.UsuarioDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.entities.Usuario;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class UsuarioDAOTest {

    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Test
    public void testeListaTodosUsuarios() {
        List<Usuario> userList = usuarioDAO.list();

        printLista(userList);
    }

//    @Test
    public void testeSalvarUsuario() {
        Usuario usuario00 = new Usuario();
        usuario00.setNomeLogin("joana");
        usuario00.setSenha("joana");
        usuarioDAO.create(usuario00);

        Usuario usuario01 = new Usuario();
        usuario01.setNomeLogin("joao");
        usuario01.setSenha("joao");
        usuarioDAO.create(usuario01);

        Usuario usuario02 = new Usuario();
        usuario02.setNomeLogin("julio");
        usuario02.setSenha("julio");
        usuarioDAO.create(usuario02);


    }

    public void printLista(List<Usuario> userList) {
        System.out.println("----------------------------------------------");
        for (Iterator<Usuario> it = userList.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
