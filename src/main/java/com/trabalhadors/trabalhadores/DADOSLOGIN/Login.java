package com.trabalhadors.trabalhadores.DADOSLOGIN;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="trao")
@Table(name="login")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String senha;
    private boolean ativo;

    public Login(DadosDeLogin dados) {
        this.email=dados.email();
        this.senha= dados.senha();
        this.ativo=true;

    }

    public Login() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setEmail(String login) {
        this.email = login;
    }



}

