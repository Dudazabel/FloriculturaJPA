package com.weg.FloriculturaJPA.controller;

import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.ServicosDTO.ServicosRespostaDTO;
import com.weg.FloriculturaJPA.service.ServicosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicosController {

    private final ServicosService service;

    @PostMapping
    public ServicosRespostaDTO adicionarServicos(@RequestBody ServicosRequisicaoDTO servico){
        return service.adicionarServicos(servico);
    }

    @GetMapping("/{id}")
    public ServicosRespostaDTO buscarServicosPorID(@PathVariable Long id){
        return service.buscarServicosPorID(id);
    }

    @GetMapping
    public List<ServicosRespostaDTO> listarServicos(){
        return service.listarServicos();
    }

    @PutMapping("/{id}")
    public ServicosRespostaDTO atualizarServicos(@RequestBody ServicosRequisicaoDTO servico, @PathVariable Long id){
        return service.atualizarServicos(servico, id);
    }

    @DeleteMapping("/{id}")
    public void deletarServicos(@PathVariable Long id){
        service.deletarServicos(id);
    }
}
