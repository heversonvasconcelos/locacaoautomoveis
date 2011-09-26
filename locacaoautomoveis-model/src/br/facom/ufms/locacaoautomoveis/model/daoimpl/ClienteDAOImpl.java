/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.entities.ClienteFisico;
import br.facom.ufms.locacaoautomoveis.model.entities.ClienteJuridico;
import br.facom.ufms.locacaoautomoveis.model.types.NamedQueryParameter;

/**
 *
 * @author heverson
 */
public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Long> implements ClienteDAO {

    @Override
    public Class<Cliente> getDomainClass() {
        return Cliente.class;
    }

    @Override
    public ClienteFisico buscarClienteFisico(String cpf) {
        String namedQuery = "Cliente.buscarClientePeloCPF";
        NamedQueryParameter parameter = new NamedQueryParameter("cpf", cpf);
        ClienteFisico clienteFisico = (ClienteFisico) executeNamedQuerySingleResult(namedQuery, parameter);

        return clienteFisico;
    }

    @Override
    public ClienteJuridico buscarClienteJuridico(String cnpj) {
        String namedQuery = "Cliente.buscarClientePeloCNPJ";
        NamedQueryParameter parameter = new NamedQueryParameter("cnpj", cnpj);
        ClienteJuridico clienteJuridico = (ClienteJuridico) executeNamedQuerySingleResult(namedQuery, parameter);

        return clienteJuridico;
    }
}
