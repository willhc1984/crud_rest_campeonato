package com.example.campeonato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Jogador;
import com.example.campeonato.repositories.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository repository;
	
	public List<Jogador> buscarTodos(){
		return repository.findAll();
	}
	
	public Jogador buscarPorId(Integer id) {
		Optional<Jogador> jogador = repository.findById(id);
		return jogador.get();
	}
	
	public Jogador salvar(Jogador jogador) {
		return repository.save(jogador);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Jogador atualizar(Integer id, Jogador jogador) {
		Jogador obj = repository.getOne(id);
		updateData(obj, jogador);
		return repository.save(obj);
	}

	private void updateData(Jogador obj, Jogador jogador) {
		obj.setAltura(jogador.getAltura());
		obj.setGenero(jogador.getGenero());
		obj.setNome(jogador.getNome());
		obj.setNascimento(jogador.getNascimento());	
	}

}
