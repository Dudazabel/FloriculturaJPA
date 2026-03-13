package com.weg.FloriculturaJPA.service;

import com.weg.FloriculturaJPA.dto.ClientesDTO.ClienteSRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.ClientesDTO.ClientesRespostaDTO;
import com.weg.FloriculturaJPA.mapper.ClientesMapper;
import com.weg.FloriculturaJPA.model.Clientes;
import com.weg.FloriculturaJPA.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientesService {

    private final ClientesRepository repository;
    private final ClientesMapper mapper;

    public ClientesRespostaDTO adicionarClientes(ClienteSRequisicaoDTO cliente){
        Clientes clienteSalvo = mapper.DTOParaEntidade(cliente);
        return mapper.EntidadeParaDTO(repository.save(clienteSalvo));
    }

    public ClientesRespostaDTO buscarClientesPorID(Long id){
        return mapper.EntidadeParaDTO(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o cliente pelo ID indicado!")));
    }

    public List<ClientesRespostaDTO> listarClientes(){
        return mapper.EntidadeParaDTOLista(repository.findAll());
    }

    public ClientesRespostaDTO atualizarClientes(ClienteSRequisicaoDTO cliente, Long id){
        Clientes clienteSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o cliente pelo ID indicado!"));
        clienteSalvo.setNome(cliente.nome());
        clienteSalvo.setTelefone(cliente.telefone());
        return mapper.EntidadeParaDTO(repository.save(clienteSalvo));
    }

    public void deletarClientes(Long id){
        repository.deleteById(id);
    }
}
