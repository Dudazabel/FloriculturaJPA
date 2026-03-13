package com.weg.FloriculturaJPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Flores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private double valor;
}
