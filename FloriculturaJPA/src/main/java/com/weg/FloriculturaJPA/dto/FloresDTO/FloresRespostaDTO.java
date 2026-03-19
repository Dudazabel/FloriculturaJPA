package com.weg.FloriculturaJPA.dto.FloresDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record FloresRespostaDTO(@NotNull
                                @Positive
                                Long id,
                                @NotBlank
                                String nome,
                                @NotBlank
                                String cor,
                                @NotNull
                                @PositiveOrZero
                                double valor) {
}
