package com.example.campeonato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Estadio;
import com.example.campeonato.repositories.EstadioRepository;

@Service
public class EstadioService {
	
	@Autowired
	private EstadioRepository repository;
	
	public List<Estadio> buscarTodos(){
		return repository.findAll();
	}
	
	public Estadio buscarPorId(Integer id) {
		Optional<Estadio> estadio = repository.findById(id);
		return estadio.get();
	}
	
	public Estadio salvar(Estadio estadio) {
		return repository.save(estadio);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Estadio atualizar(Integer id, Estadio estadio) {
		Estadio obj = repository.getOne(id);
		updateData(obj, estadio);
		return repository.save(obj);
	}

	private void updateData(Estadio obj, Estadio estadio) {
		obj.setNome(estadio.getNome());
	}
}
