package com.weg.FloriculturaJPA.mapper;

import com.weg.FloriculturaJPA.dto.TrabalhadoresDTO.TrabalhadoresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.TrabalhadoresDTO.TrabalhadoresRespostaDTO;
import com.weg.FloriculturaJPA.model.Trabalhadores;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrabalhadoresMapper {

    public Trabalhadores DTOParaEntidade(TrabalhadoresRequisicaoDTO requisicao){
        return Trabalhadores.builder()
                .nome(requisicao.nome())
                .cargo(requisicao.cargo())
                .email(requisicao.email())
                .salario(requisicao.salario())
                .build();
    }

    public TrabalhadoresRespostaDTO EntidadeParaDTO(Trabalhadores trabalhadores){
        return new TrabalhadoresRespostaDTO(trabalhadores.getId(), trabalhadores.getNome(), trabalhadores.getCargo(), trabalhadores.getEmail(), trabalhadores.getSalario());
    }

    public List<TrabalhadoresRespostaDTO> EntidadeParaDTOList(List<Trabalhadores> trabalhadores){
        return trabalhadores.stream()
                            .map(this::EntidadeParaDTO)
                            .toList();
    }
}
