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

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.services.CampeonatoService;

@RestController
@RequestMapping(value = "/campeonatos")
public class CampeonatoResource {
	
	@Autowired
	private CampeonatoService service;
	
	@GetMapping
	public List<Campeonato> buscarTodos(){
		List<Campeonato> campeonatos = service.buscarTodos();
		return campeonatos;
	}
	
	@GetMapping(value = "/{id}")
	public Campeonato buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public void salvar(@RequestBody Campeonato campeonato) {
		service.salvar(campeonato);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Campeonato> atualizar(@PathVariable Integer id, @RequestBody Campeonato campeonato){
		campeonato = service.atualizar(id, campeonato);
		return ResponseEntity.ok().body(campeonato);
	}

}
