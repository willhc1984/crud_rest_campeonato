package com.example.campeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campeonato.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer>{
	
}
