package com.weg.FloriculturaJPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trabalhadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Trabalhadores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private double salario;
}
