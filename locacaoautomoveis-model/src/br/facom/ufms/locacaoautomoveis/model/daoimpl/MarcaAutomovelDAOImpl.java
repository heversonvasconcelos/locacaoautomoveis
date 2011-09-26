/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.types.NamedQueryParameter;

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
        String namedQuery = "MarcaAutomovel.buscarMarcaAutomovelPelaDescricao";
        NamedQueryParameter parameter = new NamedQueryParameter("descricao", descricao);
        MarcaAutomovel marcaAutomovel = (MarcaAutomovel) executeNamedQuerySingleResult(namedQuery, parameter);

        return marcaAutomovel;

    }
}
