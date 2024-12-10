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
    public  ResponseEntity<DadosAtualizarDados> atulizar(@RequestBody @Valid DadosAtualizarDados dados){
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

