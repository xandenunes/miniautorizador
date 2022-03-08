package com.exemplo.autorizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.autorizador.models.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String>{

	Cartao findByNumeroCartao(String numero);

}