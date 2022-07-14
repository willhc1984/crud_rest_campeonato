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

import com.example.campeonato.model.Partida;
import com.example.campeonato.services.PartidaService;

@RestController
@RequestMapping(value = "/partidas")
public class PartidaResource {
	
	@Autowired
	private PartidaService service;
	
	@GetMapping
	public List<Partida> buscarTodos(){
		List<Partida> partidas = service.buscarTodos();
		return partidas;
	}
	
	@GetMapping(value = "/{id}")
	public Partida buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public void salvar(@RequestBody Partida partida) {
		service.salvar(partida);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Partida> atualizar(@PathVariable Integer id, @RequestBody Partida partida){
		partida = service.atualizar(id, partida);
		return ResponseEntity.ok().body(partida);
	}

}
