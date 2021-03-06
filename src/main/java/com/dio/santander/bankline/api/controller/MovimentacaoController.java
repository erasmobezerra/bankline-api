package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRespository;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private MovimentacaoRespository movimentacaoRespository;

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta) {
        return movimentacaoService.findByIdConta(idConta);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        movimentacaoService.save(movimentacao);
    }

}
