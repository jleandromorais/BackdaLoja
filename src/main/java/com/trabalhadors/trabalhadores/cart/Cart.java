package com.trabalhadors.trabalhadores.cart;

import com.trabalhadors.trabalhadores.Registro.Registro;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

/*@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    @Column(name = "status")
    private String status; // Status do carrinho (e.g., "active")
    @ManyToOne
    @JoinColumn(name = "register_id")
    private Registro register;
    @ManyToOne
    @JoinColumn(name = "user_id") // Cria a coluna user_id na tabela Cart
    private User user; // Relacionamento com a tabela User

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Registro getRegister() {
        return register;
    }

    public void setRegister(Registro register) {
        this.register = register;
    }

    // Construtor padrão
    public Cart() {}

    // Construtor com id
    public Cart(Long id) {
        this.id = id;
    }

    public Cart(Registro register, String active) {
        this.register=register;
        this.status=active;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para adicionar um item ao carrinho
    public void addItem(CartItem item) {
        this.items.add(item);
        item.setCart(this); // Relacionamento bidirecional
    }

    // Método para remover um item
    public void removeItem(CartItem item) {
        this.items.remove(item);
        item.setCart(null); // Remove o relacionamento
    }
}
*/