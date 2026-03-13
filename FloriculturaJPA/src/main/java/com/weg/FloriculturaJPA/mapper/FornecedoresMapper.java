package com.weg.FloriculturaJPA.mapper;

import com.weg.FloriculturaJPA.dto.FornecedoresDTO.FornecedoresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.FornecedoresDTO.FornecedoresRespostaDTO;
import com.weg.FloriculturaJPA.model.Fornecedores;
import com.weg.FloriculturaJPA.repository.FornecedoresRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FornecedoresMapper {

    public Fornecedores DTOParaEntidade(FornecedoresRequisicaoDTO requisicao){
        return Fornecedores.builder()
                .nomeEmpresa(requisicao.nomeEmpresa())
                .material(requisicao.material())
                .build();
    }

    public FornecedoresRespostaDTO EntidadeParaDTO(Fornecedores fornecedores){
        return new FornecedoresRespostaDTO(fornecedores.getId(), fornecedores.getNomeEmpresa(), fornecedores.getMaterial());
    }

    public List<FornecedoresRespostaDTO> EntidadeParaDTOList(List<Fornecedores> fornecedores){
        return fornecedores.stream()
                           .map(this::EntidadeParaDTO)
                           .toList();
    }
}
