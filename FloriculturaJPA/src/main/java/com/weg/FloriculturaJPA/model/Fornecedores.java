package com.weg.FloriculturaJPA.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fornecedores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Fornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_empresa", nullable = false)
    private String nomeEmpresa;

    @Column(nullable = false)
    private String material;
}
