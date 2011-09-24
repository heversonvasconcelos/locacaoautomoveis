/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author heverson
 */
@Entity
@Table(name = "TB_MARCA_AUTOMOVEL")
@NamedQuery(name = "MarcaAutomovel.buscarMarcaAutomovelPelaDescricao",
query = "SELECT marcauto FROM MarcaAutomovel AS marcauto WHERE marcauto.descricao = :descricao")
public class MarcaAutomovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String descricao;
    @OneToMany(mappedBy = "marca")
    private List<ModeloAutomovel> modelos = new ArrayList<ModeloAutomovel>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ModeloAutomovel> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModeloAutomovel> modelos) {
        this.modelos = modelos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarcaAutomovel other = (MarcaAutomovel) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "MarcaAutomovel{" + "id=" + id + ", descricao=" + descricao + '}';
    }
}
