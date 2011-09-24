/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.entities.MarcaAutomovel;
import br.facom.ufms.locacaoautomoveis.utils.EntityManagerUtil;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author heverson
 */
public class MarcaAutomovelDAOImpl extends GenericDAOImpl<MarcaAutomovel, Integer> implements MarcaAutomovelDAO {

    @Override
    public Class<MarcaAutomovel> getDomainClass() {
        return MarcaAutomovel.class;
    }

    @Override
    public MarcaAutomovel buscarMarcaAutomovelPelaDescricao(String descricao) {
        Query query = EntityManagerUtil.createNamedQuery("MarcaAutomovel.buscarMarcaAutomovelPelaDescricao");
        query.setParameter("descricao", descricao);

        try {
            return (MarcaAutomovel) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }

    }
}
