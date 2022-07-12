package com.example.campeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campeonato.model.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer>{

}
