/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test;

import br.facom.ufms.locacaoautomoveis.model.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.LocacaoDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.AutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.LocacaoDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class LocacaoDAOTest extends PrintList {

    private AutomovelDAO automovelDAO = new AutomovelDAOImpl();
    private LocacaoDAO locacaoDAO = new LocacaoDAOImpl();
    private ClienteDAO clienteDAO = new ClienteDAOImpl();
    private List<Automovel> automoveis = automovelDAO.list();
    private List<Cliente> clientes = clienteDAO.list();

    @Test
    public void testeListarLocacoes() {
        List<Locacao> locacaoList = locacaoDAO.list();

        printList(locacaoList, "TodasLocacoes");
    }

    @Test
    public void testeListarLocacoesAbertas() {
        List<Locacao> locacaoList = locacaoDAO.buscarLocacoesPeloStatus(Status.ABERTO);

        printList(locacaoList, "LocacoesAbertas");
    }

    @Test
    public void testeListarLocacoesFechadas() {
        List<Locacao> locacaoList = locacaoDAO.buscarLocacoesPeloStatus(Status.FECHADO);

        printList(locacaoList, "LocacoesFechadas");
    }

    @Test
    public void testeListarLocacoesFechadasPagamentoNaoRealizado() {
        List<Locacao> locacaoList = locacaoDAO.buscarLocacoesStatusFechadoPagamentoNaoRealizado();

        printList(locacaoList, "LocacoesFechadasPagamentoNaoRealizado");
    }

//    @Test
    public void testeAbrirLocacao() {
        /* Locacao 00 */
        Locacao locacao00 = new Locacao();
        Cliente cliente00 = clientes.get(2);
        Automovel automovel00 = automoveis.get(0);

        locacao00.setCliente(cliente00);
        locacao00.setAutomovel(automovel00);

        locacaoDAO.create(locacao00);
        Assert.assertNotNull(locacao00.getId());

        /* Locacao 01 */
        Locacao locacao01 = new Locacao();
        Cliente cliente01 = clientes.get(2);
        Automovel automovel01 = automoveis.get(0);

        locacao01.setCliente(cliente01);
        locacao01.setAutomovel(automovel01);

        locacaoDAO.create(locacao01);
        Assert.assertNotNull(locacao01.getId());

        /* Locacao 02 */
        Locacao locacao02 = new Locacao();
        Cliente cliente02 = clientes.get(2);
        Automovel automovel02 = automoveis.get(0);

        locacao02.setCliente(cliente02);
        locacao02.setAutomovel(automovel02);

        locacaoDAO.create(locacao02);
        Assert.assertNotNull(locacao02.getId());

    }

//    @Test
    public void testeFecharLocacao() {
        boolean locacaoSalvaComSucesso;
        List<Locacao> locacaoList = locacaoDAO.list();

        Locacao locacao = locacaoList.get(1);
        locacao.setPagamentoRealizado(true);
        locacaoSalvaComSucesso = locacaoDAO.finalizarLocacao(locacao);
        Assert.assertTrue(locacaoSalvaComSucesso);
    }
}
