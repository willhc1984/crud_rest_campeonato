package com.example.campeonato.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/{id}")
	public Time buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public void salvar(@RequestBody Time time) {
		service.salvar(time);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Time> atualizar(@PathVariable Integer id, @RequestBody Time time){
		time = service.atualizar(id, time);
		return ResponseEntity.ok().body(time);
	}


}
