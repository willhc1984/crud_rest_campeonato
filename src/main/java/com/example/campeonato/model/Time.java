package com.example.campeonato.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_time")
public class Time implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "jogador_id", unique = true)
	private Jogador capitao;	
	@OneToMany(mappedBy = "timeEmQueJoga")
	private Set<Jogador> jogadores = new HashSet<>();
	
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tb_time_campeonato", 
			joinColumns = @JoinColumn(name = "time_id"),
			inverseJoinColumns = @JoinColumn(name = "campeonato_id"))
	private Set<Campeonato> campeonatos = new HashSet<>();
	
	@OneToMany(mappedBy = "mandante")
	private Set<Partida> partidasComoMandante = new HashSet<>();
	@OneToMany(mappedBy = "visitante")
	private Set<Partida> partidasComoVisitante = new HashSet<>();
	@OneToOne(mappedBy = "time", cascade = CascadeType.MERGE)
	private Estadio sede;
	
	public Time() {
	}

	public Time(Integer id, String nome, Estadio sede, Jogador capitao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sede = sede;
		this.capitao = capitao;
	}
	
	public void addCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
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

}
