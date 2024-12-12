package com.trabalhadors.trabalhadores.Carrinho;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarrinhoRepository extends JpaRepository<Carrinho,Integer> {

    Optional<Carrinho> findById(Integer productid);

}
