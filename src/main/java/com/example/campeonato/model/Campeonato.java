package com.example.campeonato.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_campeonato")
public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer ano;
	private String nome;
	
	@OneToMany(mappedBy = "campeonato")
	private Set<Partida> partidas = new HashSet<>();
	@ManyToMany(mappedBy = "campeonatos")
	private Set<Time> times = new HashSet<>();
	
	public Campeonato() {	
	}

	public Campeonato(Integer id, Integer ano, String nome) {
		super();
		this.id = id;
		this.ano = ano;
		this.nome = nome;
	}
	
	public void addTime(Time time) {
		times.add(time);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Partida> getPartidas() {
		return partidas;
	}

	public Set<Time> getTimes() {
		return times;
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
		Campeonato other = (Campeonato) obj;
		return Objects.equals(id, other.id);
	}
	
}
