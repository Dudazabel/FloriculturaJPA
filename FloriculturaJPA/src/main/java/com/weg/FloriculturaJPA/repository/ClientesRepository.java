package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    Optional<Clientes> findByIdAndNome(Long id, String nome);

    Optional<Clientes> findByNome(String nome);

    Boolean ExistsByTelefone(String telefone);
}
