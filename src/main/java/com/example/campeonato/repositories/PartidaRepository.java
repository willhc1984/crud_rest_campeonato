package com.example.campeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campeonato.model.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer>{

}
