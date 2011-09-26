/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import br.facom.ufms.locacaoautomoveis.model.types.NamedQueryParameter;

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
        NamedQueryParameter parameter = new NamedQueryParameter("descricao", descricao);
        ModeloAutomovel modeloAutomovel = (ModeloAutomovel) executeNamedQuerySingleResult(namedQuery, parameter);

        return modeloAutomovel;

    }
}
