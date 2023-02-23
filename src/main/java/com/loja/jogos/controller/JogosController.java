package com.loja.jogos.controller;


import com.loja.jogos.model.Jogos;
import com.loja.jogos.repository.JogosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/jogos")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class JogosController {

    @Autowired
    private JogosRepository jogosRepository;

    @GetMapping
    public ResponseEntity <List<Jogos>> getAll () {
        return ResponseEntity.ok(jogosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogos> getById (@PathVariable Long id) {
        return jogosRepository.findById(id)
                .map (reposta -> ResponseEntity.ok(reposta))
                .orElse (ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping("/nomejogo/{nomejogo}")
    public ResponseEntity <List<Jogos>> getByNomejogo(@PathVariable String nomejogo){
        return ResponseEntity.ok(jogosRepository.findAllByNomejogoContainingIgnoreCase(nomejogo));
    }

    @PostMapping
    public ResponseEntity<Jogos> post (@Valid @RequestBody Jogos jogos) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jogosRepository.save(jogos));
    }

    @PutMapping
    public ResponseEntity<Jogos> put (@Valid @RequestBody Jogos jogos) {
        return jogosRepository.findById(jogos.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                .body(jogosRepository.save(jogos)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        Optional <Jogos> jogos = jogosRepository.findById(id);
        if (jogos.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        jogosRepository.deleteById(id);
    }


}
