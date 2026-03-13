package com.weg.FloriculturaJPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "servicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double valor;
}
