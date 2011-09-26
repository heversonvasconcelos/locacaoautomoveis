/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test;

import br.facom.ufms.locacaoautomoveis.model.dao.MarcaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.MarcaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ModeloAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.MarcaAutomovel;
import br.facom.ufms.locacaoautomoveis.model.entities.ModeloAutomovel;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class ModeloAutomovelDAOTest extends PrintList {

    private MarcaAutomovelDAO marcaAutomovelDAO = new MarcaAutomovelDAOImpl();
    private ModeloAutomovelDAO modeloAutomovelDAO = new ModeloAutomovelDAOImpl();

    @Test
    public void testeListaTodosModeloAutomovel() {
        List<ModeloAutomovel> modeloAutomovelList = modeloAutomovelDAO.list();

        printList(modeloAutomovelList, "TodosModelosAutomovel");
    }

//    @Test
    public void testeSalvarMarcaModeloAutomovel() {
        //FIAT
        MarcaAutomovel marcaAutomovel00 = marcaAutomovelDAO.buscarMarcaAutomovelPelaDescricao("FIAT");

        ModeloAutomovel modeloAutomovel00 = new ModeloAutomovel();
        modeloAutomovel00.setDescricao("Siena EX 1.0 mpi Fire 16v 4p");
        modeloAutomovel00.setMarca(marcaAutomovel00);
        modeloAutomovelDAO.create(modeloAutomovel00);
        Assert.assertNotNull(modeloAutomovel00.getId());

        ModeloAutomovel modeloAutomovel01 = new ModeloAutomovel();
        modeloAutomovel01.setDescricao("Palio ELX 1.0 mpi Fire/ Fire Flex 8V 4p");
        modeloAutomovel01.setMarca(marcaAutomovel00);
        modeloAutomovelDAO.create(modeloAutomovel01);
        Assert.assertNotNull(modeloAutomovel01.getId());

        ModeloAutomovel modeloAutomovel02 = new ModeloAutomovel();
        modeloAutomovel02.setDescricao("Uno Mille 1.0 Fire/ F.Flex/ ECONOMY 4p");
        modeloAutomovel02.setMarca(marcaAutomovel00);
        modeloAutomovelDAO.create(modeloAutomovel02);
        Assert.assertNotNull(modeloAutomovel02.getId());

        //FORD
        MarcaAutomovel marcaAutomovel01 = marcaAutomovelDAO.buscarMarcaAutomovelPelaDescricao("FORD");

        ModeloAutomovel modeloAutomovel03 = new ModeloAutomovel();
        modeloAutomovel03.setDescricao("Fiesta 1.0 8V Flex 5p");
        modeloAutomovel03.setMarca(marcaAutomovel01);
        modeloAutomovelDAO.create(modeloAutomovel03);
        Assert.assertNotNull(modeloAutomovel03.getId());

        ModeloAutomovel modeloAutomovel04 = new ModeloAutomovel();
        modeloAutomovel04.setDescricao("KA Black 1.0 MPI 8v 65cv");
        modeloAutomovel04.setMarca(marcaAutomovel01);
        modeloAutomovelDAO.create(modeloAutomovel04);
        Assert.assertNotNull(modeloAutomovel04.getId());

        ModeloAutomovel modeloAutomovel05 = new ModeloAutomovel();
        modeloAutomovel05.setDescricao("Ranger XLT 2.8 8v 135cv 4x4 CE TB Diesel");
        modeloAutomovel05.setMarca(marcaAutomovel01);
        modeloAutomovelDAO.create(modeloAutomovel05);
        Assert.assertNotNull(modeloAutomovel05.getId());

        //GM-Chevrolet
        MarcaAutomovel marcaAutomovel02 = marcaAutomovelDAO.buscarMarcaAutomovelPelaDescricao("GM-Chevrolet");

        ModeloAutomovel modeloAutomovel06 = new ModeloAutomovel();
        modeloAutomovel06.setDescricao("Celta Life 1.0 MPFI VHC 8V 5p");
        modeloAutomovel06.setMarca(marcaAutomovel02);
        modeloAutomovelDAO.create(modeloAutomovel06);
        Assert.assertNotNull(modeloAutomovel06.getId());

        ModeloAutomovel modeloAutomovel07 = new ModeloAutomovel();
        modeloAutomovel07.setDescricao("MONTANA 1.4 8V Conquest ECONOFLEX  2p");
        modeloAutomovel07.setMarca(marcaAutomovel02);
        modeloAutomovelDAO.create(modeloAutomovel07);
        Assert.assertNotNull(modeloAutomovel07.getId());

        ModeloAutomovel modeloAutomovel08 = new ModeloAutomovel();
        modeloAutomovel08.setDescricao("S10 Pick-Up Exec. 2.8 4x4 CD TB Int.Diesel");
        modeloAutomovel08.setMarca(marcaAutomovel02);
        modeloAutomovelDAO.create(modeloAutomovel08);
        Assert.assertNotNull(modeloAutomovel08.getId());

        //VW-Volkswagen
        MarcaAutomovel marcaAutomovel03 = marcaAutomovelDAO.buscarMarcaAutomovelPelaDescricao("VW-Volkswagen");

        ModeloAutomovel modeloAutomovel09 = new ModeloAutomovel();
        modeloAutomovel09.setDescricao("Fox 1.0 Mi Total Flex 8V 5p");
        modeloAutomovel09.setMarca(marcaAutomovel03);
        modeloAutomovelDAO.create(modeloAutomovel09);
        Assert.assertNotNull(modeloAutomovel09.getId());

        ModeloAutomovel modeloAutomovel10 = new ModeloAutomovel();
        modeloAutomovel10.setDescricao("Gol 1.0 Plus 8v 4p");
        modeloAutomovel10.setMarca(marcaAutomovel03);
        modeloAutomovelDAO.create(modeloAutomovel10);
        Assert.assertNotNull(modeloAutomovel10.getId());

        ModeloAutomovel modeloAutomovel11 = new ModeloAutomovel();
        modeloAutomovel11.setDescricao("Kombi Lotação 1.4 Mi Total Flex 8V");
        modeloAutomovel11.setMarca(marcaAutomovel03);
        modeloAutomovelDAO.create(modeloAutomovel11);
        Assert.assertNotNull(modeloAutomovel11.getId());


    }

    @Test
    public void buscarModeloAutomovelPelaDescricao() {
        String modeloAutomovelDescricao = "KA Black 1.0 MPI 8v 65cv";
        ModeloAutomovel modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(modeloAutomovelDescricao);

        System.out.println("----------------------------------------------");
        System.out.println("Modelo automovel buscado: " + modeloAutomovelDescricao);
        System.out.println("Modelo automovel encontrado: " + modeloAutomovel);
        Assert.assertNotNull(modeloAutomovel.getId());
    }
}
