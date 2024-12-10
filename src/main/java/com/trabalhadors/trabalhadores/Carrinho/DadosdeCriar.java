package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.stream.Collectors;

/*
public record DadosdeCriar(
        @NotNull(message = "O ID do usuário é obrigatório.")
        Long userId,

        @NotNull(message = "A lista de produtos não pode estar nula.")
        @Size(min = 1, message = "A lista de produtos deve conter pelo menos um produto.")
        List<ProdutoComQuantidade> produtosComQuantidade,

        @NotNull(message = "A quantidade é obrigatória.")
        Integer quantity,

        Double totalPrice) {

    public DadosdeCriar(Cart cart) {
        this(
                cart.getUser().getId(),  // Acessa o userId do objeto User
                cart.getProdutosComQuantidade(),
                cart.getProdutosComQuantidade().stream().mapToInt(ProdutoComQuantidade::getQuantity).sum(),
                cart.getTotalPrice()
        );
    }
}*/