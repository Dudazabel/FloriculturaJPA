package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.model.Trabalhadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhadoresRepository extends JpaRepository<Trabalhadores, Long> {
}
