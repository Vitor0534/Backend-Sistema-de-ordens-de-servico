package com.vitor.sistema_ordens_servico.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa{

    @OneToMany(mappedBy = "tecnico") // perceba que essa annotation, indica a relação 1:n com a OS e passa o nome do objeto que foi referenciado
                                     // na OS
    private List<OrdemDeServico> ListaDeOrdensDeServico = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public List<OrdemDeServico> getListaDeOrdensDeServico() {
        return ListaDeOrdensDeServico;
    }

    public void setListaDeOrdensDeServico(List<OrdemDeServico> listaDeOrdensDeServico) {
        ListaDeOrdensDeServico = listaDeOrdensDeServico;
    }

    public Tecnico(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }
}
