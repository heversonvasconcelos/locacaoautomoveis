package br.facom.ufms.locacaoautomoveis.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Classe entidade que representa um usuário do 
 * sistema. É composto por um nome de login e uma senha.
 * O atributo nome define a unicidade de um usuário, ou seja, para cada usuário
 * existirá somente um nome de login.
 *
 * Possui uma NamedQuery (Usuario.buscarUsuarioPeloNome) que será utilizada para consultar
 * um usuário a partir de um nome de login.
 *
 * @author heverson.vasconcelos
 */
@Entity
@Table(name = "TB_USUARIO")
@NamedQuery(name = "Usuario.buscarUsuarioPeloNomeLogin",
query = "SELECT u FROM Usuario AS u WHERE u.nomeLogin = :usuarioNomeLogin")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Nome de login do usuário
     */
    @Column(length = 20, nullable = false, unique = true)
    private String nomeLogin;
    /**
     * Senha do usuário
     */
    @Column(length = 64, nullable = false)
    private String senha;

    /*
     *
     * GETTERS e SETTERS
     *
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nome) {
        this.nomeLogin = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /*
     * Hashcode e equals foram sobrescritos para que um usuário possa ser
     * comparado com outro a partir do id e nome
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nomeLogin == null) ? (other.nomeLogin != null) : !this.nomeLogin.equals(other.nomeLogin)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.nomeLogin != null ? this.nomeLogin.hashCode() : 0);
        return hash;
    }

    /**
     * Método para retornar uma representação dos dados do usuário em modo texto
     * 
     * @return String contendo os dados do usuário
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nomeLogin=" + nomeLogin + '}';
    }
}
