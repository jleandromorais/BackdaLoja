package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AtualizarDadosdoCarrinho(

        @NotBlank String name,
        @NotNull(message = "A quantidade não pode ser nula") @Positive Integer quantity,
        @NotNull(message = "O preço não pode ser nulo") @Positive Integer price,
        @NotBlank String imagem,
        @NotNull Integer productid  // Adicionado aqui
) {
    public AtualizarDadosdoCarrinho(Carrinho carrinhoo) {
        this(carrinhoo.getName(), carrinhoo.getQuantity(), carrinhoo.getPrice(), carrinhoo.getImagem(), carrinhoo.getProductid());
    }
}
