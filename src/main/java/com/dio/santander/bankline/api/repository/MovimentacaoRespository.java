package com.dio.santander.bankline.api.repository;

import com.dio.santander.bankline.api.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRespository extends JpaRepository<Movimentacao, Integer> {
}
