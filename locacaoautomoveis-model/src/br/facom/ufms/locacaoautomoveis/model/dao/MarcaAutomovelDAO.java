/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.dao;

import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;

/**
 *
 * @author heverson.vasconcelos
 */
public interface MarcaAutomovelDAO extends GenericDAO<MarcaAutomovel, Integer> {

    public MarcaAutomovel buscarMarcaAutomovelPelaDescricao(String descricao);
}
