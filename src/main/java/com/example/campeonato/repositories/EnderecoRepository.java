package com.example.campeonato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.campeonato.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
