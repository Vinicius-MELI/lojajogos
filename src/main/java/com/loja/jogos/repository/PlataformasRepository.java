package com.loja.jogos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.loja.jogos.model.Plataformas;

import java.util.List;

@Repository
public interface PlataformasRepository extends JpaRepository<Plataformas, Long>  {

    public List<Plataformas> findAllByNomePlataformaIgnoreCase (@Param("nomePlataforma") String nomePlataforma);
}
