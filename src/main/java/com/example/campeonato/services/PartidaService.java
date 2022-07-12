package com.example.campeonato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Partida;
import com.example.campeonato.repositories.PartidaRepository;

@Service
public class PartidaService {
	
	@Autowired
	private PartidaRepository repository;
	
	public Partida salvar(Partida partida) {
		return repository.save(partida);
	}

}
