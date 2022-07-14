package com.example.campeonato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Time;
import com.example.campeonato.repositories.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;
	
	public List<Time> buscarTodos(){
		return repository.findAll();
	}
	
	public Time buscarPorId(Integer id) {
		Optional<Time> time = repository.findById(id);
		return time.get();
	}
	
	public Time salvar(Time time) {
		return repository.save(time);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Time atualizar(Integer id, Time time) {
		Time obj = repository.getOne(id);
		updateData(obj, time);
		return repository.save(obj);
	}

	private void updateData(Time obj, Time time) {
		obj.setNome(time.getNome());
	}

}
