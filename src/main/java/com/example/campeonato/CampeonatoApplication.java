package com.example.campeonato;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.model.Endereco;
import com.example.campeonato.model.Estadio;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.model.Partida;
import com.example.campeonato.model.Time;
import com.example.campeonato.repositories.CampeonatoRepository;
import com.example.campeonato.repositories.EnderecoRepository;
import com.example.campeonato.repositories.EstadioRepository;
import com.example.campeonato.repositories.JogadorRepository;
import com.example.campeonato.repositories.PartidaRepository;
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
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;

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
		
		Campeonato c1 = new Campeonato(null, 1995, "Paulistão");
		Campeonato c2 = new Campeonato(null, 1995, "Brasileirão");
		Campeonato c3 = new Campeonato(null, 1995, "Libertadores");
		Campeonato c4 = new Campeonato(null, 1995, "Copa do Brasil");
		campeonatoRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Partida p1 = new Partida(null, new Date(), 3, 5, t1, t2, c1);
		Partida p2 = new Partida(null, new Date(), 2, 5, t3, t4, c1);
		Partida p3 = new Partida(null, new Date(), 3, 7, t4, t5, c1);
		Partida p4 = new Partida(null, new Date(), 3, 9, t4, t3, c2);
		Partida p5 = new Partida(null, new Date(), 8, 5, t2, t5, c3);	
		Partida p6 = new Partida(null, new Date(), 3, 5, t1, t2, c4);
		Partida p7 = new Partida(null, new Date(), 3, 5, t1, t2, c4);
		Partida p8 = new Partida(null, new Date(), 3, 5, t1, t2, c2);
		partidaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
		
		c1.addTime(t1); c1.addTime(t2); c1.addTime(t3); c1.addTime(t4); c1.addTime(t5);
		c2.addTime(t1); c1.addTime(t2); c1.addTime(t3); c1.addTime(t4); c1.addTime(t5);
		c3.addTime(t1); c1.addTime(t2); c1.addTime(t3); c1.addTime(t4); c1.addTime(t5);
		c4.addTime(t1); c1.addTime(t2); c1.addTime(t3); c1.addTime(t4); c1.addTime(t5);
		
		t1.addCampeonato(c1); t1.addCampeonato(c2); t1.addCampeonato(c3); t1.addCampeonato(c4);
		t2.addCampeonato(c1); t2.addCampeonato(c2); t2.addCampeonato(c3); t2.addCampeonato(c4);
		t3.addCampeonato(c1); t3.addCampeonato(c2); t3.addCampeonato(c3); t3.addCampeonato(c4);
		t4.addCampeonato(c1); t4.addCampeonato(c2); t4.addCampeonato(c3); t4.addCampeonato(c4);
		t5.addCampeonato(c1); t5.addCampeonato(c2); t5.addCampeonato(c3); t5.addCampeonato(c4);
		campeonatoRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
	}

}
