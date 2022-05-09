package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRespository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaService correntistaService;

    @Autowired
    private MovimentacaoRespository movimentacaoRespository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping
    public List<Correntista> findAll() {
        return correntistaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody NovoCorrentista correntista) {
        correntistaService.save(correntista);
    }


    // Delete o Correntista e suas respectivas movimentações
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        correntistaService.deleteById(id); // Apaga o correntista
        List<Movimentacao> movimentacaoes = movimentacaoRespository.findByIdConta(id); // encontra as movimentações dele
        movimentacaoService.deleteAllById(movimentacaoes); // e agora apaga suas movimentações também
    }
}
