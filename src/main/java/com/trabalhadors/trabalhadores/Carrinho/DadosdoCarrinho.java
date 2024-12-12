package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosdoCarrinho(
        @NotBlank String name,
        @NotNull Integer price,
        @NotBlank String imagem,
        @NotNull Integer quantity,
         Integer productid) {
}