package com.example.campeonato.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Time implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	private Jogador capitao;
	
	private Set<Jogador> jogadores = new HashSet<>();
	
	public Time() {
	}

	public Time(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Jogador getCapitao() {
		return capitao;
	}

	public void setCapitao(Jogador capitao) {
		this.capitao = capitao;
	}

	public Set<Jogador> getJogadores() {
		return jogadores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + "]";
	}
	

}
