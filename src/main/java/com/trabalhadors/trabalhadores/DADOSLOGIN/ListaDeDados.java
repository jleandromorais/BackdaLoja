package com.trabalhadors.trabalhadores.DADOSLOGIN;

public record ListaDeDados(Long id , String email, String senha) {

    public  ListaDeDados(Login login){
        this(login.getId(), login.getEmail(),login.getSenha());
    }

}
