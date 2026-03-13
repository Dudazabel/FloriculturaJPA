package com.weg.FloriculturaJPA.mapper;

import com.weg.FloriculturaJPA.dto.FloresDTO.FloresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.FloresDTO.FloresRespostaDTO;
import com.weg.FloriculturaJPA.model.Flores;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FloresMapper {

    public Flores DTOParaEntidade(FloresRequisicaoDTO requisicao){
        return Flores.builder()
                .nome(requisicao.nome())
                .cor(requisicao.cor())
                .valor(requisicao.valor())
                .build();
    }

    public FloresRespostaDTO EntidadeParaDTO(Flores flores){
        return new FloresRespostaDTO(flores.getId(), flores.getNome(), flores.getCor(), flores.getValor());
    }

    public List<FloresRespostaDTO> EntidadeParaDTOList(List<Flores> flores){
        return flores.stream()
                     .map(this::EntidadeParaDTO)
                     .toList();
    }
}
