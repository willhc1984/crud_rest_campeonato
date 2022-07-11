package com.example.campeonato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Jogador;
import com.example.campeonato.repositories.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository repository;
	
	public Jogador salvar(Jogador jogador) {
		return repository.save(jogador);
	}

}
