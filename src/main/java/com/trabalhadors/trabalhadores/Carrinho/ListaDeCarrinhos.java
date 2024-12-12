package com.trabalhadors.trabalhadores.Carrinho;

public record ListaDeCarrinhos(Integer productid,String name,Integer price,String imagem,Integer quantity)
{
    public ListaDeCarrinhos(Carrinho carrinho){
        this(carrinho.getProductid(),carrinho.getName(),carrinho.getPrice(),carrinho.getImagem(),carrinho.getQuantity());
    }
}
