/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.dao;

import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import java.util.List;

/**
 *
 * @author heverson.vasconcelos
 */
public interface AutomovelDAO extends GenericDAO<Automovel, Integer> {
    /*
     * TODO: metodo que realiza a busca uma lista automoveis utilizando
     * criterios de busca. Ex.: automoveis com categoria, marca e modelo especificos
     * 
     */

    public List<Automovel> buscarAutomoveisPelaDisponibilidade(boolean disponibilidade);
}
