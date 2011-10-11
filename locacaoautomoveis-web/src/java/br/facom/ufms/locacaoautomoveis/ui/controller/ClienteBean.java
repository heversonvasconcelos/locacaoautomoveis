package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import br.facom.ufms.locacaoautomoveis.ui.util.Constantes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private ClienteDAO clienteDAO;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        clienteDAO = new ClienteDAOImpl();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return clienteDAO.list();
    }

    public String novoCliente() {
        cliente = new Cliente();

        return Constantes.PAGE_CLIENTE_FORM;
    }

    public String salvarCliente() {
        if (cliente.getId() == null) {
            clienteDAO.create(cliente);
        } else {
            clienteDAO.update(cliente);
        }

        return Constantes.PAGE_CLIENTES;
    }
}
