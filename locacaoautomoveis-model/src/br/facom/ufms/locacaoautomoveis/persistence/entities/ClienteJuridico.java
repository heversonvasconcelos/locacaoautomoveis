/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author heverson
 */
@Entity(name = "ClienteJuridico")
public class ClienteJuridico extends Cliente {

    @Column(length = 14, unique = true)
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteJuridico other = (ClienteJuridico) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.cnpj == null) ? (other.cnpj != null) : !this.cnpj.equals(other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ClienteJuridico{" + "id=" + id + ", cnpj=" + cnpj + '}';
    }
}
