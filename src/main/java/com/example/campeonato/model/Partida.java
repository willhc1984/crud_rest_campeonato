package com.example.campeonato.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_partida")
public class Partida implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Integer pontuacaoMandante;
	private Integer pontuacaoVisitante;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "time_visitante_id")
	private Time visitante;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "time_mandante_id")
	private Time mandante;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "campeonato_id")
	private Campeonato campeonato;
	
	public Partida() {
	}

	public Partida(Integer id, Date data, Integer pontuacaoMandante, Integer pontuacaoVisitante, Time visitante,
			Time mandante, Campeonato campeonato) {
		super();
		this.id = id;
		this.data = data;
		this.pontuacaoMandante = pontuacaoMandante;
		this.pontuacaoVisitante = pontuacaoVisitante;
		this.visitante = visitante;
		this.mandante = mandante;
		this.campeonato = campeonato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPontuacaoMandante() {
		return pontuacaoMandante;
	}

	public void setPontuacaoMandante(Integer pontuacaoMandante) {
		this.pontuacaoMandante = pontuacaoMandante;
	}

	public Integer getPontuacaoVisitante() {
		return pontuacaoVisitante;
	}

	public void setPontuacaoVisitante(Integer pontuacaoVisitante) {
		this.pontuacaoVisitante = pontuacaoVisitante;
	}

	public Time getVisitante() {
		return visitante;
	}

	public void setVisitante(Time visitante) {
		this.visitante = visitante;
	}

	public Time getMandante() {
		return mandante;
	}

	public void setMandante(Time mandante) {
		this.mandante = mandante;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
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
		Partida other = (Partida) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", data=" + data + ", pontuacaoMandante=" + pontuacaoMandante
				+ ", pontuacaoVisitante=" + pontuacaoVisitante + ", visitante=" + visitante + ", mandante=" + mandante
				+ ", campeonato=" + campeonato + "]";
	}
	
	
	

}
