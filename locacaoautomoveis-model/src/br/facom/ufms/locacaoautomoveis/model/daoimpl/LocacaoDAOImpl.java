/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.LocacaoDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.types.NamedQueryParameter;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.util.List;

/**
 *
 * @author heverson
 */
public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Long> implements LocacaoDAO {

    @Override
    public Class<Locacao> getDomainClass() {
        return Locacao.class;
    }

    @Override
    public List<Locacao> buscarLocacoesPeloStatus(Status status) {
        String namedQuery = "Locacao.buscarLocacoesPeloStatus";
        NamedQueryParameter parameter = new NamedQueryParameter("status", status);
        List<Locacao> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }

    @Override
    public List<Locacao> buscarLocacoesStatusFechadoPagamentoNaoRealizado() {
        String namedQuery = "Locacao.buscarLocacoesStatusFechadoPagamentoNaoRealizado";
        NamedQueryParameter parameter = new NamedQueryParameter("statusFechado", Status.FECHADO);
        List<Locacao> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }
}
