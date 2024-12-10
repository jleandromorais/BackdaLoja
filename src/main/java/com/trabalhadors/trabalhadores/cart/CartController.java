package com.trabalhadors.trabalhadores.cart;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;


    // Endpoint para buscar o cart por registro_id e status
    @GetMapping("/{registroId}/{status}")
    public Optional<Cart> getCartByRegistroIdAndStatus(@PathVariable Long registroId, @PathVariable String status) {
        return cartService.findCartByRegistroIdAndStatus(registroId, status);
    }

    // Endpoint para criar um novo cart
    @PostMapping
    public Cart createCart(@RequestParam Long registroId, @RequestParam String status) {
        return cartService.createCart(registroId, status);
    }
}

*/
