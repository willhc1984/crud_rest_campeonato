package com.example.campeonato.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Transient;

public class Estadio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	@Transient
	private Time time;
	@Transient
	private Endereco endereco;
	
	public Estadio() {
	}

	public Estadio(Integer id, String nome, Time time, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.time = time;
		this.endereco = endereco;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Estadio other = (Estadio) obj;
		return Objects.equals(id, other.id);
	}	
	
}
