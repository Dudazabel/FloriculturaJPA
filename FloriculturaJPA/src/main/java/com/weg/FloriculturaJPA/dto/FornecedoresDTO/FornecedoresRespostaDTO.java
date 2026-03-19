package com.weg.FloriculturaJPA.dto.FornecedoresDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record FornecedoresRespostaDTO(@NotNull
                                      @PositiveOrZero
                                      Long id,
                                      @NotBlank
                                      String nomeEmpresa,
                                      @NotBlank
                                      String material) {
}
