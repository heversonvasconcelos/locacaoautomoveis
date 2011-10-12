/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test;

import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.model.test.utils.PrintList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class ClienteDAOTest extends PrintList {

    private ClienteDAO clienteDAO = new ClienteDAOImpl();

    @Test
    public void testeListaTodosClientes() {
        List<Cliente> clienteList = clienteDAO.list();

        printList(clienteList, "TodosClientes");
    }

    @Test
    public void testeSalvarClienteFisico() {
        Cliente clienteFisico00 = new Cliente();
        clienteFisico00.setNome("Mario João Bandeiras");
        clienteFisico00.setEmail("mario.bandeiras@email.com.br");
        clienteFisico00.setCpfcnpj("17526159304");
        clienteDAO.create(clienteFisico00);
        Assert.assertNotNull(clienteFisico00);

        Cliente clienteFisico01 = new Cliente();
        clienteFisico01.setNome("Antônio Carlos Moura");
        clienteFisico01.setEmail("antonio.moura@email.com.br");
        clienteFisico01.setCpfcnpj("22023987679");
        clienteDAO.create(clienteFisico01);
        Assert.assertNotNull(clienteFisico01);

        Cliente clienteFisico02 = new Cliente();
        clienteFisico02.setNome("Gustavo Gomes Ferreira");
        clienteFisico02.setEmail("gustavo.ferreira@email.com.br");
        clienteFisico02.setCpfcnpj("01882241819");
        clienteDAO.create(clienteFisico02);
        Assert.assertNotNull(clienteFisico02);
    }

    @Test
    public void testeSalvarClienteJuridico() {
        Cliente clienteJuridico00 = new Cliente();
        clienteJuridico00.setNome("Construtora Bandeiras");
        clienteJuridico00.setEmail("construtorabandeiras@construtorabandeiras.com.br");
        clienteJuridico00.setCpfcnpj("51633018000161");
        clienteDAO.create(clienteJuridico00);
        Assert.assertNotNull(clienteJuridico00);

        Cliente clienteJuridico01 = new Cliente();
        clienteJuridico01.setNome("Nexus Ltda");
        clienteJuridico01.setEmail("nexus@nexus.com.br");
        clienteJuridico01.setCpfcnpj("36041411000172");
        clienteDAO.create(clienteJuridico01);
        Assert.assertNotNull(clienteJuridico01);

        Cliente clienteJuridico02 = new Cliente();
        clienteJuridico02.setNome("Jardel AutoCentro");
        clienteJuridico02.setEmail("jardelautocentro@jardelautocentro.com.br");
        clienteJuridico02.setCpfcnpj("80373496000188");
        clienteDAO.create(clienteJuridico02);
        Assert.assertNotNull(clienteJuridico02);
    }

    @Test
    public void testeBuscarClienteFisico() {
        String cpf = "22023987679";
        Cliente clienteFisico = clienteDAO.buscarClientePeloCPFCNPJ(cpf);

        System.out.println("----------------------------------------------");
        System.out.println("CPF Cliente buscado: " + cpf);
        System.out.println("CPF Cliente encontrado: " + clienteFisico);
    }

    @Test
    public void testeBuscarClienteJuridico() {
        String cnpj = "36041411000172";
        Cliente clienteJuridico = clienteDAO.buscarClientePeloCPFCNPJ(cnpj);

        System.out.println("----------------------------------------------");
        System.out.println("CNPJ Cliente buscado: " + cnpj);
        System.out.println("CNPJ Cliente encontrado: " + clienteJuridico);
    }
}
