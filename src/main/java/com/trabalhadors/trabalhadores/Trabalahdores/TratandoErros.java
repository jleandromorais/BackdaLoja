package com.trabalhadors.trabalhadores.Trabalahdores;

import jakarta.persistence.EntityNotFoundException;
import org.aspectj.apache.bcel.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class TratandoErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratador404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratador400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest()
                .body(erros.stream().map(DadosErro::new).toList());
    }

    public class DadosErro {
        private String campo;
        private String mensagem;

        public DadosErro(FieldError erro) {
            this.campo = erro.getField();  // Nome do campo que falhou
            this.mensagem = erro.getDefaultMessage();  // Mensagem de erro
        }

        // Getters e Setters (opcional para serialização)
        public String getCampo() {
            return campo;
        }

        public String getMensagem() {
            return mensagem;
        }
    }
}
