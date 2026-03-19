package com.weg.FloriculturaJPA.dto.ServicosDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ServicosRespostaDTO(@NotNull
                                  @Positive
                                  Long id,
                                  @NotBlank
                                  String nome,
                                  @NotBlank
                                  String descricao,
                                  @NotNull
                                  @PositiveOrZero
                                  double valor) {
}
