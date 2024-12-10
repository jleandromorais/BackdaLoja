package com.trabalhadors.trabalhadores.Trabalahdores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosAtualizarDados(
        @NotNull long id ,
        @NotBlank(message = "A função não pode estar em branco")
        String nome,
        @NotBlank(message = "A função não pode estar em branco")
        String funcao,
        @Positive(message = "O salário deve ser positivo")
        double salario) {
    public DadosAtualizarDados(Trabalhador trabalhador) {
        this(trabalhador.getId(),trabalhador.getNome(),trabalhador.getFuncao(),trabalhador.getSalario());
    }
}
