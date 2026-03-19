package com.weg.FloriculturaJPA.dto.TrabalhadoresDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TrabalhadoresRequisicaoDTO(@NotBlank
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
