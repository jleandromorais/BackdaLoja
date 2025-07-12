package com.trabalhadors.trabalhadores.Carrinho;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    // Método para listar todos os carrinhos
    public List<Carrinho> listarTodos() {
        return carrinhoRepository.findAll();
    }

    // Método para buscar um carrinho por id
    public Optional<Carrinho> buscarPorId(Long id) {
        return carrinhoRepository.findById(id);
    }

    // Método para salvar um novo carrinho
    @Transactional
    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    // Método para atualizar um carrinho existente
    @Transactional
    public Carrinho atualizar(Long id, AtualizarDadosdoCarrinho dados) {
        Carrinho carrinho = carrinhoRepository.getReferenceById(id);

        if (dados.name() != null) {
            carrinho.setName(dados.name());
        }
        if (dados.price() != null) {
            carrinho.setPrice(dados.price());
        }
        if (dados.imagem() != null) {
            carrinho.setImagem(dados.imagem());
        }
        if (dados.quantity() != null) {
            carrinho.setQuantity(dados.quantity());
        }
        return carrinho;
    }

    // Método para deletar um carrinho pelo id
    @Transactional
    public void deletar(Long id) {
        carrinhoRepository.deleteById(id);
    }
}