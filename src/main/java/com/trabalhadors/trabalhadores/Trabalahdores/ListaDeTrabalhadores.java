package com.trabalhadors.trabalhadores.Trabalahdores;

public record ListaDeTrabalhadores(Long id,String nome,String funcao,double salario) {

    public ListaDeTrabalhadores(Trabalhador trabalhador){
        this(trabalhador.id,trabalhador.getNome(),trabalhador.getFuncao(),trabalhador.getSalario());
    }
}
