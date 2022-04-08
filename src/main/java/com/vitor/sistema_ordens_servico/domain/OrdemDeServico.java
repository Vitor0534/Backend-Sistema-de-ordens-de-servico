package com.vitor.sistema_ordens_servico.domain;

import com.vitor.sistema_ordens_servico.domain.enuns.Prioridade;
import com.vitor.sistema_ordens_servico.domain.enuns.Status;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrdemDeServico {
    private Integer id;
    private LocalDateTime dataDeAbertura;
    private LocalDateTime dataDeFechamento;
    private Integer prioridade;
    private String observacoes;
    private Integer status;
    private Tecnico tecnico;
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
