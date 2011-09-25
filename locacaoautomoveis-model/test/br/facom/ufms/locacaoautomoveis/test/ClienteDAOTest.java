/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.test;

import br.facom.ufms.locacaoautomoveis.persistence.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.persistence.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.persistence.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.persistence.entities.ClienteFisico;
import br.facom.ufms.locacaoautomoveis.persistence.entities.ClienteJuridico;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author heverson
 */
public class ClienteDAOTest {

    private ClienteDAO clienteDAO = new ClienteDAOImpl();

    @Test
    public void testeListaTodosClientes() {
        List<Cliente> clienteList = clienteDAO.list();

        printLista(clienteList);
    }

//    @Test
    public void testeSalvarClienteFisico() {
        ClienteFisico clienteFisico00 = new ClienteFisico();
        clienteFisico00.setNome("Mario João Bandeiras");
        clienteFisico00.setEmail("mario.bandeiras@email.com.br");
        clienteFisico00.setCpf("12345678900");
        clienteDAO.create(clienteFisico00);

        ClienteFisico clienteFisico01 = new ClienteFisico();
        clienteFisico01.setNome("Antônio Carlos Moura");
        clienteFisico01.setEmail("antonio.moura@email.com.br");
        clienteFisico01.setCpf("12345678901");
        clienteDAO.create(clienteFisico01);

        ClienteFisico clienteFisico02 = new ClienteFisico();
        clienteFisico02.setNome("Gustavo Gomes Ferreira");
        clienteFisico02.setEmail("gustavo.ferreira@email.com.br");
        clienteFisico02.setCpf("12345678902");
        clienteDAO.create(clienteFisico02);
    }

//    @Test
    public void testeSalvarClienteJuridico() {
        ClienteJuridico clienteJuridico00 = new ClienteJuridico();
        clienteJuridico00.setNome("Construtora Bandeiras");
        clienteJuridico00.setEmail("construtorabandeiras@construtorabandeiras.com.br");
        clienteJuridico00.setCnpj("12345678900000");
        clienteDAO.create(clienteJuridico00);

        ClienteJuridico clienteJuridico01 = new ClienteJuridico();
        clienteJuridico01.setNome("Nexus Ltda");
        clienteJuridico01.setEmail("nexus@nexus.com.br");
        clienteJuridico01.setCnpj("12345678900001");
        clienteDAO.create(clienteJuridico01);

        ClienteJuridico clienteJuridico02 = new ClienteJuridico();
        clienteJuridico02.setNome("Jardel AutoCentro");
        clienteJuridico02.setEmail("jardelautocentro@jardelautocentro.com.br");
        clienteJuridico02.setCnpj("12345678900002");
        clienteDAO.create(clienteJuridico02);
    }

    @Test
    public void testeBuscarClienteFisico() {
        String cpf = "12345678902";
        ClienteFisico clienteFisico = clienteDAO.buscarClienteFisico(cpf);

        System.out.println("----------------------------------------------");
        System.out.println("CPF Cliente buscado: " + cpf);
        System.out.println("CPF Cliente encontrado: " + clienteFisico);
    }

    @Test
    public void testeBuscarClienteJuridico() {
        String cnpj = "12345678900001";
        ClienteJuridico clienteJuridico = clienteDAO.buscarClienteJuridico(cnpj);

        System.out.println("----------------------------------------------");
        System.out.println("CNPJ Cliente buscado: " + cnpj);
        System.out.println("CNPJ Cliente encontrado: " + clienteJuridico);
    }

    public void printLista(List<Cliente> clienteList) {
        System.out.println("----------------------------------------------");
        for (Iterator<Cliente> it = clienteList.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
