package com.example.campeonato;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.campeonato.model.Endereco;
import com.example.campeonato.model.Estadio;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.model.Time;
import com.example.campeonato.repositories.EnderecoRepository;
import com.example.campeonato.repositories.EstadioRepository;
import com.example.campeonato.repositories.JogadorRepository;
import com.example.campeonato.repositories.TimeRepository;

@SpringBootApplication
public class CampeonatoApplication implements CommandLineRunner{
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@Autowired
	private EstadioRepository estadioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CampeonatoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Time t1 = new Time(null, "Corinthians", null, null);
		Time t2 = new Time(null, "Santos", null, null);
		Time t3 = new Time(null, "São Paulo", null, null);
		Time t4 = new Time(null, "Palmeiras", null, null);
		Time t5 = new Time(null, "Botafogo", null, null);
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		
		Jogador j1 = new Jogador(null, "José", new Date(), "M", 1.78, t1);
		Jogador j2 = new Jogador(null, "Maria", new Date(), "F", 1.56, t1);
		Jogador j3 = new Jogador(null, "Marcos", new Date(), "M", 1.70, t1);
		Jogador j4 = new Jogador(null, "Ana Paula", new Date(), "F", 1.74, t2);
		Jogador j5 = new Jogador(null, "Mario", new Date(), "M", 1.65, t2);
		jogadorRepository.saveAll(Arrays.asList(j1, j2, j3, j4, j5));
		
		t1.setCapitao(j1);
		t2.setCapitao(j2);
		//t2.setCapitao(j3);
		t3.setCapitao(j3);
		t4.setCapitao(j4);
		t5.setCapitao(j5);
		
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		
		Endereco end1 = new Endereco(null, "rua João Martini", 678, "1b", "São matheus");
		Endereco end2 = new Endereco(null, "rua caribe", 678, "1b", "São conrado");
		Endereco end3 = new Endereco(null, "av iravuvu", 554, "1b", "Vila Carol");
		Endereco end4 = new Endereco(null, "av ipanema", 123, "1b", "Botucatu");
		Endereco end5 = new Endereco(null, "Rua Miranda Azevedo", 56, "2b", "Centro");
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5));
		
		Estadio e1 = new Estadio(null, "Morumbi", t3, end1);
		Estadio e2 = new Estadio(null, "Vila Belmiro", t2, end2);
		Estadio e3 = new Estadio(null, "Itaquerão", t1, end3);
		Estadio e4 = new Estadio(null, "Pq Antartica", t4, end4);
		Estadio e5 = new Estadio(null, "Brinco de Ouro", t5, end5);	
		estadioRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
		
		
	}

}
