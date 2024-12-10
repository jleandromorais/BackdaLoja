package com.trabalhadors.trabalhadores.Carrinho;


import com.trabalhadors.trabalhadores.Trabalahdores.DadosdeCadastroTrabalhador;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
/*
@RestController
@RequestMapping("/carrinhos")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> criarCarrinho(@RequestBody List<ProdutoComQuantidade> produtos) {
        Cart novoCarrinho = new Cart();  // Supondo que Cart tenha um construtor padrão

        // Cria o carrinho e calcula o preço total
        Cart carrinhoCriado = cartService.criarCarrinho(novoCarrinho, produtos);

        // Retorna o carrinho com o preço total calculado
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCriado);
    }
}
*/