package com.example.campeonato.model;

import java.io.Serializable;
import java.util.Objects;

public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer ano;
	
	public Campeonato() {	
	}

	public Campeonato(Integer id, Integer ano) {
		super();
		this.id = id;
		this.ano = ano;
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

	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", ano=" + ano + "]";
	}

	
}
