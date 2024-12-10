package com.trabalhadors.trabalhadores.Registro;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/registro")
public class RegistroController {

@Autowired
private RegistroRepository registroRepository;

@PostMapping
@Transactional
public ResponseEntity<?> CadastroDePesooas(@RequestBody DadosCadastroDePessoas dados , UriComponentsBuilder uriBuilder){
    if (registroRepository.existsByEmail(dados.email())) {
        // Criar um mapa com a mensagem de erro
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "O e-mail já está registrado.");
        return ResponseEntity.badRequest().body(errorResponse);  // Retorna um 400 com o erro
    }
    var registro =new Registro(dados);
        registroRepository.save(registro);
    var uri = uriBuilder.path("/registro/{id}").buildAndExpand(registro.getId()).toUri();
    return ResponseEntity.created(uri).body(new DadosCadastroDePessoas(registro));

    }

    @GetMapping
    public ResponseEntity<List<ListaDeCadastro>> listar() {
        var lista = registroRepository.findByAtivoTrue().stream()
                .map(ListaDeCadastro::new)
                .toList();
        return ResponseEntity.ok(lista);
    }
}
