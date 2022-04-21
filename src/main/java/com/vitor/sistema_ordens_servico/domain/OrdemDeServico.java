package com.vitor.sistema_ordens_servico.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vitor.sistema_ordens_servico.domain.enuns.Prioridade;
import com.vitor.sistema_ordens_servico.domain.enuns.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

//*** Foi utilizado as convenções do JPA para modelar as entidades a partir do codigo**/

@Entity  // É sempre necessário definir as classes como entidades se for perisistilás no banco
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataDeAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataDeFechamento;

    private Integer prioridade;
    private String observacoes;
    private Integer status;

    @ManyToOne
    @JoinColumn(name  = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name  = "cliente_id")
    private Cliente cliente;



    public OrdemDeServico(){
        super();
        this.dataDeAbertura = LocalDateTime.now();
        this.prioridade = Prioridade.BAIXA.getCodigo();
        this.status = Status.ABERTO.getCodigo();
    }

    public OrdemDeServico(Integer id, Prioridade prioridade, String observacoes, Status status, Tecnico tecnico, Cliente cliente) {
        super();
        this.id = id;
        this.dataDeAbertura = LocalDateTime.now();
        this.prioridade = (prioridade == null) ? 0 : prioridade.getCodigo();
        this.observacoes = observacoes;
        this.status = (status == null) ? 0 : status.getCodigo();
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDateTime dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public LocalDateTime getDataDeFechamento() {
        return dataDeFechamento;
    }

    public void setDataDeFechamento(LocalDateTime dataDeFechamento) {
        this.dataDeFechamento = dataDeFechamento;
    }

    public Prioridade getPrioridade() {
        return Prioridade.toEnum(this.prioridade);
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade.getCodigo();
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getCodigo();
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdemDeServico)) return false;
        OrdemDeServico that = (OrdemDeServico) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
