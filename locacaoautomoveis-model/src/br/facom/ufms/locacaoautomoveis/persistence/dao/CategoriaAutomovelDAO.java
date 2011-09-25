/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.dao;

import br.facom.ufms.locacaoautomoveis.persistence.entities.CategoriaAutomovel;

/**
 *
 * @author heverson.vasconcelos
 */
public interface CategoriaAutomovelDAO extends GenericDAO<CategoriaAutomovel, Integer> {

    public CategoriaAutomovel buscarCategoriaAutomovelPelaDescricao(String descricao);
}
