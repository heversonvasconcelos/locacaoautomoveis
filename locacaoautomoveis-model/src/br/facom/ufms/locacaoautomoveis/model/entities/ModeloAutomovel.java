/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author heverson
 */
@Entity
@Table(name = "TB_MODELO_AUTOMOVEL")
@NamedQuery(name = "ModeloAutomovel.buscarModeloAutomovelPelaDescricao",
query = "SELECT modelauto FROM ModeloAutomovel AS modelauto WHERE modelauto.descricao = :descricao")
public class ModeloAutomovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "MARCA_FK")
    private MarcaAutomovel marca;

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

    public MarcaAutomovel getMarca() {
	return marca;
    }

    public void setMarca(MarcaAutomovel marca) {
	this.marca = marca;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final ModeloAutomovel other = (ModeloAutomovel) obj;
	if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	int hash = 5;
	hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
	return hash;
    }

    @Override
    public String toString() {
	return "ModeloAutomovel{" + "id=" + id + ", descricao=" + descricao + ", marca=" + marca + '}';
    }
}
