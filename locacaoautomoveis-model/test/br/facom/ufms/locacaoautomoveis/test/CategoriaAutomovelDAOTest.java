/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.test;

import br.facom.ufms.locacaoautomoveis.persistence.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.CategoriaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.entities.CategoriaAutomovel;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class CategoriaAutomovelDAOTest {

    private CategoriaAutomovelDAO categoriaAutomovelDAO = new CategoriaAutomovelDAOImpl();

    @Test
    public void testeListaTodasCategoriasAutomovel() {
        List<CategoriaAutomovel> categoriaAutomovelList = categoriaAutomovelDAO.list();

        printLista(categoriaAutomovelList);
    }

//    @Test
    public void testeSalvarCategoriaAutomovel() {
        CategoriaAutomovel categoriaAutomovel00 = new CategoriaAutomovel();
        categoriaAutomovel00.setDescricao("Básico");
        categoriaAutomovel00.setValorKM(2.00);
        categoriaAutomovel00.setValorDiario(80.00);
        categoriaAutomovel00.setValorSemanal(180.00);
        categoriaAutomovel00.setValorMensal(600.00);
        categoriaAutomovelDAO.create(categoriaAutomovel00);

        CategoriaAutomovel categoriaAutomovel01 = new CategoriaAutomovel();
        categoriaAutomovel01.setDescricao("Esportivo");
        categoriaAutomovel01.setValorKM(5.00);
        categoriaAutomovel01.setValorDiario(100.00);
        categoriaAutomovel01.setValorSemanal(200.00);
        categoriaAutomovel01.setValorMensal(620.00);
        categoriaAutomovelDAO.create(categoriaAutomovel01);

        CategoriaAutomovel categoriaAutomovel02 = new CategoriaAutomovel();
        categoriaAutomovel02.setDescricao("Familiar");
        categoriaAutomovel02.setValorKM(3.00);
        categoriaAutomovel02.setValorDiario(90.00);
        categoriaAutomovel02.setValorSemanal(190.00);
        categoriaAutomovel02.setValorMensal(610.00);
        categoriaAutomovelDAO.create(categoriaAutomovel02);

        CategoriaAutomovel categoriaAutomovel03 = new CategoriaAutomovel();
        categoriaAutomovel03.setDescricao("Luxo");
        categoriaAutomovel03.setValorKM(8.00);
        categoriaAutomovel03.setValorDiario(110.00);
        categoriaAutomovel03.setValorSemanal(210.00);
        categoriaAutomovel03.setValorMensal(630.00);
        categoriaAutomovelDAO.create(categoriaAutomovel03);

        CategoriaAutomovel categoriaAutomovel04 = new CategoriaAutomovel();
        categoriaAutomovel04.setDescricao("Utilitário");
        categoriaAutomovel04.setValorKM(6.00);
        categoriaAutomovel04.setValorDiario(90.00);
        categoriaAutomovel04.setValorSemanal(180.00);
        categoriaAutomovel04.setValorMensal(600.00);
        categoriaAutomovelDAO.create(categoriaAutomovel04);

        CategoriaAutomovel categoriaAutomovel05 = new CategoriaAutomovel();
        categoriaAutomovel05.setDescricao("Van");
        categoriaAutomovel05.setValorKM(5.00);
        categoriaAutomovel05.setValorDiario(80.00);
        categoriaAutomovel05.setValorSemanal(180.00);
        categoriaAutomovel05.setValorMensal(600.00);
        categoriaAutomovelDAO.create(categoriaAutomovel05);

    }

    @Test
    public void buscarMarcaAutomovelPelaDescricao() {
        String categoriaAutomovelDescricao = "Utilitário";
        CategoriaAutomovel categoriaAutomovel = categoriaAutomovelDAO.buscarCategoriaAutomovelPelaDescricao(categoriaAutomovelDescricao);

        System.out.println("----------------------------------------------");
        System.out.println("Categoria automovel buscada: " + categoriaAutomovelDescricao);
        System.out.println("Categoria automovel encontrada: " + categoriaAutomovel);
    }

    public void printLista(List<CategoriaAutomovel> categoriaAutomovelList) {
        System.out.println("----------------------------------------------");
        for (Iterator<CategoriaAutomovel> it = categoriaAutomovelList.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
