package com.weg.FloriculturaJPA.service;

import com.weg.FloriculturaJPA.dto.FloresDTO.FloresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.FloresDTO.FloresRespostaDTO;
import com.weg.FloriculturaJPA.mapper.FloresMapper;
import com.weg.FloriculturaJPA.model.Flores;
import com.weg.FloriculturaJPA.repository.FloresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FloresService {

    private final FloresRepository repository;
    private final FloresMapper mapper;

    public FloresRespostaDTO adicionarFlores(FloresRequisicaoDTO flor){
        Flores florSalva = mapper.DTOParaEntidade(flor);
        return mapper.EntidadeParaDTO(repository.save(florSalva));
    }

    public FloresRespostaDTO buscarFloresPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a flor pelo ID indicado!")));
    }

    public FloresRespostaDTO buscarFloresPorIdENome(Long id, String nome){
        return mapper.EntidadeParaDTO(repository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a flor pelo ID e nome indicado!")));
    }

    public FloresRespostaDTO buscarFloresPorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a flor pelo nome indicado!")));
    }

    public FloresRespostaDTO buscarFloresPorNomeECor(String nome, String cor){
        return mapper.EntidadeParaDTO(repository.findByNomeAndCor(nome, cor)
                .orElseThrow(() ->  new RuntimeException("Não foi possível encontrar a flor pelo nome e pela cor indicados!")));
    }

    public FloresRespostaDTO bucarFloresPelaCor(String cor){
        return mapper.EntidadeParaDTO(repository.findByCor(cor)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a flor pela cor indicada!")));
    }

    public FloresRespostaDTO buscarFloresPorValor(double valor){
        return mapper.EntidadeParaDTO(repository.findByValor(valor)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a flor pelo valor indicado!")));
    }

    public List<FloresRespostaDTO> listarrFlores(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public FloresRespostaDTO atualizarFlores(FloresRequisicaoDTO flor, Long id){
        Flores florSalva = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar a flor pelo ID indicado!"));
        florSalva.setNome(flor.nome());
        florSalva.setCor(flor.cor());
        florSalva.setValor(flor.valor());
        return mapper.EntidadeParaDTO(repository.save(florSalva));
    }
    public void deletarFlores(Long id){
        repository.deleteById(id);
    }
}
