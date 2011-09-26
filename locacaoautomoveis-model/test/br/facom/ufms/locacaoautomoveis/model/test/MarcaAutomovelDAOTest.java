/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test;

import br.facom.ufms.locacaoautomoveis.model.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.MarcaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class MarcaAutomovelDAOTest extends PrintList {

    private MarcaAutomovelDAO marcaAutomovelDAO = new MarcaAutomovelDAOImpl();

    @Test
    public void testeListaTodasMarcaAutomovel() {
        List<MarcaAutomovel> marcaAutomovelList = marcaAutomovelDAO.list();

        printList(marcaAutomovelList, "TodasMarcasAutomovel");
    }

//    @Test
    public void testeSalvarMarcaAutomovel() {
        MarcaAutomovel marcaAutomovel00 = new MarcaAutomovel();
        marcaAutomovel00.setDescricao("FIAT");
        marcaAutomovelDAO.create(marcaAutomovel00);
        Assert.assertNotNull(marcaAutomovel00.getId());

        MarcaAutomovel marcaAutomovel01 = new MarcaAutomovel();
        marcaAutomovel01.setDescricao("FORD");
        marcaAutomovelDAO.create(marcaAutomovel01);
        Assert.assertNotNull(marcaAutomovel01.getId());

        MarcaAutomovel marcaAutomovel02 = new MarcaAutomovel();
        marcaAutomovel02.setDescricao("GM-Chevrolet");
        marcaAutomovelDAO.create(marcaAutomovel02);
        Assert.assertNotNull(marcaAutomovel02.getId());

        MarcaAutomovel marcaAutomovel03 = new MarcaAutomovel();
        marcaAutomovel03.setDescricao("RENAULT");
        marcaAutomovelDAO.create(marcaAutomovel03);
        Assert.assertNotNull(marcaAutomovel03.getId());

        MarcaAutomovel marcaAutomovel04 = new MarcaAutomovel();
        marcaAutomovel04.setDescricao("TOYOTA");
        marcaAutomovelDAO.create(marcaAutomovel04);
        Assert.assertNotNull(marcaAutomovel04.getId());

        MarcaAutomovel marcaAutomovel05 = new MarcaAutomovel();
        marcaAutomovel05.setDescricao("VW-Volkswagen");
        marcaAutomovelDAO.create(marcaAutomovel05);
        Assert.assertNotNull(marcaAutomovel05.getId());
    }

    @Test
    public void buscarMarcaAutomovelPelaDescricao() {
        String marcaAutomovelDescricao = "RENAULT";
        MarcaAutomovel marcaAutomovel = marcaAutomovelDAO.buscarMarcaAutomovelPelaDescricao(marcaAutomovelDescricao);

        System.out.println("----------------------------------------------");
        System.out.println("Marca automovel buscada: " + marcaAutomovelDescricao);
        System.out.println("Marca automovel encontrada: " + marcaAutomovel);
        Assert.assertNotNull(marcaAutomovel.getId());
    }

    @Test
    public void buscarTodosModelosPorMarcaAutomovel() {
        List<MarcaAutomovel> marcaAutomovelList = marcaAutomovelDAO.list();

        for (Iterator<MarcaAutomovel> it = marcaAutomovelList.iterator(); it.hasNext();) {
            MarcaAutomovel marcaAutomovel = it.next();
            String msg = "Modelos da marca: " + marcaAutomovel.getDescricao();
            printList(marcaAutomovel.getModelos(), msg);

        }

    }
}
