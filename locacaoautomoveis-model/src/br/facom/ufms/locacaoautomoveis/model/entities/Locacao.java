/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.entities;

import br.facom.ufms.locacaoautomoveis.model.types.Status;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@NamedQueries({
    @NamedQuery(name = "Locacao.buscarLocacoesPeloStatus",
    query = "SELECT l FROM Locacao AS l WHERE l.status = :status"),
    @NamedQuery(name = "Locacao.buscarLocacoesStatusFechadoPagamentoNaoRealizado",
    query = "SELECT l FROM Locacao AS l WHERE l.status = :statusFechado AND l.pagamentoRealizado = false")
})
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "CLIENTE_FK")
    private Cliente cliente;
    /**
     * Representa a data e a hora do momento que a locação foi aberta
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraAbertura;
    /**
     * Representa a data e a hora do momento que a locação foi finalizada
     * 
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraFechamento;
    @Column
    private Status status = Status.ABERTO;
    @Column
    private String observacoes;
    @OneToMany(mappedBy = "locacao", cascade = javax.persistence.CascadeType.ALL)
    private List<ItemLocacao> itensLocacao = new ArrayList<ItemLocacao>();
    @Column
    private boolean pagamentoRealizado = false;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Date dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Date getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Date dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemLocacao> getItensLocacao() {
        return itensLocacao;
    }

    public void setItensLocacao(List<ItemLocacao> itensLocacao) {
        this.itensLocacao = itensLocacao;
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

    public boolean isPagamentoRealizado() {
        return pagamentoRealizado;
    }

    public void setPagamentoRealizado(boolean pagamentoRealizado) {
        this.pagamentoRealizado = pagamentoRealizado;
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
        return "Locacao{" + "id=" + id + ", cliente=" + cliente + ", dataHoraAbertura=" + dataHoraAbertura + ", status=" + status + '}';
    }
}
