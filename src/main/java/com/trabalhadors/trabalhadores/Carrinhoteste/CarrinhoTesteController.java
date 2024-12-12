package com.trabalhadors.trabalhadores.Carrinhoteste;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Optional;

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
        // Verifica se o ID já foi fornecido no JSON
        Long id = dados.id();

        if (id != null) {
            // Verifica se o produto com esse ID já existe no banco de dados
            Optional<Carrinhoteste> carrinhoExistente = carrinhoTesteRepository.findById(id);

            if (carrinhoExistente.isPresent()) {
                // Se o produto já existir, soma as quantidades e os preços
                Carrinhoteste carrinho = carrinhoExistente.get();
                carrinho.setQuantity(carrinho.getQuantity() + dados.quantity());
                carrinho.setPrice(carrinho.getPrice().add(dados.price()));  // Supondo que price seja do tipo BigDecimal

                // Atualiza o carrinho existente
                carrinhoTesteRepository.save(carrinho);

                // Retorna o carrinho atualizado
                return ResponseEntity.ok(new DadosDoCarrinho(carrinho));
            }
        }

        // Se o produto não existir, cria um novo
        Carrinhoteste carrinhoteste = new Carrinhoteste(dados);

        // Caso o ID tenha sido fornecido, define o ID manualmente
        if (id != null) {
            carrinhoteste.setId(id);
        }

        // Salva o novo item no carrinho
        carrinhoTesteRepository.save(carrinhoteste);

        // Gera a URI para o novo carrinho
        var uri = uriBuilder.path("/carrinho/{id}").buildAndExpand(carrinhoteste.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDoCarrinho(carrinhoteste));
    }

}

