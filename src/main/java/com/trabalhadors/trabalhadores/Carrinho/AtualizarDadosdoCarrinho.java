package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AtualizarDadosdoCarrinho(
        @NotNull
        Long id,

        @Size(min = 1, max = 100)
        String name,

        @Positive
        Integer price,

        String imagem,

        @Positive
        Integer quantity
) {
}