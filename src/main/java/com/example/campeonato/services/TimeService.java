package com.example.campeonato.services;

import java.util.List;

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
	
	public Time salvar(Time time) {
		return repository.save(time);
	}

}
