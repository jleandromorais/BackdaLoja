package com.trabalhadors.trabalhadores.Registro;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity(name="registro")
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Registro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nome;
    @Column(unique = true)
    private  String email;
    private  String senha;
    private  Boolean ativo;
    private String tipo;  // Exemplo de campo
    // Relacionamento com Cart
   /* @OneToMany(mappedBy = "register") // 'register' é o nome do campo em Cart
    private List<Cart> carts;
    public Registro() {
    }*/

   /* public List<Cart> getCarts() {
        return carts;
    }*/

    /*public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }*/

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Registro() {
    }

    public Registro(DadosCadastroDePessoas dados) {
        this.nome=dados.nome();
        this.email= dados.email();
        this.senha= dados.senha();
        this.ativo=true;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
