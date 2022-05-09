package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private MovimentacaoRespository movimentacaoRespository;

    public List<Correntista> findAll() {
        return correntistaRepository.findAll();
    }

    public void save(NovoCorrentista novoCorrentista) {
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0); // A nova conta cadastrada terá saldo 0.0
        conta.setNumero(new Date().getTime()); // Aqui o número da nova conta será o valor em milissegundos da hora atual

        correntista.setConta(conta);
        correntistaRepository.save(correntista);
    }


    public void deleteById(Integer id) {
        correntistaRepository.deleteById(id);
    }
}
