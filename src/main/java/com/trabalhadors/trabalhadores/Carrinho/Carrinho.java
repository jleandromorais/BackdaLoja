package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity(name = "Carrinho")
@Table(name="carrinho")
@Getter
@Setter
@AllArgsConstructor
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;
    private String name;
    private Integer price;
    private  String imagem;
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrinho() {
    }

    public Carrinho(String imagem, Integer quantity, Integer price, String name) {
        this.imagem = imagem;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
    }



    public Carrinho(DadosdoCarrinho dadosDoCarrinho) {
        this.name = dadosDoCarrinho.name();
        this.price = dadosDoCarrinho.price();
        this.imagem = dadosDoCarrinho.imagem();
        this.quantity = dadosDoCarrinho.quantity();
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


}
