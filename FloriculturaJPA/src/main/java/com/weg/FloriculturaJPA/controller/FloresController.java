package com.weg.FloriculturaJPA.controller;

import com.weg.FloriculturaJPA.dto.FloresDTO.FloresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.FloresDTO.FloresRespostaDTO;
import com.weg.FloriculturaJPA.service.FloresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flores")
@RequiredArgsConstructor
public class FloresController {

    private final FloresService service;

    @PostMapping
    public FloresRespostaDTO adicionarFlores(@RequestBody FloresRequisicaoDTO flor){
        return service.adicionarFlores(flor);
    }

    @GetMapping("/{id}")
    public FloresRespostaDTO buscarFloresPorID(@PathVariable Long id){
        return service.buscarFloresPorID(id);
    }

    @GetMapping("/{id}/{nome}")
    public FloresRespostaDTO buscarFloresPorIdENome(@PathVariable Long id, @PathVariable String nome){
        return service.buscarFloresPorIdENome(id, nome);
    }

    @GetMapping("/{nome}")
    public FloresRespostaDTO buscarFloresPorNome(@PathVariable String nome){
        return service.buscarFloresPorNome(nome);
    }

    @GetMapping("/{nome}/{cor}")
    public FloresRespostaDTO buscarFloresPorNomeECor(@PathVariable String nome, @PathVariable String cor){
        return service.buscarFloresPorNomeECor(nome, cor);
    }

    @GetMapping("/{cor}")
    public FloresRespostaDTO buscarFloresPelaCor(@PathVariable String cor){
        return service.bucarFloresPelaCor(cor);
    }

    @GetMapping("/{valor}")
    public FloresRespostaDTO buscarFloresPorValor(@PathVariable double valor){
        return service.buscarFloresPorValor(valor);
    }

    @GetMapping
    public List<FloresRespostaDTO> listarFlores(){
        return service.listarrFlores();
    }

    @PutMapping("/{id}")
    public FloresRespostaDTO atualizarFlores(@RequestBody FloresRequisicaoDTO flor, @PathVariable Long id){
        return service.atualizarFlores(flor, id);
    }

    @DeleteMapping("/{id}")
    public void deletarFlores(@PathVariable Long id){
        service.deletarFlores(id);
    }
}
