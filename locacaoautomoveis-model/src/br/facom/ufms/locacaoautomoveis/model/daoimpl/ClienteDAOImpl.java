/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.types.QueryParameter;

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
    public Cliente buscarClientePeloCPFCNPJ(String cpfcnpj) {
        String namedQuery = "Cliente.buscarClientePeloCPFCNPJ";
        QueryParameter parameter = new QueryParameter("cpfcnpj", cpfcnpj);
        Cliente clienteFisico = (Cliente) executeNamedQuerySingleResult(namedQuery, parameter);

        return clienteFisico;
    }
}
