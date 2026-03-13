package com.weg.FloriculturaJPA.repository;

import com.weg.FloriculturaJPA.model.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloresRepository extends JpaRepository<Flores, Long> {
}
