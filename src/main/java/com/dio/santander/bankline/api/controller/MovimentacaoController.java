package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRespository;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRespository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        service.save(movimentacao);
    }
}
