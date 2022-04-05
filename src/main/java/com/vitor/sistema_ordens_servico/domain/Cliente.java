package com.vitor.sistema_ordens_servico.domain;

public class Cliente extends Pessoa{
    public Cliente() {
        super();
    }
    public Cliente(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }
}
