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

    @GetMapping("/{id}/{nome}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorIdENome(@PathVariable Long id, @PathVariable String nome){
        return service.buscarTrabalhadoresPorIdENome(id, nome);
    }

    @GetMapping("/{nome}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorNome(@PathVariable String nome){
        return service.buscarTrabalhadoresPorNome(nome);
    }

    @GetMapping("/{nome}/{cargo}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorNomeECargo(@PathVariable String nome, @PathVariable String cargo){
        return service.buscarTrabalhadoresPorNomeECargo(nome, cargo);
    }

    @GetMapping("/{cargo}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorCargo(@PathVariable String cargo){
        return service.buscarTrabalhadoresPorCargo(cargo);
    }

    @GetMapping("/{email}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorEmail(@PathVariable String email){
        return service.buscarTrabalhadoresPorEmail(email);
    }

    @GetMapping("/{salario}")
    public TrabalhadoresRespostaDTO procurarTrabalhadoresPorSalario(@PathVariable double salario){
        return service.buscarTrabalhadoresPorSalario(salario);
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
