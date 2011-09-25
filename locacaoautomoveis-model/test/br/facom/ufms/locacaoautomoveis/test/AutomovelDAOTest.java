/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.test;

import br.facom.ufms.locacaoautomoveis.persistence.dao.AutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.dao.CategoriaAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.dao.ModeloAutomovelDAO;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.AutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.CategoriaAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.ModeloAutomovelDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.entities.Automovel;
import br.facom.ufms.locacaoautomoveis.persistence.entities.CategoriaAutomovel;
import br.facom.ufms.locacaoautomoveis.persistence.entities.ModeloAutomovel;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class AutomovelDAOTest {

    private AutomovelDAO automovelDAO = new AutomovelDAOImpl();
    private CategoriaAutomovelDAO categoriaDAO = new CategoriaAutomovelDAOImpl();
    private ModeloAutomovelDAO modeloAutomovelDAO = new ModeloAutomovelDAOImpl();

    @Test
    public void testeListaTodosAutomoveis() {
        List<Automovel> automovelList = automovelDAO.list();

        printLista(automovelList);
    }

//    @Test
    public void testeSalvarAutomovel() {
        String descricaoModeloAutomovel;
        ModeloAutomovel modeloAutomovel;

        CategoriaAutomovel categoriaBasico = categoriaDAO.buscarCategoriaAutomovelPelaDescricao("Básico");
        CategoriaAutomovel categoriaUtilitario = categoriaDAO.buscarCategoriaAutomovelPelaDescricao("Utilitário");
        CategoriaAutomovel categoriaVan = categoriaDAO.buscarCategoriaAutomovelPelaDescricao("Van");

        Automovel automovel00 = new Automovel();
        automovel00.setAno(2011);
        automovel00.setPlaca("ABC0000");
        automovel00.setRenavam("000000000");
        automovel00.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Siena EX 1.0 mpi Fire 16v 4p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel00.setModelo(modeloAutomovel);
        automovelDAO.create(automovel00);

        Automovel automovel01 = new Automovel();
        automovel01.setAno(2011);
        automovel01.setPlaca("ABC0001");
        automovel01.setRenavam("000000001");
        automovel01.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Palio ELX 1.0 mpi Fire/ Fire Flex 8V 4p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel01.setModelo(modeloAutomovel);
        automovelDAO.create(automovel01);

        Automovel automovel02 = new Automovel();
        automovel02.setAno(2011);
        automovel02.setPlaca("ABC0002");
        automovel02.setRenavam("000000002");
        automovel02.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Uno Mille 1.0 Fire/ F.Flex/ ECONOMY 4p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel02.setModelo(modeloAutomovel);
        automovelDAO.create(automovel02);

        Automovel automovel03 = new Automovel();
        automovel03.setAno(2011);
        automovel03.setPlaca("ABC0003");
        automovel03.setRenavam("000000003");
        automovel03.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Fiesta 1.0 8V Flex 5p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel03.setModelo(modeloAutomovel);
        automovelDAO.create(automovel03);

        Automovel automovel04 = new Automovel();
        automovel04.setAno(2011);
        automovel04.setPlaca("ABC0004");
        automovel04.setRenavam("000000004");
        automovel04.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "KA Black 1.0 MPI 8v 65cv";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel04.setModelo(modeloAutomovel);
        automovelDAO.create(automovel04);

        Automovel automovel05 = new Automovel();
        automovel05.setAno(2011);
        automovel05.setPlaca("ABC0005");
        automovel05.setRenavam("000000005");
        automovel05.setCategoria(categoriaUtilitario);
        descricaoModeloAutomovel = "Ranger XLT 2.8 8v 135cv 4x4 CE TB Diesel";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel05.setModelo(modeloAutomovel);
        automovelDAO.create(automovel05);

        Automovel automovel06 = new Automovel();
        automovel06.setAno(2011);
        automovel06.setPlaca("ABC0006");
        automovel06.setRenavam("000000006");
        automovel06.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Celta Life 1.0 MPFI VHC 8V 5p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel06.setModelo(modeloAutomovel);
        automovelDAO.create(automovel05);

        Automovel automovel07 = new Automovel();
        automovel07.setAno(2011);
        automovel07.setPlaca("ABC0007");
        automovel07.setRenavam("000000007");
        automovel07.setCategoria(categoriaUtilitario);
        descricaoModeloAutomovel = "MONTANA 1.4 8V Conquest ECONOFLEX  2p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel07.setModelo(modeloAutomovel);
        automovelDAO.create(automovel07);

        Automovel automovel08 = new Automovel();
        automovel08.setAno(2011);
        automovel08.setPlaca("ABC0008");
        automovel08.setRenavam("000000008");
        automovel08.setCategoria(categoriaUtilitario);
        descricaoModeloAutomovel = "S10 Pick-Up Exec. 2.8 4x4 CD TB Int.Diesel";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel08.setModelo(modeloAutomovel);
        automovelDAO.create(automovel08);

        Automovel automovel09 = new Automovel();
        automovel09.setAno(2011);
        automovel09.setPlaca("ABC0009");
        automovel09.setRenavam("000000009");
        automovel09.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Fox 1.0 Mi Total Flex 8V 5p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel09.setModelo(modeloAutomovel);
        automovelDAO.create(automovel09);

        Automovel automovel10 = new Automovel();
        automovel10.setAno(2011);
        automovel10.setPlaca("ABC0010");
        automovel10.setRenavam("000000010");
        automovel10.setCategoria(categoriaBasico);
        descricaoModeloAutomovel = "Gol 1.0 Plus 8v 4p";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel10.setModelo(modeloAutomovel);
        automovelDAO.create(automovel10);

        Automovel automovel11 = new Automovel();
        automovel11.setAno(2011);
        automovel11.setPlaca("ABC0011");
        automovel11.setRenavam("000000011");
        automovel11.setCategoria(categoriaVan);
        descricaoModeloAutomovel = "Kombi Lotação 1.4 Mi Total Flex 8V";
        modeloAutomovel = modeloAutomovelDAO.buscarModeloAutomovelPelaDescricao(descricaoModeloAutomovel);
        automovel11.setModelo(modeloAutomovel);
        automovelDAO.create(automovel11);


    }

    public void printLista(List<Automovel> automovelList) {
        System.out.println("----------------------------------------------");
        for (Iterator<Automovel> it = automovelList.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
