/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.test;

import br.facom.ufms.locacaoautomoveis.persistence.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.MarcaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.entities.MarcaAutomovel;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class MarcaAutomovelDAOTest {

    private MarcaAutomovelDAO marcaAutomovelDAO = new MarcaAutomovelDAOImpl();

    @Test
    public void testeListaTodasMarcaAutomovel() {
        List<MarcaAutomovel> marcaAutomovelList = marcaAutomovelDAO.list();

        printLista(marcaAutomovelList);
    }

//    @Test
    public void testeSalvarMarcaAutomovel() {
        MarcaAutomovel marcaAutomovel00 = new MarcaAutomovel();
        marcaAutomovel00.setDescricao("CITROEN");
        marcaAutomovelDAO.create(marcaAutomovel00);

        MarcaAutomovel marcaAutomovel01 = new MarcaAutomovel();
        marcaAutomovel01.setDescricao("FIAT");
        marcaAutomovelDAO.create(marcaAutomovel01);

        MarcaAutomovel marcaAutomovel02 = new MarcaAutomovel();
        marcaAutomovel02.setDescricao("FORD");
        marcaAutomovelDAO.create(marcaAutomovel02);

        MarcaAutomovel marcaAutomovel03 = new MarcaAutomovel();
        marcaAutomovel03.setDescricao("GM-Chevrolet");
        marcaAutomovelDAO.create(marcaAutomovel03);

        MarcaAutomovel marcaAutomovel04 = new MarcaAutomovel();
        marcaAutomovel04.setDescricao("HONDA");
        marcaAutomovelDAO.create(marcaAutomovel04);

        MarcaAutomovel marcaAutomovel05 = new MarcaAutomovel();
        marcaAutomovel05.setDescricao("HYUNDAI");
        marcaAutomovelDAO.create(marcaAutomovel05);

        MarcaAutomovel marcaAutomovel06 = new MarcaAutomovel();
        marcaAutomovel06.setDescricao("MITSUBISHI");
        marcaAutomovelDAO.create(marcaAutomovel06);

        MarcaAutomovel marcaAutomovel07 = new MarcaAutomovel();
        marcaAutomovel07.setDescricao("NISSAN");
        marcaAutomovelDAO.create(marcaAutomovel07);

        MarcaAutomovel marcaAutomovel08 = new MarcaAutomovel();
        marcaAutomovel08.setDescricao("PEUGEOT");
        marcaAutomovelDAO.create(marcaAutomovel08);

        MarcaAutomovel marcaAutomovel09 = new MarcaAutomovel();
        marcaAutomovel09.setDescricao("RENAULT");
        marcaAutomovelDAO.create(marcaAutomovel09);

        MarcaAutomovel marcaAutomovel10 = new MarcaAutomovel();
        marcaAutomovel10.setDescricao("TOYOTA");
        marcaAutomovelDAO.create(marcaAutomovel10);

        MarcaAutomovel marcaAutomovel11 = new MarcaAutomovel();
        marcaAutomovel11.setDescricao("VW-Volkswagen");
        marcaAutomovelDAO.create(marcaAutomovel11);
    }

    @Test
    public void buscarMarcaAutomovelPelaDescricao() {
        String marcaAutomovelDescricao = "RENAULT";
        MarcaAutomovel marcaAutomovel = marcaAutomovelDAO.buscarMarcaAutomovelPelaDescricao(marcaAutomovelDescricao);

        System.out.println("----------------------------------------------");
        System.out.println("Marca automovel buscada: " + marcaAutomovelDescricao);
        System.out.println("Marca automovel encontrada: " + marcaAutomovel);
    }

    public void printLista(List<MarcaAutomovel> marcaAutomovelList) {
        System.out.println("----------------------------------------------");
        for (Iterator<MarcaAutomovel> it = marcaAutomovelList.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
