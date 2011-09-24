/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.persistence.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.persistence.entities.ClienteFisico;
import br.facom.ufms.locacaoautomoveis.persistence.entities.ClienteJuridico;
import br.facom.ufms.locacaoautomoveis.utils.EntityManagerUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
        Query query = EntityManagerUtil.createNamedQuery("Cliente.buscarClientePeloCPF");
        query.setParameter("cpf", cpf);

        try {
            return (ClienteFisico) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public ClienteJuridico buscarClienteJuridico(String cnpj) {
        Query query = EntityManagerUtil.createNamedQuery("Cliente.buscarClientePeloCNPJ");
        query.setParameter("cnpj", cnpj);

        try {
            return (ClienteJuridico) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
