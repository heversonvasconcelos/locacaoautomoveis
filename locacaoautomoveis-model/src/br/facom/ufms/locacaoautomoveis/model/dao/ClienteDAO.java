/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.dao;

import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;

/**
 *
 * @author heverson.vasconcelos
 */
public interface ClienteDAO extends GenericDAO<Cliente, Long> {

    public Cliente buscarClientePeloCPFCNPJ(String cpfcnpj);
}
