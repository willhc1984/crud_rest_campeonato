package com.example.campeonato.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jogador")
public class Jogador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date nascimento;
	private String genero;
	private Double altura;
	
	@OneToOne(mappedBy = "capitao")
	private Time timeQueCapitaneia;
	@ManyToOne
	@JoinColumn(name = "time_id")
	private Time timeEmQueJoga;
	
	public Jogador() {
	}

	public Jogador(Integer id, String nome, Date nascimento, String genero, Double altura, Time timeEmQueJoga) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
		this.altura = altura;
		this.timeEmQueJoga = timeEmQueJoga;
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}	

	public Time getTimeQueCapitaneia() {
		return timeQueCapitaneia;
	}

	public void setTimeQueCapitaneia(Time timeQueCapitaneia) {
		this.timeQueCapitaneia = timeQueCapitaneia;
	}

	public Time getTimeEmQueJoga() {
		return timeEmQueJoga;
	}

	public void setTimeEmQueJoga(Time timeEmQueJoga) {
		this.timeEmQueJoga = timeEmQueJoga;
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
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", genero=" + genero
				+ ", altura=" + altura + ", timeQueCapitaneia=" + timeQueCapitaneia + "]";
	}


}
