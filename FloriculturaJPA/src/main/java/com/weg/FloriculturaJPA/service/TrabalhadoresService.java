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

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorIdENome(Long id, String nome){
        return mapper.EntidadeParaDTO(repository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo ID e nome indicados!")));
    }

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo nome indicado!")));
    }

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorNomeECargo(String cargo, String nome){
        return mapper.EntidadeParaDTO(repository.findByNomeAndCargo(nome, cargo)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo nome e cargo indicados!")));
    }

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorCargo(String cargo){
        return mapper.EntidadeParaDTO(repository.findByCargo(cargo)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo cargo indicado!")));
    }

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorEmail(String email){
        return mapper.EntidadeParaDTO(repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo email indicado!")));
    }

    public TrabalhadoresRespostaDTO buscarTrabalhadoresPorSalario(double salario){
        return mapper.EntidadeParaDTO(repository.findBySalario(salario)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o trabalhador pelo salario indicado!")));
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
