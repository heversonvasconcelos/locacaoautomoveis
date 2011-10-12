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
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa uma locação. É aberta quando o locador aluga um
 * ou mais automóveis para um determinado cliente (locatário). E é finalizada
 * quando o cliente devolve o(s) automóvel(eis).
 * É composta essencialmente por um cliente (locatário), pela data/hora do 
 * momento que foi aberta e finalizada e pelos itens de locação.
 * 
 * @author heverson
 */
@Entity
@Table(name = "TB_LOCACAO")
@NamedQuery(name = "Locacao.buscarLocacoesPeloStatus",
query = "SELECT l FROM Locacao AS l WHERE l.status = :status")
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "CLIENTE_FK")
    private Cliente cliente;
    /**
     * Representa a data e a hora do momento que a locação foi realizada ou aberta
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraLocacao;
    /**
     * Representa a data prevista que o automóvel será devolvido
     * 
     */
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaDevolucao;
    /**
     * Representa a data e a hora do momento que a locação foi finalizada
     * 
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraLocacaoFinalizada;
    /**
     * Representa o status da locação. ABERTO = Locação em andamento.
     * FECHADO = Locação finalizada.
     */
    @Column
    private Status status = Status.ABERTO;
    @Column
    private String observacoes;
    @ManyToOne
    @JoinColumn(name = "AUTOMOVEL_FK")
    private Automovel automovel;
    /**
     * Representa o valor da locação após ser finalizada.
     */
    @Column(scale = 10, precision = 2)
    private double valor;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataHoraLocacao() {
        return dataHoraLocacao;
    }

    public void setDataHoraLocacao(Date dataHoraLocacao) {
        this.dataHoraLocacao = dataHoraLocacao;
    }

    public Date getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public Date getDataHoraLocacaoFinalizada() {
        return dataHoraLocacaoFinalizada;
    }

    public void setDataHoraLocacaoFinalizada(Date dataHoraLocacaoFinalizada) {
        this.dataHoraLocacaoFinalizada = dataHoraLocacaoFinalizada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locacao other = (Locacao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Locacao{" + "id=" + id + ", cliente=" + cliente + ", dataHoraLocacao=" + dataHoraLocacao + ", automovel=" + automovel + '}';
    }
}
