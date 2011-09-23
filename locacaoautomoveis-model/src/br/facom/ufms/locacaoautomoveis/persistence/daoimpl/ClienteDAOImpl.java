/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.persistence.entities.Cliente;
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
    public Cliente buscarClientePeloCPFCNPJ(String cpfcnpj) {
        Query query = EntityManagerUtil.createNamedQuery("Cliente.buscarClientePeloCPFCNPJ");
        query.setParameter("clienteCPFCNPJ", cpfcnpj);

        try {
            return (Cliente) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
