package com.trabalhadors.trabalhadores.Registro;

public record DadosCadastroDePessoas(String nome, String email, String senha) {
    public DadosCadastroDePessoas(Registro registro) {
        this(registro.getNome(),registro.getEmail(),registro.getSenha());
    }
}
