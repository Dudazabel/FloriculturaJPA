package com.weg.FloriculturaJPA.dto.ClientesDTO;

import jakarta.validation.constraints.NotBlank;
public record ClienteSRequisicaoDTO(@NotBlank
                                    String nome,
                                    @NotBlank
                                    String telefone) {
}
