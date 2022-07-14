package com.example.campeonato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Partida;
import com.example.campeonato.repositories.PartidaRepository;

@Service
public class PartidaService {
	
	@Autowired
	private PartidaRepository repository;
	
	public List<Partida> buscarTodos(){
		return repository.findAll();
	}
	
	public Partida buscarPorId(Integer id) {
		Optional<Partida> partida = repository.findById(id);
		return partida.get();
	}
	
	public Partida salvar(Partida partida) {
		return repository.save(partida);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Partida atualizar(Integer id, Partida partida) {
		Partida obj = repository.getOne(id);
		updateData(obj, partida);
		return repository.save(obj);
	}

	private void updateData(Partida obj, Partida partida) {
		obj.setData(partida.getData());
		obj.setPontuacaoMandante(partida.getPontuacaoMandante());
		obj.setPontuacaoVisitante(partida.getPontuacaoVisitante());
	}


}
