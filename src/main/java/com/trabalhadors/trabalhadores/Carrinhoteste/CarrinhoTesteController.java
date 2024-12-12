package com.trabalhadors.trabalhadores.Carrinhoteste;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoTesteController {

    private final CarrinhoTesteRepository carrinhoTesteRepository;

    @Autowired // The constructor will be called by Spring and inject the repository
    public CarrinhoTesteController(CarrinhoTesteRepository carrinhoTesteRepository) {
        this.carrinhoTesteRepository = carrinhoTesteRepository;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDoCarrinho> cadastrarTrabalhador(@RequestBody DadosDoCarrinho dados, UriComponentsBuilder uriBuilder) {
        var carrinhoteste = new Carrinhoteste(dados);

        // Verifica se o ID foi fornecido no JSON, e se sim, define o ID manualmente
        if (dados.id() != null) {
            carrinhoteste.setId(dados.id());  // Define o ID manualmente
        }

        carrinhoTesteRepository.save(carrinhoteste);

        var uri = uriBuilder.path("/carrinho/{id}").buildAndExpand(carrinhoteste.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDoCarrinho(carrinhoteste));
    }

}

