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
import br.facom.ufms.locacaoautomoveis.model.entities.ItemLocacao;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.service.LocacaoService;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class LocacaoServiceTest extends PrintList {
    
    private AutomovelDAO automovelDAO = new AutomovelDAOImpl();
    private LocacaoDAO locacaoDAO = new LocacaoDAOImpl();
    private LocacaoService locacaoService = new LocacaoService();
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

    @Test
    public void testeAbrirLocacao() {
        boolean locacaoSalvaComSucesso;

        /* Locacao 00 */
        List<ItemLocacao> itensLocacao00 = new ArrayList<ItemLocacao>();
        ItemLocacao itemLocacao00 = new ItemLocacao();
        Automovel automovel00 = automoveis.get(2);
        itemLocacao00.setAutomovel(automovel00);
        Cliente cliente00 = clientes.get(5);
        itensLocacao00.add(itemLocacao00);
        locacaoSalvaComSucesso = locacaoService.locar(itensLocacao00, cliente00);
        Assert.assertTrue(locacaoSalvaComSucesso);

        /* Locacao 01 */
        List<ItemLocacao> itensLocacao01 = new ArrayList<ItemLocacao>();
        ItemLocacao itemLocacao01 = new ItemLocacao();
        Automovel automovel01 = automoveis.get(4);
        itemLocacao01.setAutomovel(automovel01);
        Cliente cliente01 = clientes.get(1);
        itensLocacao01.add(itemLocacao01);
        locacaoSalvaComSucesso = locacaoService.locar(itensLocacao01, cliente01);
        Assert.assertTrue(locacaoSalvaComSucesso);

        /* Locacao 02 */
        List<ItemLocacao> itensLocacao02 = new ArrayList<ItemLocacao>();
        ItemLocacao itemLocacao02 = new ItemLocacao();
        Automovel automovel02 = automoveis.get(0);
        itemLocacao02.setAutomovel(automovel02);
        Cliente cliente02 = clientes.get(2);
        itensLocacao02.add(itemLocacao02);
        locacaoSalvaComSucesso = locacaoService.locar(itensLocacao02, cliente02);
        Assert.assertTrue(locacaoSalvaComSucesso);
        
    }

//    @Test
    public void testeFecharLocacao() {
        boolean locacaoSalvaComSucesso;
        List<Locacao> locacaoList = locacaoDAO.list();
        
        Locacao locacao = locacaoList.get(1);
        ItemLocacao itemLocacao = locacao.getItensLocacao().get(0);
        itemLocacao.setStatus(Status.FECHADO);
        locacao.setPagamentoRealizado(true);
        locacaoSalvaComSucesso = locacaoService.finalizarLocacao(locacao);
        Assert.assertTrue(locacaoSalvaComSucesso);
    }
}
