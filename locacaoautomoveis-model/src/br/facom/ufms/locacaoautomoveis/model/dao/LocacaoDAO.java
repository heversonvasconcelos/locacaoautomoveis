/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.dao;

import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.util.List;

/**
 *
 * @author heverson.vasconcelos
 */
public interface LocacaoDAO extends GenericDAO<Locacao, Long> {

    public List<Locacao> buscarLocacoesPeloStatus(Status status);
    
    public List<Locacao> buscarLocacoesStatusFechadoPagamentoNaoRealizado();
}
