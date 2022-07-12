package com.example.campeonato.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Endereco;
import com.example.campeonato.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public Endereco salvar(Endereco endereco) {
		return repository.save(endereco);
	}

}
