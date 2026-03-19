package com.weg.FloriculturaJPA.dto.FloresDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record FloresRequisicaoDTO(@NotBlank
                                  String nome,
                                  @NotBlank
                                  String cor,
                                  @NotNull
                                  @PositiveOrZero
                                  double valor) {
}
