/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.daoimpl;

import br.facom.ufms.locacaoautomoveis.persistence.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.entities.Automovel;
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
}
