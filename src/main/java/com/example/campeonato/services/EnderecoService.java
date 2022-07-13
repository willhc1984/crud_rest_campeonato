package com.example.campeonato.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campeonato.model.Endereco;
import com.example.campeonato.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> buscarTodos(){
		List<Endereco> enderecos = repository.findAll();
		return enderecos;
	}
	
	public Endereco buscarPorId(Integer id) {
		Optional<Endereco> endereco = repository.findById(id);
		return endereco.get();
	}
	
	public Endereco salvar(Endereco endereco) {
		return repository.save(endereco);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Endereco atualizar(Integer id, Endereco endereco) {
		Endereco obj = repository.getOne(id);
		updateData(obj, endereco);
		return repository.save(obj);
	}

	private void updateData(Endereco obj, Endereco endereco) {
		obj.setBairro(endereco.getBairro());
		obj.setComplemento(endereco.getComplemento());
		obj.setLogradouro(endereco.getLogradouro());
		obj.setNumero(endereco.getNumero());
	}
	
	

}
