package com.trabalhadors.trabalhadores.Carrinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/*
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProdutoComQuantidadeRepository produtoComQuantidadeRepository;

    public CartService(CartRepository cartRepository, ProdutoComQuantidadeRepository produtoComQuantidadeRepository) {
        this.cartRepository = cartRepository;
        this.produtoComQuantidadeRepository = produtoComQuantidadeRepository;
    }

    public Cart criarCarrinho(Cart cart, List<ProdutoComQuantidade> produtos) {

        List<ProdutoComQuantidade> produtosSalvos = produtoComQuantidadeRepository.saveAll(produtos);

        // Calcula o preço total
        double totalPrice = produtosSalvos.stream()
                .mapToDouble(p -> calcularPrecoProduto(p.getProduct().getId(), p.getQuantity())) // Método para buscar o preço
                .sum();  // Soma o preço total
        cart.setTotalPrice(totalPrice);

        // Salva o carrinho com o preço calculado
        return cartRepository.save(cart);
    }

    private double calcularPrecoProduto(Long productId, int quantity) {
        // Implementar lógica para buscar o preço do produto
        double preco = 100.0; // Exemplo fixo
        return preco * quantity;
    }
}
*/