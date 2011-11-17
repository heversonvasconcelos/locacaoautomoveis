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
@Table(name = "TB_AUTOMOVEL")
@NamedQuery(name = "Automovel.buscarAutomoveisPelaDisponibilidade",
query = "SELECT auto FROM Automovel AS auto WHERE auto.disponivel = :disponibilidade")
public class Automovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 7)
    private String placa;
    @Column(nullable = false, length = 9)
    private String renavam;
    @ManyToOne
    @JoinColumn(name = "MODELO_FK")
    private ModeloAutomovel modelo;
    @Column(scale = 4)
    private int ano;
    @Column
    private String cor;
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_FK")
    private CategoriaAutomovel categoria;
    @Column
    private boolean disponivel = true;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public CategoriaAutomovel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAutomovel categoria) {
        this.categoria = categoria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloAutomovel modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Automovel other = (Automovel) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Automovel{" + "id=" + id + ", placa=" + placa + ", renavam=" + renavam + ", modelo=" + modelo + '}';
    }
}
