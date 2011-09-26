/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.CategoriaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.types.NamedQueryParameter;

/**
 *
 * @author heverson
 */
public class CategoriaAutomovelDAOImpl extends GenericDAOImpl<CategoriaAutomovel, Integer> implements CategoriaAutomovelDAO {

    @Override
    public Class<CategoriaAutomovel> getDomainClass() {
        return CategoriaAutomovel.class;
    }

    @Override
    public CategoriaAutomovel buscarCategoriaAutomovelPelaDescricao(String descricao) {
        String namedQuery = "CategoriaAutomovel.buscarCategoriaAutomovelPelaDescricao";
        NamedQueryParameter parameter = new NamedQueryParameter("descricao", descricao);
        CategoriaAutomovel categoriaAutomovel = executeNamedQuerySingleResult(namedQuery, parameter);

        return categoriaAutomovel;

    }
}
