package com.trabalhadors.trabalhadores.Trabalahdores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosdeCadastroTrabalhador(
        @NotBlank(message = "A função não pode estar em branco")
                String nome,
                @NotBlank(message = "A função não pode estar em branco")
                String funcao,
        @NotNull(message = "O salário não pode ser nulo")
        @Positive(message = "O salário deve ser positivo")
        Double salario) {
    public DadosdeCadastroTrabalhador(Trabalhador trabalho) {
        this(trabalho.getNome(), trabalho.getFuncao(), trabalho.getSalario());
    }


}
