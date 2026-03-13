package com.weg.FloriculturaJPA.controller;

import com.weg.FloriculturaJPA.dto.TrabalhadoresDTO.TrabalhadoresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.TrabalhadoresDTO.TrabalhadoresRespostaDTO;
import com.weg.FloriculturaJPA.service.TrabalhadoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhadores")
@RequiredArgsConstructor
public class TrabalhadoresController {

    private final TrabalhadoresService service;

    @PostMapping
    public TrabalhadoresRespostaDTO adicionarTrabalhadores(@RequestBody TrabalhadoresRequisicaoDTO trabalhador){
        return service.adicionarTrabalhadores(trabalhador);
    }

    @GetMapping("/{id}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorID(@PathVariable Long id){
        return service.buscarTrabalhadoresPorID(id);
    }

    @GetMapping
    public List<TrabalhadoresRespostaDTO> listarTrabalhadores(){
        return service.listarTrabalhadores();
    }

    @PutMapping("/{id}")
    public TrabalhadoresRespostaDTO atualizarTrabalhadores(@RequestBody TrabalhadoresRequisicaoDTO trabalhador, @PathVariable Long id){
        return service.atualizarTrabalhadores(trabalhador, id);
    }

    @DeleteMapping("/{id}")
    public void deletarTrabalhadores(@PathVariable Long id){
        service.deletarTrabalhadores(id);
    }
}
