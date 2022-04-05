package com.vitor.sistema_ordens_servico.domain.enuns;

public enum Prioridade {
    BAIXA(0,"BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2,"ALTA");

    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao=descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer codigo){
        try {

        if(codigo == null) {
            return null;
        }

        for(Prioridade p : Prioridade.values()){
            if(codigo.equals(p.getCodigo())){
                return p;
            }
        }

        throw new IllegalAccessException("Prioridade inválida!  -- codigo: " + codigo );

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
