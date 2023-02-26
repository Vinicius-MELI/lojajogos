package com.loja.jogos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table (name = "tb_plataformas")
public class Plataformas {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull (message = "O atributo Plataforma é obrigatório")
    private String nomePlataforma;

    @OneToMany (mappedBy = "plataformas", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties ("plataformas")
    private List <Jogos> jogos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePlataforma() {
        return nomePlataforma;
    }

    public void setNomePlataforma(String nomePlataforma) {
        this.nomePlataforma = nomePlataforma;
    }

    public List<Jogos> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogos> jogos) {
        this.jogos = jogos;
    }
}
