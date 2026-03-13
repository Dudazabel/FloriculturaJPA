package com.weg.FloriculturaJPA.mapper;

import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRespostaDTO;
import com.weg.FloriculturaJPA.model.Servicos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicosMapper {

    public Servicos DTOParaEntidade(ServicosRequisicaoDTO requisicao){
        return Servicos.builder()
                .nome(requisicao.nome())
                .descricao(requisicao.descricao())
                .valor(requisicao.valor())
                .build();
    }

    public ServicosRespostaDTO EntidadeParaDTO(Servicos servicos){
        return new ServicosRespostaDTO(servicos.getId(), servicos.getNome(), servicos.getDescricao(), servicos.getValor());
    }

    public List<ServicosRespostaDTO> EntidadeParaDTOList(List<Servicos> servicos){
        return servicos.stream()
                       .map(this::EntidadeParaDTO)
                       .toList();
    }
}
