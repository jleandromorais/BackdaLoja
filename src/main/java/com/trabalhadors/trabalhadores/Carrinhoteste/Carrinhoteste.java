package com.trabalhadors.trabalhadores.Carrinhoteste;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Entity(name = "carrinho")
@Table(name="carrinho")
@Getter
@Setter

@EqualsAndHashCode(of="id")
public class Carrinhoteste {


        @Id
        private Long id;  // O ID será fornecido manualmente

        private String imagem;
        private String name;
        private int price;
        private int quantity;

        // Construtor
        public Carrinhoteste(Long id, String imagem, String name, int price, int quantity) {
            this.id = id;
            this.imagem = imagem;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

    public Carrinhoteste() {
    }

    public Carrinhoteste(DadosDoCarrinho dados) {
            this.id=dados.id();
            this.imagem= dados.imagem();
            this.price=dados.price();
            this.name= dados.name();
            this.quantity=dados.quantity();
    }

    // Getters e Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getImagem() {
            return imagem;
        }

        public void setImagem(String imagem) {
            this.imagem = imagem;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
