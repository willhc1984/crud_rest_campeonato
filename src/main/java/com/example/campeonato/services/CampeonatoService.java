package com.example.campeonato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repositories.CampeonatoRepository;

@Service
public class CampeonatoService {
	
	@Autowired
	private CampeonatoRepository repository;
	
	public Campeonato salvar(Campeonato campeonato) {
		return repository.save(campeonato);
	}

}
