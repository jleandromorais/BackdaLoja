package com.trabalhadors.trabalhadores.Registro;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    private String email;

    @ManyToOne
    @JoinColumn(name = "registro_id")  // Fazendo referência ao campo "registro_id" na tabela "usuarios"
    private Registro registro;  // Relacionamento com a entidade Registro

    // Getters e setters
}