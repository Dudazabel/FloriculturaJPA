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
