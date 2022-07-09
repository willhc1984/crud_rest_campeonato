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
	private Set<Campeonato> campeonatos = new HashSet<>();
	private Set<Partida> partidasComoMandante = new HashSet<>();
	private Set<Partida> partidasComoVisitante = new HashSet<>();
	private Estadio sede;
	
	public Time() {
	}

	public Time(Integer id, String nome, Estadio sede) {
		super();
		this.id = id;
		this.nome = nome;
		this.sede = sede;
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

	public Estadio getSede() {
		return sede;
	}

	public void setSede(Estadio sede) {
		this.sede = sede;
	}

	public Set<Jogador> getJogadores() {
		return jogadores;
	}

	public Set<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public Set<Partida> getPartidasComoMandante() {
		return partidasComoMandante;
	}

	public Set<Partida> getPartidasComoVisitante() {
		return partidasComoVisitante;
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
