package com.trabalhadors.trabalhadores.Trabalahdores;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/trabalho")
public class TrabalhadoresController {


    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @PostMapping("/trabalhadores")
    @Transactional
    public ResponseEntity<DadosdeCadastroTrabalhador> cadastrarTrabalhador(@RequestBody DadosdeCadastroTrabalhador dados, UriComponentsBuilder uriBuilder) {
        var trabalho = new Trabalhador(dados);
        trabalhadorRepository.save(trabalho);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(trabalho.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosdeCadastroTrabalhador(trabalho));
    }

    @GetMapping
    public ResponseEntity<List<ListaDeTrabalhadores>> listar() {
        var lista = trabalhadorRepository.findByAtivoTrue().stream()
                .map(ListaDeTrabalhadores::new)
                .toList();
        return ResponseEntity.ok(lista);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosAtualizarDados> atulizar(@PathVariable long id, @RequestBody @Valid DadosAtualizarDados dados){
        // Busca o trabalhador com o id vindo da URL
        var trabalhador = trabalhadorRepository.getReferenceById(id);

        // Atualiza as informações com os dados passados no corpo da requisição
        trabalhador.atualizarInformacoes(dados);

        // Retorna a resposta com as informações atualizadas
        return ResponseEntity.ok(new DadosAtualizarDados(trabalhador));
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

