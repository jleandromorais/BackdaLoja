package com.trabalhadors.trabalhadores.Registro;

public record ListaDeCadastro(long id, String nome, String email, String senha) {
    public  ListaDeCadastro(Registro registro){
        this(registro.getId(),registro.getNome(),registro.getEmail(),registro.getSenha());
    }
}
