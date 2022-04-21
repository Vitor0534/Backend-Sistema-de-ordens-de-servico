package com.vitor.sistema_ordens_servico.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente")
    private List<OrdemDeServico> ListaDeOrdensDeServico = new ArrayList<>();

    public Cliente() {
        super();
    }
    public Cliente(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    public List<OrdemDeServico> getListaDeOrdensDeServico() {
        return ListaDeOrdensDeServico;
    }

    public void setListaDeOrdensDeServico(List<OrdemDeServico> listaDeOrdensDeServico) {
        ListaDeOrdensDeServico = listaDeOrdensDeServico;
    }
}
