package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.model.Trabalhadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabalhadoresRepository extends JpaRepository<Trabalhadores, Long> {

    Optional<Trabalhadores> findByIdAndNome(Long id, String nome);

    Optional<Trabalhadores> findByNome(String nome);

    Optional<Trabalhadores> findByNomeAndCargo(String nome, String cargo);

    Optional<Trabalhadores> findByCargo(String cargo);

    Optional<Trabalhadores> findByEmail(String email);

    Optional<Trabalhadores> findBySalario(double salario);
}
