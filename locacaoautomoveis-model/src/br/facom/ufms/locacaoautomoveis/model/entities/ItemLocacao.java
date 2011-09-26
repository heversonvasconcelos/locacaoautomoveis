/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.entities;

import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa cada item de uma determinada locação.
 * É composta essencial por um automóvel, pela data prevista da
 * devolução desse automóvel e pela data/hora em que realmente foi efetuada a 
 * devolução.
 * 
 * @author heverson
 */
@Entity
@Table(name = "TB_ITEM_LOCACAO")
public class ItemLocacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "AUTOMOVEL_FK")
    private Automovel automovel;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaDevolucao;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraDevolucao;
    @Column
    private Status status = Status.ABERTO;
    @ManyToOne
    @JoinColumn(name = "LOCACAO_FK")
    private Locacao locacao;

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Date getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Date dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemLocacao other = (ItemLocacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ItemLocacao{" + "id=" + id + ", dataPrevistaDevolucao=" + dataPrevistaDevolucao + ", dataHoraDevolucao=" + dataHoraDevolucao + '}';
    }
}
