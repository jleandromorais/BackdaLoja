package com.trabalhadors.Carrinho;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @PostMapping
    @Transactional
    public ResponseEntity<Map<String,Object>>cadastrarCarrinho(@RequestBody  DadosdoCarrinho dadosdoCarrinho, UriComponentsBuilder uriBuilder) {
        var carrinho = new Carrinho(dadosdoCarrinho);
        // Criar a entidade `Carrinho` com os dados recebidos

        // Criar o JSON de resposta
        Map<String, Object> response = Map.of(
                "name", carrinho.getName(),          // Nome associado ao carrinho
                "price", carrinho.getPrice(),        // Preço do item no carrinho
                "image", carrinho.getImagem() ,       // Caminho da imagem do item
                "quantity", carrinho.getQuantity()   // Quantidade do item no carrinho
        );

        // Retornar a resposta com status CREATED
        return ResponseEntity.created(uriBuilder.path("/carrinho").build().toUri()).body(response);
    }

}
