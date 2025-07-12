package com.trabalhadors.trabalhadores.Carrinho;

public record ListaDeCarrinhos(Long id,String name,Integer price,String imagem,Integer quantity)
{
    public ListaDeCarrinhos(Carrinho carrinho){
        this(carrinho.getId(),carrinho.getName(),carrinho.getPrice(),carrinho.getImagem(),carrinho.getQuantity());
    }
}
