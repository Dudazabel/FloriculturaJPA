package com.weg.FloriculturaJPA.service;

import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRespostaDTO;
import com.weg.FloriculturaJPA.mapper.ServicosMapper;
import com.weg.FloriculturaJPA.model.Servicos;
import com.weg.FloriculturaJPA.repository.ServicosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicosService {

    private final ServicosRepository repository;
    private final ServicosMapper mapper;

    public ServicosRespostaDTO adicionarServicos(ServicosRequisicaoDTO servico){
        Servicos servicoSalvo = mapper.DTOParaEntidade(servico);
        return mapper.EntidadeParaDTO(repository.save(servicoSalvo));
    }

    public ServicosRespostaDTO buscarServicosPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o serviço pelo ID indicado!")));
    }

    public ServicosRespostaDTO buscarServicosPorIdENome(Long id, String nome){
        return mapper.EntidadeParaDTO(repository.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o serviço pelo ID e nome indicados!")));
    }

    public ServicosRespostaDTO buscarServicosPorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o serviço pelo nome indicado!")));
    }

    public ServicosRespostaDTO buscarServicosPorValor(double valor){
        return mapper.EntidadeParaDTO(repository.findByValor(valor)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o serviço pelo valor indicado!")));
    }

    public List<ServicosRespostaDTO> listarServicos(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    public ServicosRespostaDTO atualizarServicos(ServicosRequisicaoDTO servico, Long id){
        Servicos servicoSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o serviço pelo ID indicado!"));
        servicoSalvo.setNome(servico.nome());
        servicoSalvo.setDescricao(servico.descricao());
        servicoSalvo.setValor(servico.valor());
        return mapper.EntidadeParaDTO(repository.save(servicoSalvo));
    }

    public void deletarServicos(Long id){
        repository.deleteById(id);
    }
}
