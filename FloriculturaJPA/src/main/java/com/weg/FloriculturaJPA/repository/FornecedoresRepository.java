package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRequisicaoDTO;
import com.weg.FloriculturaJPA.model.Fornecedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedoresRepository extends JpaRepository<Fornecedores, Long> {

    Optional<Fornecedores> findByIdAndNome(Long id, String nome);

    Optional<Fornecedores> findByNome(String nome);

    Optional<Fornecedores> findByMaterial(String material);

    Optional<Fornecedores> findByNomeAndMaterial(String nome, String material);
}
