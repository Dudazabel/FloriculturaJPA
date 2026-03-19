package com.weg.FloriculturaJPA.controller;

import com.weg.FloriculturaJPA.dto.FornecedoresDTO.FornecedoresRequisicaoDTO;
import com.weg.FloriculturaJPA.dto.FornecedoresDTO.FornecedoresRespostaDTO;
import com.weg.FloriculturaJPA.service.FornecedoresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedoresController {

    private final FornecedoresService service;

    @PostMapping
    public FornecedoresRespostaDTO adicionarFornecedores(@RequestBody FornecedoresRequisicaoDTO fornecedor){
        return service.adicionarFornecedores(fornecedor);
    }

    @GetMapping("/{id}")
    public FornecedoresRespostaDTO buscarFornecedoresPorID(@PathVariable Long id){
        return service.buscarFornecedoresPorID(id);
    }

    @GetMapping("/{id}/{nome}")
    public FornecedoresRespostaDTO buscarFornecedoresPorIdENome(@PathVariable Long id, @PathVariable String nome){
        return service.buscarFornecedoresPorIdENome(id, nome);
    }

    @GetMapping("/{nome}")
    public FornecedoresRespostaDTO buscarFornecedoresPorNome(@PathVariable String nome){
        return service.buscarFornecedoresPorNome(nome);
    }

    @GetMapping("/{material}")
    public FornecedoresRespostaDTO buscarFornecedoresPorMaterial(@PathVariable String material){
        return service.buscarFornecedoresPorMaterial(material);
    }

    @GetMapping("/{nome}/{material}")
    public FornecedoresRespostaDTO buscarFornecedoresPorNome(@PathVariable String nome, @PathVariable String material){
        return service.buscarFornecedoresPorNomeEMaterial(nome, material);
    }

    @GetMapping
    public List<FornecedoresRespostaDTO> listarFornecedores(){
        return service.listarFornecedores();
    }

    @PutMapping("/{id}")
    public FornecedoresRespostaDTO atualizarFornecedores(@RequestBody FornecedoresRequisicaoDTO fornecedor, @PathVariable Long id){
        return service.atualizarFornecedores(fornecedor, id);
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedores(@PathVariable Long id){
        service.deletarFornecedores(id);
    }
}
