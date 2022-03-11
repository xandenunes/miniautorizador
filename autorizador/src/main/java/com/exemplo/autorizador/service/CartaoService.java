package com.exemplo.autorizador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.autorizador.exceptions.AtivadorException;
import com.exemplo.autorizador.models.Cartao;
import com.exemplo.autorizador.models.Dto.CartaoRequest;
import com.exemplo.autorizador.models.Dto.TransacaoDto;
import com.exemplo.autorizador.repository.CartaoRepository;
import com.exemplo.autorizador.utils.Verificador;

@Service
public class CartaoService {
	@Autowired
    private CartaoRepository repository;
	
    @Autowired
    private Verificador verificador;

    @Autowired
    private AtivadorException ativadorException;

	public List<Cartao> ListaCartoes() {
		return repository.findAll();
	}

	public CartaoRequest criarCartao(CartaoRequest novoCartao) {
		if(verificador.verificarCartaoResquest(novoCartao) == true && !repository.existsById(novoCartao.getNumeroCartao())) {
			Cartao cartao = repository.save(new Cartao(novoCartao));
			return new CartaoRequest(cartao);
		}
		else {
			ativadorException.throwCartaoInvalidoException();
		}
		return novoCartao;
	}
	
	public Cartao consultarCartao(String numero) {
		Cartao cartao =  repository.findByNumeroCartao(numero);
		if(verificador.verificarCartaoResquest(new CartaoRequest(cartao)) != true) {
			ativadorException.throwCartaoInvalidoException();
		}
		return cartao;
	}

	public String criarTransacoes(TransacaoDto transacaoDto) {
		Cartao cartao =  this.consultarCartao(transacaoDto.getNumeroCartao());
		if(cartao == null) {
			ativadorException.throwCartaoInvalidoException();
		} else if(!cartao.getSenha().equals(transacaoDto.getSenhaCartao())){
			ativadorException.throwSenhaException();
		}else if(cartao.getSaldo() < transacaoDto.getValor()){
			ativadorException.throwSaldoInsuficienteException();
		}else {
			cartao.setSaldo(cartao.getSaldo()-transacaoDto.getValor());
			repository.save(cartao);
		}
		return "OK";
	}
	
	
}
