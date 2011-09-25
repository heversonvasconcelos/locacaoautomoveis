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
@Table(name = "TB_CATEGORIA_AUTOMOVEL")
@NamedQuery(name = "CategoriaAutomovel.buscarCategoriaAutomovelPelaDescricao",
query = "SELECT categauto FROM CategoriaAutomovel AS categauto WHERE categauto.descricao = :descricao")
public class CategoriaAutomovel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String descricao;
    @Column(scale = 10, precision = 2, nullable = false)
    private double valorDiario;
    @Column(scale = 10, precision = 2, nullable = false)
    private double valorSemanal;
    @Column(scale = 10, precision = 2, nullable = false)
    private double valorMensal;
    @Column(scale = 10, precision = 2, nullable = false)
    private double valorKM;
    @OneToMany(mappedBy = "categoria")
    private List<Automovel> automoveis = new ArrayList<Automovel>();
    @Column(nullable = false)
    private int qtdAutomoveisDisponiveis = 0;

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

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

    public int getQtdAutomoveisDisponiveis() {
        return qtdAutomoveisDisponiveis;
    }

    public void decrementarQtdAutomoveisDisponiveis() {
        if (qtdAutomoveisDisponiveis > 0) {
            qtdAutomoveisDisponiveis--;
        }
    }

    public void incrementarQtdAutomoveisDisponiveis() {
        if (automoveis != null && qtdAutomoveisDisponiveis < automoveis.size()) {
            qtdAutomoveisDisponiveis++;
        }
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public double getValorKM() {
        return valorKM;
    }

    public void setValorKM(double valorKM) {
        this.valorKM = valorKM;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public double getValorSemanal() {
        return valorSemanal;
    }

    public void setValorSemanal(double valorSemanal) {
        this.valorSemanal = valorSemanal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaAutomovel other = (CategoriaAutomovel) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "CategoriaAutomovel{" + "id=" + id + ", descricao=" + descricao + '}';
    }
}
