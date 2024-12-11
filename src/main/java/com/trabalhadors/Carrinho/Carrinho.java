package com.trabalhadors.Carrinho;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Carrinho {

    private String name;

    public Carrinho() {
    }

    public Carrinho(String imagem, Integer quantity, Integer price, String name) {
        this.imagem = imagem;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }

    private Integer price;

    public Carrinho(DadosdoCarrinho dadosdoCarrinho) {
        this.name=dadosdoCarrinho.name();
        this.price=dadosdoCarrinho.price();
        this.imagem=dadosdoCarrinho.imagem();
        this.quantity=dadosdoCarrinho.quuantity();
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String imagem;
    private Integer quantity;
}
