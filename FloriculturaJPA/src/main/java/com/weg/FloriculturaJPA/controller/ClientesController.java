package com.weg.FloriculturaJPA.controller;

import com.weg.FloriculturaJPA.dto.ClientesDTO.ClienteSRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.ClientesDTO.ClientesRespostaDTO;
import com.weg.FloriculturaJPA.service.ClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {

    private final ClientesService service;

    @PostMapping
    public ClientesRespostaDTO adicionarClientes(@RequestBody ClienteSRequisicaoDTO cliente){
        return service.adicionarClientes(cliente);
    }

    @GetMapping("/{id}")
    public ClientesRespostaDTO buscarClientesPorID(@PathVariable Long id){
        return service.buscarClientesPorID(id);
    }

    @GetMapping
    public List<ClientesRespostaDTO> listarClientes(){
        return service.listarClientes();
    }

    @PutMapping("/{id}")
    public ClientesRespostaDTO atualizarClientes(@RequestBody ClienteSRequisicaoDTO cliente, @PathVariable Long id){
        return service.atualizarClientes(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void deletarClientes(@PathVariable Long id){
        service.deletarClientes(id);
    }
}
