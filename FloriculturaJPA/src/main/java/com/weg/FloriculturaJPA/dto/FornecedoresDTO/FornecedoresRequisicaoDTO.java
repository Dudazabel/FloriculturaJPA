package com.weg.FloriculturaJPA.dto.FornecedoresDTO;

import jakarta.validation.constraints.NotBlank;

public record FornecedoresRequisicaoDTO(@NotBlank
                                        String nomeEmpresa,
                                        @NotBlank
                                        String material) {
}
