package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.UsuarioDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.Usuario;
import br.facom.ufms.locacaoautomoveis.model.types.NamedQueryParameter;

/**
 * Classe concreta que sera utilizada na execucao de todas as operacoes de
 * persistencia relativas a entidade Usuario.
 * 
 * @author heverson.vasconcelos
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

    @Override
    public Class<Usuario> getDomainClass() {
        return Usuario.class;
    }

    /**
     * Metodo para consultar um usuario a partir de um nome de login.
     * Obs.: Utiliza a NamedQuery Usuario.findByUserName descrita na classe Usuario.
     *
     * @param usuarioNomeLogin Nome de login a ser buscado.
     * @return Usuario contendo o nome userName. <br>
     *         Null caso nao exista um usuario contendo o nome userName.
     */
    @Override
    public Usuario buscarUsuarioPeloNomeLogin(String usuarioNomeLogin) {
        String namedQuery = "Usuario.buscarUsuarioPeloNomeLogin";
        NamedQueryParameter parameter = new NamedQueryParameter("usuarioNomeLogin", usuarioNomeLogin);
        Usuario usuario = (Usuario) executeNamedQuerySingleResult(namedQuery, parameter);

        return usuario;

    }

    /**
     * Metodo para verificar se existe um usuario com um determinado nome de login.
     *
     * @param usuarioNomeLogin Nome de login a ser buscado.
     * @return True caso exista um usuario contendo o nome de login.
     */
    @Override
    public boolean verificaSeUsuarioExiste(String usuarioNomeLogin) {
        if (buscarUsuarioPeloNomeLogin(usuarioNomeLogin) != null) {
            return true;
        }

        return false;
    }
}
