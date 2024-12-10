package com.trabalhadors.trabalhadores.DADOSLOGIN;

public record DadosDeLogin(String email , String senha) {
    @Override
    public String email() {
        return email;
    }

    @Override
    public String senha() {
        return senha;
    }

    public DadosDeLogin(Login login) {
         this(login.getEmail(),login.getSenha());

    }
}
