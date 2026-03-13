package com.weg.FloriculturaJPA.service;

import com.weg.FloriculturaJPA.dto.FornecedoresDTO.FornecedoresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.FornecedoresDTO.FornecedoresRespostaDTO;
import com.weg.FloriculturaJPA.mapper.FornecedoresMapper;
import com.weg.FloriculturaJPA.model.Fornecedores;
import com.weg.FloriculturaJPA.repository.FornecedoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedoresService {

    private final FornecedoresRepository repository;
    private final FornecedoresMapper mapper;

    public FornecedoresRespostaDTO adicionarFornecedores(FornecedoresRequisicaoDTO fornecedor){
        Fornecedores fornecedorSalvo = mapper.DTOParaEntidade(fornecedor);
        return mapper.EntidadeParaDTO(repository.save(fornecedorSalvo));
    }

    public FornecedoresRespostaDTO buscarFornecedoresPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o fornecedor pelo ID indicado!")));
    }

    public List<FornecedoresRespostaDTO> listarFornecedores(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public FornecedoresRespostaDTO atualizarFornecedores(FornecedoresRequisicaoDTO fornecedor, Long id){
        Fornecedores fornecedorSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o fornecedor pelo ID indicado!"));
        fornecedorSalvo.setNomeEmpresa(fornecedor.nomeEmpresa());
        fornecedorSalvo.setMaterial(fornecedor.material());
        return mapper.EntidadeParaDTO(repository.save(fornecedorSalvo));
    }

    public void deletarFornecedores(Long id){
        repository.deleteById(id);
    }
}
