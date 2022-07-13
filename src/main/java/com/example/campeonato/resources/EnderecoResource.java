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

import com.example.campeonato.model.Endereco;
import com.example.campeonato.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List<Endereco> buscarTodos(){
		List<Endereco> enderecos = service.buscarTodos();
		return enderecos;
	}
	
	@GetMapping(value = "/{id}")
	public Endereco buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public void salvar(@RequestBody Endereco endereco) {
		service.salvar(endereco);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Integer id, @RequestBody Endereco endereco){
		endereco = service.atualizar(id, endereco);
		return ResponseEntity.ok().body(endereco);
	}

}
