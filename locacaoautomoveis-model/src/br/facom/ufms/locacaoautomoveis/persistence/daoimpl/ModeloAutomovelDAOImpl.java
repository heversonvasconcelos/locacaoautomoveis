/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.entities.ModeloAutomovel;
import br.facom.ufms.locacaoautomoveis.utils.EntityManagerUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author heverson
 */
public class ModeloAutomovelDAOImpl extends GenericDAOImpl<ModeloAutomovel, Integer> implements ModeloAutomovelDAO {

    @Override
    public Class<ModeloAutomovel> getDomainClass() {
        return ModeloAutomovel.class;
    }

    @Override
    public ModeloAutomovel buscarModeloAutomovelPelaDescricao(String descricao) {
        Query query = createNamedQuery("ModeloAutomovel.buscarModeloAutomovelPelaDescricao");
        query.setParameter("descricao", descricao);

        try {
            return (ModeloAutomovel) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }
}
