/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.service;

import br.facom.ufms.locacaoautomoveis.model.dao.LocacaoDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.LocacaoDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.entities.ItemLocacao;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author heverson
 */
public class LocacaoService {

    private LocacaoDAO locacaoDAO = new LocacaoDAOImpl();

    public boolean locar(List<ItemLocacao> itensLocacao, Cliente cliente) {
        if (itensLocacao != null && !itensLocacao.isEmpty() && cliente != null) {
            Locacao locacao = new Locacao();
            locacao.setCliente(cliente);
            locacao.setDataHoraAbertura(Calendar.getInstance().getTime());
            atualizaDisponibilidadeAutomoveis(itensLocacao, false);
            locacao.setItensLocacao(itensLocacao);
            atualizaPonteirosLocacaoItensLocacao(locacao, itensLocacao);

            locacaoDAO.create(locacao);
            if (locacaoDAO.retrieve(locacao.getId()) != null) {
                return true;
            }
        }

        return false;
    }

    public boolean finalizarLocacao(Locacao locacao) {
        List<ItemLocacao> itensLocacao = locacao.getItensLocacao();

        if (itensLocacao != null && !itensLocacao.isEmpty()) {
            if (verificarSeTodosOsItensLocacaoEstaoFechados(itensLocacao)) {
                atualizaDisponibilidadeAutomoveis(itensLocacao, true);
                locacao.setDataHoraFechamento(Calendar.getInstance().getTime());
                locacao.setStatus(Status.FECHADO);

                Locacao locacaoFinalizada = locacaoDAO.update(locacao);
                if (locacaoFinalizada != null && locacaoFinalizada.getStatus() == Status.FECHADO) {
                    return true;
                }
            }
        }

        return false;
    }

    private void atualizaDisponibilidadeAutomoveis(List<ItemLocacao> itensLocacao, boolean disponibilidade) {
        for (Iterator<ItemLocacao> it = itensLocacao.iterator(); it.hasNext();) {
            Automovel automovel = it.next().getAutomovel();
            automovel.setDisponivel(disponibilidade);
        }
    }

    private void atualizaPonteirosLocacaoItensLocacao(Locacao locacao, List<ItemLocacao> itensLocacao) {
        for (Iterator<ItemLocacao> it = itensLocacao.iterator(); it.hasNext();) {
            ItemLocacao itemLocacao = it.next();
            itemLocacao.setLocacao(locacao);
        }
    }

    /**
     * Método para verificar se todos os itens da locacao estao fechados
     */
    private boolean verificarSeTodosOsItensLocacaoEstaoFechados(List<ItemLocacao> itensLocacao) {

        for (Iterator<ItemLocacao> it = itensLocacao.iterator(); it.hasNext();) {
            if (it.next().getStatus() != Status.FECHADO) {
                return false;
            }
        }

        return true;
    }
}
