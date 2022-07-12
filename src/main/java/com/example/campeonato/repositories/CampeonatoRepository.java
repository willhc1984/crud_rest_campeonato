package com.example.campeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campeonato.model.Campeonato;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer>{

}
