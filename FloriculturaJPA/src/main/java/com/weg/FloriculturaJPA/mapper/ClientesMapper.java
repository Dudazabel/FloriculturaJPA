package com.weg.FloriculturaJPA.mapper;

import com.weg.FloriculturaJPA.dto.ClientesDTO.ClienteSRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.ClientesDTO.ClientesRespostaDTO;
import com.weg.FloriculturaJPA.model.Clientes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientesMapper {

    public Clientes DTOParaEntidade(ClienteSRequisicaoDTO requisicao){
        return Clientes.builder()
                .nome(requisicao.nome())
                .telefone(requisicao.telefone())
                .build();
    }

    public ClientesRespostaDTO EntidadeParaDTO(Clientes clientes){
        return new ClientesRespostaDTO(clientes.getId(), clientes.getNome(), clientes.getTelefone());
    }

    public List<ClientesRespostaDTO> EntidadeParaDTOLista(List<Clientes> clientes){
        return clientes.stream()
                       .map(this::EntidadeParaDTO)
                       .toList();
    }
}
