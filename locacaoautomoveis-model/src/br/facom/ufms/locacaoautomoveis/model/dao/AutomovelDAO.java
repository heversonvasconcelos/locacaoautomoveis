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

    public List<Automovel> buscarAutomoveisPelaDisponibilidade(boolean disponibilidade);
}
