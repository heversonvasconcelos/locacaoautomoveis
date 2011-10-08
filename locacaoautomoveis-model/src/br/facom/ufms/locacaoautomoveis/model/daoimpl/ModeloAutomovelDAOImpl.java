/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import br.facom.ufms.locacaoautomoveis.model.types.QueryParameter;

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
        String namedQuery = "ModeloAutomovel.buscarModeloAutomovelPelaDescricao";
        QueryParameter parameter = new QueryParameter("descricao", descricao);
        ModeloAutomovel modeloAutomovel = (ModeloAutomovel) executeNamedQuerySingleResult(namedQuery, parameter);

        return modeloAutomovel;

    }
}
