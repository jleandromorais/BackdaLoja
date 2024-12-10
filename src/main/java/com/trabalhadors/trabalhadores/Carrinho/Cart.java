package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/*@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;  // Relacionamento com a tabela User

    @OneToMany
    private List<ProdutoComQuantidade> produtosComQuantidade;

    private Double totalPrice;

    // Construtor para criar o carrinho
    public Cart(DadosdeCriar dados) {
        this.user = new User(dados.userId());  // Associa o User diretamente ao criar o Cart
        this.produtosComQuantidade = dados.produtosComQuantidade();
        this.totalPrice = dados.totalPrice();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Cart() { }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProdutoComQuantidade> getProdutosComQuantidade() {
        return produtosComQuantidade;
    }

    public void setProdutosComQuantidade(List<ProdutoComQuantidade> produtosComQuantidade) {
        this.produtosComQuantidade = produtosComQuantidade;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
*/