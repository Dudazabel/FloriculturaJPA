package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Long> {

    Optional<Servicos> findByIdAndNome(Long id, String nome);

    Optional<Servicos> findByNome(String nome);

    Optional<Servicos> findByValor(double valor);
}
