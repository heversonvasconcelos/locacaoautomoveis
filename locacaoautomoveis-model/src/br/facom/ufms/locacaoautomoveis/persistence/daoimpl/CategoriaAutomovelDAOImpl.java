/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.entities.CategoriaAutomovel;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author heverson
 */
public class CategoriaAutomovelDAOImpl extends GenericDAOImpl< CategoriaAutomovel, Integer> implements CategoriaAutomovelDAO {

    @Override
    public Class<CategoriaAutomovel> getDomainClass() {
        return CategoriaAutomovel.class;
    }

    @Override
    public CategoriaAutomovel buscarCategoriaAutomovelPelaDescricao(String descricao) {
        Query query = createNamedQuery("CategoriaAutomovel.buscarCategoriaAutomovelPelaDescricao");
        query.setParameter("descricao", descricao);

        try {
            return (CategoriaAutomovel) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }
}
