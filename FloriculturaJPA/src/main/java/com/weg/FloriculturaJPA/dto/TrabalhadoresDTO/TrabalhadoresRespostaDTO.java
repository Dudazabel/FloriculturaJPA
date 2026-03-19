package com.weg.FloriculturaJPA.dto.TrabalhadoresDTO;

import jakarta.validation.constraints.*;

public record TrabalhadoresRespostaDTO(@NotNull
                                       @Positive
                                       Long id,
                                       @NotBlank
                                       String nome,
                                       @NotBlank
                                       String cargo,
                                       @NotBlank
                                       @Email
                                       String email,
                                       @NotNull
                                       @PositiveOrZero
                                       double salario) {
}
