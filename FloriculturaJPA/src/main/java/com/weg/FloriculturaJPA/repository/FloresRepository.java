package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.model.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FloresRepository extends JpaRepository<Flores, Long> {

    Optional<Flores> findByIdAndNome(Long id, String nome);

    Optional<Flores> findByNome(String nome);

    Optional<Flores> findByCor(String cor);

    Optional<Flores> findByNomeAndCor(String nome, String cor);

    Optional<Flores> findByValor(double valor);
}
