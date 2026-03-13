package com.weg.FloriculturaJPA.dto.TrabalhadoresDTO;

public record TrabalhadoresRespostaDTO(Long id,
                                       String nome,
                                       String cargo,
                                       String email,
                                       double salario) {
}
