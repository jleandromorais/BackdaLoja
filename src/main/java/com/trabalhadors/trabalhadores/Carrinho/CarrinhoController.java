package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CarrinhoRepository repository;

    public CarrinhoController(CarrinhoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Map<String, Object>> cadastrarCarrinho(@RequestBody DadosdoCarrinho dadosdoCarrinho, UriComponentsBuilder uriBuilder) {
        // Cria o objeto e salva no banco
        var carrinho = new Carrinho(dadosdoCarrinho);
        repository.save(carrinho);

        // Cria o JSON de resposta
        Map<String, Object> response = Map.of(
                "name", carrinho.getName(),
                "price", carrinho.getPrice(),
                "image", carrinho.getImagem(),
                "quantity", carrinho.getQuantity()
        );

        return ResponseEntity.created(uriBuilder.path("/carrinho/{id}").buildAndExpand(carrinho.getId()).toUri()).body(response);
    }
}