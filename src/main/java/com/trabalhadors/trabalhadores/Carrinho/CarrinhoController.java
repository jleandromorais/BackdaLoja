package com.trabalhadors.trabalhadores.Carrinho;

import com.trabalhadors.trabalhadores.Trabalahdores.DadosAtualizarDados;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*")
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
    }   // GET - Buscar todos os itens no carrinho

    @GetMapping
    public ResponseEntity<Map<String, Object>> listaDeProdutosnoCarrinhos() {
        try {
            // Buscar todos os itens no repositório
            List<Carrinho> allItems = repository.findAll();

            // Agrupar os itens por nome
            Map<String, List<Carrinho>> groupedItems = allItems.stream()
                    .collect(Collectors.groupingBy(Carrinho::getName));

            // Criar lista com o total de preço e quantidade por nome
            List<Map<String, Object>> result = groupedItems.entrySet().stream()
                    .map(entry -> {
                        String productName = entry.getKey();
                        List<Carrinho> items = entry.getValue();

                        // Calcular soma das quantidades e preços
                        int totalQuantity = items.stream().mapToInt(c -> c.getQuantity() != null ? c.getQuantity() : 0).sum();
                        double totalPrice = items.stream().mapToDouble(c -> c.getPrice() != null ? c.getPrice() : 0).sum();

                        // Retornar um mapa com as informações do produto
                        Map<String, Object> productData = new HashMap<>();
                        productData.put("name", productName);
                        productData.put("totalQuantity", totalQuantity);
                        productData.put("totalPrice", totalPrice);
                        productData.put("imagem", items.get(0).getImagem()); // Usando a imagem do primeiro item

                        return productData;
                    })
                    .collect(Collectors.toList());

            // Calcular o preço total de todos os produtos
            double totalPriceAllProducts = allItems.stream()
                    .mapToDouble(c -> c.getPrice() != null ? c.getPrice() : 0).sum();

            // Criar a resposta final incluindo a soma de todos os produtos
            Map<String, Object> response = new HashMap<>();
            response.put("products", result);
            response.put("totalPriceAllProducts", totalPriceAllProducts); // Adicionar a soma total de todos os produtos

            // Retornar a lista agrupada com o preço total
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // Criar resposta de erro com a mensagem de erro
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Erro ao processar os dados: " + e.getMessage());

            // Retornar o erro com status 500 e corpo JSON
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public  ResponseEntity<AtualizarDadosdoCarrinho> atulizar(@RequestBody @Valid AtualizarDadosdoCarrinho dados){
        var trabalhador= trabalhadorRepository.getReferenceById(dados.id());
        trabalhador.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosAtualizarDados(trabalhador)); // Retorna 404 se o remedio não for encontrado

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFUncionario(@PathVariable Long id) {
        if (trabalhadorRepository.existsById(id)) {
            trabalhadorRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 (sem conteúdo)
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o remedio não for encontrado

        }
    }

}






