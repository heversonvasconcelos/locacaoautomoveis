/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.dao;

import br.facom.ufms.locacaoautomoveis.persistence.entities.ModeloAutomovel;

/**
 *
 * @author heverson.vasconcelos
 */
public interface ModeloAutomovelDAO extends GenericDAO<ModeloAutomovel, Integer> {

    public ModeloAutomovel buscarModeloAutomovelPelaDescricao(String descricao);
}
