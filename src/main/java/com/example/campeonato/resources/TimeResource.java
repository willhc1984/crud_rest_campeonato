package com.example.campeonato.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.campeonato.model.Time;
import com.example.campeonato.services.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeResource {
	
	@Autowired
	private TimeService service;
	
	@GetMapping
	public List<Time> buscarTodos(){
		List<Time> times = service.buscarTodos();
		return times;
	}

}
