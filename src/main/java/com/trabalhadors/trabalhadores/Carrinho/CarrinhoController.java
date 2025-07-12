package com.trabalhadors.trabalhadores.Carrinho;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carrinho")
@CrossOrigin("*") // ⚠️ Em produção, defina origem específica
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrarCarrinho(@RequestBody @Valid DadosdoCarrinho dados,
                                                                 UriComponentsBuilder uriBuilder) {
        Carrinho carrinho = new Carrinho(dados);
        carrinhoService.salvar(carrinho);
        URI uri = uriBuilder.path("/carrinho/{id}").buildAndExpand(carrinho.getId()).toUri();
        return ResponseEntity.created(uri).body(Map.of("id", carrinho.getId()));
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> listaDeProdutosNoCarrinho() {
        List<Carrinho> lista = carrinhoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizarDadosdoCarrinho> atualizarCarrinho(@PathVariable Long id,
                                                                      @RequestBody @Valid AtualizarDadosdoCarrinho dados) {
        Carrinho carrinho = carrinhoService.atualizar(id, dados);
        AtualizarDadosdoCarrinho resposta = new AtualizarDadosdoCarrinho(
                carrinho.getId(),
                carrinho.getName(),
                carrinho.getPrice(),
                carrinho.getImagem(),
                carrinho.getQuantity()
        );
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarrinho(@PathVariable Long id) {
        carrinhoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
