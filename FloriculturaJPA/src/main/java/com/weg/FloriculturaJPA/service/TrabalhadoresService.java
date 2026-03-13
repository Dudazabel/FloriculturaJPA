package com.weg.FloriculturaJPA.service;

import com.weg.FloriculturaJPA.dto.TrabalhadoresDTO.TrabalhadoresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.TrabalhadoresDTO.TrabalhadoresRespostaDTO;
import com.weg.FloriculturaJPA.mapper.TrabalhadoresMapper;
import com.weg.FloriculturaJPA.model.Trabalhadores;
import com.weg.FloriculturaJPA.repository.TrabalhadoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabalhadoresService {

    private final TrabalhadoresRepository repository;
    private final TrabalhadoresMapper mapper;

    public TrabalhadoresRespostaDTO adicionarTrabalhadores(TrabalhadoresRequisicaoDTO trabalhador){
        Trabalhadores trabalhadorSalvo = mapper.DTOParaEntidade(trabalhador);
        return mapper.EntidadeParaDTO(repository.save(trabalhadorSalvo));
    }

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo ID indicado!")));
    }

    public List<TrabalhadoresRespostaDTO> listarTrabalhadores(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public TrabalhadoresRespostaDTO atualizarTrabalhadores(TrabalhadoresRequisicaoDTO trabalhador, Long id){
        Trabalhadores trabalhadorSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo ID indicado!"));
        trabalhadorSalvo.setNome(trabalhador.nome());
        trabalhadorSalvo.setCargo(trabalhador.cargo());
        trabalhadorSalvo.setEmail(trabalhador.email());
        trabalhadorSalvo.setSalario(trabalhador.salario());
        return mapper.EntidadeParaDTO(repository.save(trabalhadorSalvo));
    }

    public void deletarTrabalhadores(Long id){
        repository.deleteById(id);
    }
}
