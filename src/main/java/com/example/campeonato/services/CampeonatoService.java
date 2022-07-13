package com.example.campeonato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repositories.CampeonatoRepository;

@Service
public class CampeonatoService {
	
	@Autowired
	private CampeonatoRepository repository;
	
	public List<Campeonato> buscarTodos(){
		List<Campeonato> campeonatos = repository.findAll();
		return campeonatos;
	}
	
	public Campeonato buscarPorId(Integer id) {
		Optional<Campeonato> campeonato = repository.findById(id);
		return campeonato.get();
	}
	
	public Campeonato salvar(Campeonato campeonato) {
		return repository.save(campeonato);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Campeonato atualizar(Integer id, Campeonato campeonato) {
		Campeonato obj = repository.getOne(id);
		updateData(obj, campeonato);
		return repository.save(obj);
	}

	private void updateData(Campeonato obj, Campeonato campeonato) {
		obj.setAno(campeonato.getAno());
		obj.setNome(campeonato.getNome());
	}
	

}
