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

import com.example.campeonato.model.Estadio;
import com.example.campeonato.services.EstadioService;

@RestController
@RequestMapping(value = "/estadios")
public class EstadioResource {
	
	@Autowired
	private EstadioService service;
	
	@GetMapping
	public List<Estadio> buscarTodos(){
		List<Estadio> estadios = service.buscarTodos();
		return estadios;
	}
	
	@GetMapping(value = "/{id}")
	public Estadio buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public void salvar(@RequestBody Estadio estadio) {
		service.salvar(estadio);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Estadio> atualizar(@PathVariable Integer id, @RequestBody Estadio estadio){
		estadio = service.atualizar(id, estadio);
		return ResponseEntity.ok().body(estadio);
	}

}
