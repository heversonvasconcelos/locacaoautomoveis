package br.facom.ufms.locacaoautomoveis.ui.controller;

import br.facom.ufms.locacaoautomoveis.model.dao.ClienteDAO;
import br.facom.ufms.locacaoautomoveis.model.daoimpl.ClienteDAOImpl;
import br.facom.ufms.locacaoautomoveis.model.entities.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
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

    public void salvarCliente() {
        if (cliente.getId() == null) {
            clienteDAO.create(cliente);
        } else {
            clienteDAO.update(cliente);
        }

    }
}
