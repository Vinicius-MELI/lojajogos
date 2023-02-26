package com.loja.jogos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_jogos")
public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do jogo é obrigatório!")
    @Size(min = 1, max = 100, message = "O nome deve conter entre 1 e 100 caracteres")
    private String nomejogo;

    @NotBlank(message = "Por favor, descreva o jogo.")
    @Size(min = 1, max = 5000, message = "É necessária uma descrição melhor do jogo com até 5000 caracteres.")
    private String descricao;

    @NotBlank(message = "Informe o console!")
    @Size(min = 1, max = 100, message = "Por favor, verifique o nome informado")
    private String console;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne
    @JsonIgnoreProperties ("jogos")
    private Plataformas plataformas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomejogo() {
        return nomejogo;
    }

    public void setNomejogo(String nomejogo) {
        this.nomejogo = nomejogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Plataformas getPlataforma() {
        return plataformas;
    }

    public void setPlataforma(Plataformas plataformas) {
        this.plataformas = plataformas;
    }
}