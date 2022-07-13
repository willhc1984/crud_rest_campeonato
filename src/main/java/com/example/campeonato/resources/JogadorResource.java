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

import com.example.campeonato.model.Jogador;
import com.example.campeonato.services.JogadorService;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	@Autowired
	private JogadorService service;
	
	@GetMapping
	public List<Jogador> buscarTodos(){
		List<Jogador> jogadores = service.buscarTodos();
		return jogadores;
	}
	
	@GetMapping(value = "/{id}")
	public Jogador buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public void salvar(@RequestBody Jogador jogador) {
		service.salvar(jogador);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Jogador> atualizar(@PathVariable Integer id, @RequestBody Jogador jogador){
		jogador = service.atualizar(id, jogador);
		return ResponseEntity.ok().body(jogador);
	}

}
