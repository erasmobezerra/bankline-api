package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.MovimentacaoRespository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
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
    public void save(@RequestBody NovoCorrentista correntista) {
        correntistaService.save(correntista);
    }


    // Delete o Correntista e suas respectivas movimentações
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        correntistaService.deleteById(id);
        List<Movimentacao> movimentacaoes = movimentacaoRespository.findByIdConta(id);
        movimentacaoService.deleteAllById(movimentacaoes);
    }
}
