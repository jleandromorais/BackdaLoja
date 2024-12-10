package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.persistence.*;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
/*
@Entity
public class ProdutoComQuantidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Adicionando estratégia de geração de ID
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id") // Use @JoinColumn for foreign key mapping
    private Product product;
    @Column(nullable = false)
    private int quantity;


    // Construtor padrão
    public ProdutoComQuantidade() {}

    // Construtor com parâmetros
    public ProdutoComQuantidade(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
*/