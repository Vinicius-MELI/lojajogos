package com.loja.jogos.repository;


import com.loja.jogos.model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long> {

    public List <Jogos> findAllByNomejogoContainingIgnoreCase (@Param("nomejogo") String nomejogo);

}
