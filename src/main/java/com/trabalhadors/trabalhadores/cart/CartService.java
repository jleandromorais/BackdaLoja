package com.trabalhadors.trabalhadores.cart;

import com.trabalhadors.trabalhadores.Registro.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.trabalhadors.trabalhadores.Registro.RegistroRepository;

import java.util.Optional;


/*@Service

    public class CartService {

        @Autowired
        private CartRepository cartRepository;

        @Autowired
        private RegistroRepository registroRepository;

        // Método para encontrar o cart por registro_id e status
        public Optional<Cart> findCartByRegistroIdAndStatus(Long registroId, String status) {
            return cartRepository.findByRegister_IdAndStatus(registroId, status);
        }

        // Exemplo de método para criar um novo cart
        public Cart createCart(Long registroId, String status) {
            Registro registro = registroRepository.findById(registroId)
                    .orElseThrow(() -> new RuntimeException("Registro não encontrado"));

            Cart cart = new Cart();
            cart.setRegister(registro);
            cart.setStatus(status);
            return cartRepository.save(cart);
        }
    }*/