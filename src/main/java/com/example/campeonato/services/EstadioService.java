package com.example.campeonato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Estadio;
import com.example.campeonato.repositories.EstadioRepository;

@Service
public class EstadioService {
	
	@Autowired
	private EstadioRepository repository;
	
	public Estadio salvar(Estadio estadio) {
		return repository.save(estadio);
	}
}
