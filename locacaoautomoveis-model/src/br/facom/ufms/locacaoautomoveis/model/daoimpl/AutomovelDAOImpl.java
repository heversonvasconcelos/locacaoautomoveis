/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.model.types.QueryParameter;
import java.util.List;

/**
 *
 * @author heverson
 */
public class AutomovelDAOImpl extends GenericDAOImpl<Automovel, Integer> implements AutomovelDAO {

    @Override
    public Class<Automovel> getDomainClass() {
        return Automovel.class;
    }

    @Override
    public List<Automovel> buscarAutomoveisPelaDisponibilidade(boolean disponibilidade) {
        String namedQuery = "Automovel.buscarAutomoveisPelaDisponibilidade";
        QueryParameter parameter = new QueryParameter("disponibilidade", disponibilidade);
        List<Automovel> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;

    }
}
