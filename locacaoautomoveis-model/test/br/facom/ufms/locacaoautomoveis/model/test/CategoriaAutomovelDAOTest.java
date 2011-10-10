/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test;

import br.facom.ufms.locacaoautomoveis.model.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.CategoriaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.CategoriaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class CategoriaAutomovelDAOTest extends PrintList {

    private CategoriaAutomovelDAO categoriaAutomovelDAO = new CategoriaAutomovelDAOImpl();

    @Test
    public void testeListarTodasCategoriasAutomovel() {
        List<CategoriaAutomovel> categoriaAutomovelList = categoriaAutomovelDAO.list();

        printList(categoriaAutomovelList, "TodasCategoriasAutomovel");
    }

    @Test
    public void testeSalvarCategoriaAutomovel() {
        CategoriaAutomovel categoriaAutomovel00 = new CategoriaAutomovel();
        categoriaAutomovel00.setDescricao("Básico");
        categoriaAutomovel00.setValorDiario(80.00);
        categoriaAutomovelDAO.create(categoriaAutomovel00);
        Assert.assertNotNull(categoriaAutomovel00.getId());

        CategoriaAutomovel categoriaAutomovel01 = new CategoriaAutomovel();
        categoriaAutomovel01.setDescricao("Esportivo");
        categoriaAutomovel01.setValorDiario(100.00);
        categoriaAutomovelDAO.create(categoriaAutomovel01);
        Assert.assertNotNull(categoriaAutomovel01.getId());

        CategoriaAutomovel categoriaAutomovel02 = new CategoriaAutomovel();
        categoriaAutomovel02.setDescricao("Familiar");
        categoriaAutomovel02.setValorDiario(90.00);
        categoriaAutomovelDAO.create(categoriaAutomovel02);
        Assert.assertNotNull(categoriaAutomovel02.getId());

        CategoriaAutomovel categoriaAutomovel03 = new CategoriaAutomovel();
        categoriaAutomovel03.setDescricao("Luxo");
        categoriaAutomovel03.setValorDiario(110.00);
        categoriaAutomovelDAO.create(categoriaAutomovel03);
        Assert.assertNotNull(categoriaAutomovel03.getId());

        CategoriaAutomovel categoriaAutomovel04 = new CategoriaAutomovel();
        categoriaAutomovel04.setDescricao("Utilitário");
        categoriaAutomovel04.setValorDiario(90.00);
        categoriaAutomovelDAO.create(categoriaAutomovel04);
        Assert.assertNotNull(categoriaAutomovel04.getId());

        CategoriaAutomovel categoriaAutomovel05 = new CategoriaAutomovel();
        categoriaAutomovel05.setDescricao("Van");
        categoriaAutomovel05.setValorDiario(80.00);
        categoriaAutomovelDAO.create(categoriaAutomovel05);
        Assert.assertNotNull(categoriaAutomovel05.getId());

    }

    @Test
    public void testeBuscarMarcaAutomovelPelaDescricao() {
        String categoriaAutomovelDescricao = "Utilitário";
        CategoriaAutomovel categoriaAutomovel = categoriaAutomovelDAO.buscarCategoriaAutomovelPelaDescricao(categoriaAutomovelDescricao);

        System.out.println("----------------------------------------------");
        System.out.println("Categoria automovel buscada: " + categoriaAutomovelDescricao);
        System.out.println("Categoria automovel encontrada: " + categoriaAutomovel);
        Assert.assertNotNull(categoriaAutomovel.getId());
    }
}
