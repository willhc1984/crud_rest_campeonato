package com.example.campeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campeonato.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer>{
	

}
