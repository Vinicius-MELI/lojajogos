package com.loja.jogos.controller;


import com.loja.jogos.model.Plataformas;
import com.loja.jogos.repository.PlataformasRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plataformas")
@CrossOrigin (origins = "*", allowedHeaders = "*")

public class PlataformasController {


    @Autowired
    private PlataformasRepository plataformasRepository;

    @GetMapping
    public ResponseEntity <List<Plataformas>> getAll () {
        return ResponseEntity.ok(plataformasRepository.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Plataformas> getById (@PathVariable Long id) {
        return plataformasRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping ("/nomePlataforma/{nomePlataforma}")
    public ResponseEntity<List<Plataformas>> getByTitle (@PathVariable String nomePlataforma) {
        return ResponseEntity.ok(plataformasRepository.findAllByNomePlataformaIgnoreCase(nomePlataforma));
    }


    @PostMapping
    public ResponseEntity<Plataformas> post (@Valid @RequestBody Plataformas plataformas) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(plataformasRepository.save(plataformas));
    }

    @PutMapping
    public ResponseEntity<Plataformas> put (@Valid @RequestBody Plataformas plataformas) {
        return plataformasRepository.findById(plataformas.getId())
               .map(resposta -> ResponseEntity.status(HttpStatus.CREATED). body(plataformasRepository.save(plataformas)))
               .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus (HttpStatus.NO_CONTENT)
    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Long id) {

        Optional<Plataformas> plataformas = plataformasRepository.findById(id);

        if (plataformas.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        plataformasRepository.deleteById(id);

    }




}
