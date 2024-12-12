package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Entity(name = "Carrinho")
@Table(name = "carrinho")
@Getter
@Setter
@AllArgsConstructor

public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;

    private Integer quantity;

    @Version
    private Integer version;

    private String name;
    private Integer price;
    private String imagem;

    public Carrinho(DadosdoCarrinho dadosDoCarrinho) {
        this.name = dadosDoCarrinho.name();
        this.price = dadosDoCarrinho.price();
        this.imagem = dadosDoCarrinho.imagem();
        this.quantity = dadosDoCarrinho.quantity();
        this.productid = dadosDoCarrinho.productid();
    }

    public Integer getVersion() {
        return version;
    }

    public Carrinho() {
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void atualizarInformacoes(@Valid AtualizarDadosdoCarrinho dados) {
        if (dados.quantity() != null) {
            this.quantity = dados.quantity();
        }
        if (dados.price() != null) {
            this.price = dados.price();
        }
    }
}
