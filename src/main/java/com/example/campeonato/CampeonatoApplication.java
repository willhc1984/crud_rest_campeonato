package com.example.campeonato;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.campeonato.model.Jogador;
import com.example.campeonato.model.Time;
import com.example.campeonato.repositories.JogadorRepository;
import com.example.campeonato.repositories.TimeRepository;

@SpringBootApplication
public class CampeonatoApplication implements CommandLineRunner{
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private TimeRepository timeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CampeonatoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Jogador j1 = new Jogador(null, "José", null, "M", 1.78, null);
		Jogador j2 = new Jogador(null, "Maria", null, "F", 1.56, null);
		Jogador j3 = new Jogador(null, "Marcos", null, "M", 1.70, null);
		Jogador j4 = new Jogador(null, "Ana Paula", null, "F", 1.74, null);
		Jogador j5 = new Jogador(null, "Mario", null, "M", 1.65, null);
		jogadorRepository.saveAll(Arrays.asList(j1, j2, j3, j4, j5));
		
		Time t1 = new Time(null, "Corinthians", null, null);
		Time t2 = new Time(null, "Santos", null, null);
		Time t3 = new Time(null, "São Paulo", null, null);
		Time t4 = new Time(null, "Palmeiras", null, null);
		Time t5 = new Time(null, "Botafogo", null, null);
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));		
		
		j1.setTimeEmQueJoga(t1); 
		j2.setTimeEmQueJoga(t2);
		j3.setTimeEmQueJoga(t3);
		j4.setTimeEmQueJoga(t4);
		
		t1.setCapitao(j1);
		t2.setCapitao(j2);
		t3.setCapitao(j3);
		t4.setCapitao(j4);
		
		jogadorRepository.saveAll(Arrays.asList(j1, j2, j3, j4));
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		
		
	}

}
