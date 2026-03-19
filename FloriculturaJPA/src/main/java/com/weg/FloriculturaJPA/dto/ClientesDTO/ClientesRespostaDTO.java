package com.weg.FloriculturaJPA.dto.ClientesDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ClientesRespostaDTO(@NotNull
                                  @Positive
                                  Long id,
                                  @NotBlank
                                  String nome,
                                  @NotBlank
                                  String telefone) {
}
