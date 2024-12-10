package com.trabalhadors.trabalhadores.DADOSLOGIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
private LoginRepository loginRepository;


    @PostMapping

    public ResponseEntity<DadosDeLogin> cadastrarLogin(@RequestBody DadosDeLogin dados, UriComponentsBuilder uriBuilder) {
        var login = new Login(dados);
        loginRepository.save(login);  // Certifique-se de ter o repositório para salvar o login
        var uri = uriBuilder.path("/login/{id}").buildAndExpand(login.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDeLogin(login));
    }
    @GetMapping
    public ResponseEntity<List<ListaDeDados>> listar() {
        var lista = loginRepository.findByAtivoTrue().stream()
                .map(ListaDeDados::new)
                .toList();
        return ResponseEntity.ok(lista);
    }


}
