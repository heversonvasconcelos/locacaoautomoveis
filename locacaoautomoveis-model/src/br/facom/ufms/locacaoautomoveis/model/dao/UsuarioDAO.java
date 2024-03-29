/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.dao;

import br.facom.ufms.locacaoautomoveis.model.entities.Usuario;

/**
 *
 * @author heverson.vasconcelos
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

    public Usuario buscarUsuarioPeloNomeLogin(String usuarioNomeLogin);

    public boolean verificaSeUsuarioExiste(String usuarioNomeLogin);
}
