package com.trabalhadors.trabalhadores.Carrinho;
/*
import com.trabalhadors.trabalhadores.Trabalahdores.DadosAtualizarDados;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
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
    public ResponseEntity<Map<String, Object>> cadastrarCarrinho(
            @RequestBody @Valid DadosdoCarrinho dadosdoCarrinho,
            UriComponentsBuilder uriBuilder
    ) {
        // Busca o carrinho existente ou cria um novo
        Carrinho carrinho = repository.findById(dadosdoCarrinho.productid())
                .map(existingCarrinho -> {
                    existingCarrinho.setQuantity(existingCarrinho.getQuantity() + dadosdoCarrinho.quantity());
                    existingCarrinho.setPrice(existingCarrinho.getPrice() + dadosdoCarrinho.price());
                    return existingCarrinho;
                })
                .orElseGet(() -> {
                    Carrinho novoCarrinho = new Carrinho(dadosdoCarrinho);
                    novoCarrinho.setVersion(0); // Inicializa o campo version
                    return novoCarrinho;
                });

        // Salva o carrinho no banco de dados
        Carrinho managedCarrinho = repository.save(carrinho);

        // Monta a resposta
        Map<String, Object> response = Map.of(
                "name", managedCarrinho.getName(),
                "price", managedCarrinho.getPrice(),
                "image", managedCarrinho.getImagem(),
                "quantity", managedCarrinho.getQuantity(),
                "productid", managedCarrinho.getProductid()
        );

        if (repository.existsById(dadosdoCarrinho.productid())) {
            // Se já existia, retorna OK
            return ResponseEntity.ok(response);
        } else {
            // Se foi criado, retorna CREATED
            return ResponseEntity
                    .created(uriBuilder.path("/carrinho/{productid}")
                            .buildAndExpand(managedCarrinho.getProductid()).toUri())
                    .body(response);
        }
    }



    @GetMapping
    @Transactional
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
                        double totalPrice = items.stream().mapToDouble(c -> c.getPrice() != null ? c.getPrice() * c.getQuantity() : 0).sum();

                        // Retornar um mapa com as informações do produto (sem ID)
                        Map<String, Object> productData = new HashMap<>();
                        productData.put("name", productName);
                        productData.put("totalQuantity", totalQuantity);
                        productData.put("totalPrice", totalPrice);
                        productData.put("imagem", items.get(0).getImagem()); // Usando a imagem do primeiro item


                        return productData;
                    })
                    .collect(Collectors.toList());

            // Calcular o preço total de todos os produtos
            double totalPriceAllProducts = result.stream()
                    .mapToDouble(item -> (double) item.get("totalPrice"))
                    .sum();

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
    public ResponseEntity<?> atualizarCarrinho(@PathVariable Long id, @RequestBody @Valid AtualizarDadosdoCarrinho dados) {
        try {
            // Aqui você pode validar o id e as informações recebidas
            System.out.println("Atualizando carrinho com ID: " + id);
            System.out.println("Dados recebidos: " + dados);

            // Seu código de atualização vai aqui...

            return ResponseEntity.ok("Carrinho atualizado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar o carrinho: " + e.getMessage());
        }
    }
    @DeleteMapping("/{productid}")
    public ResponseEntity<Void> deletarItem(@PathVariable Integer productid) {
        System.out.println("Requisição DELETE recebida para remover item com ID: " + productid);

        try {
            // Verifica se o item existe no banco de dados
            Optional<Carrinho> item = repository.findById(productid);

            if (item.isEmpty()) {
                System.out.println("Item não encontrado no banco de dados: " + productid);
                return ResponseEntity.notFound().build();
            }

            // Remove o item
            repository.delete(item.get());
            System.out.println("Item removido com sucesso: " + productid);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            // Log detalhado para erros
            System.err.println("Erro ao processar requisição DELETE: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

*/




