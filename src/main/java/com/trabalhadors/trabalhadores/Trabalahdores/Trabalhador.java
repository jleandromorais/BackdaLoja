package com.trabalhadors.trabalhadores.Trabalahdores;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name="trabalho")
@Table(name="trabalhadores")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Trabalhador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nome;
    private String funcao;
    private double salario;

    public Trabalhador() {
    }



    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Trabalhador(DadosdeCadastroTrabalhador dados) {
        this.nome = dados.nome();
        this.funcao = dados.funcao();
        this.salario = dados.salario();
        this.ativo=true;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    private  boolean ativo;
    public void inativar() {
this.ativo=false;

    }

    public void atualizarInformacoes(@Valid DadosAtualizarDados dados) {
        if(dados.nome()!=null){
            this.nome= dados.nome();
        }
        if(dados.funcao()!=null){
            this.funcao=dados.funcao();
        }
    }
}
