/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.dao;

import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.entities.ClienteFisico;
import br.facom.ufms.locacaoautomoveis.model.entities.ClienteJuridico;

/**
 *
 * @author heverson.vasconcelos
 */
public interface ClienteDAO extends GenericDAO<Cliente, Long> {

    public ClienteFisico buscarClienteFisico(String cpf);

    public ClienteJuridico buscarClienteJuridico(String cnpj);
}
