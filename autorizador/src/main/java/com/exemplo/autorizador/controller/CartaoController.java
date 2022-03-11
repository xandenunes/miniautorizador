package com.exemplo.autorizador.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exemplo.autorizador.exceptions.CartaoInvalidoException;
import com.exemplo.autorizador.exceptions.SaldoInsuficienteException;
import com.exemplo.autorizador.exceptions.SenhaInvalidaException;
import com.exemplo.autorizador.models.Cartao;
import com.exemplo.autorizador.models.Dto.CartaoRequest;
import com.exemplo.autorizador.models.Dto.TransacaoDto;
import com.exemplo.autorizador.service.CartaoService;

@Controller
public class CartaoController {

	@Autowired
	private CartaoService service;
	
	@GetMapping("/cartoes")
    private ResponseEntity<List<Cartao>> ListaCartoes() {
        return new ResponseEntity<List<Cartao>>(service.ListaCartoes(), HttpStatus.OK);
    }
	
	@PostMapping("/cartoes")
	private ResponseEntity<CartaoRequest> criarCartao(@RequestBody(required = true) @Validated CartaoRequest novoCartao){
		try {
			return new ResponseEntity<CartaoRequest>(service.criarCartao(novoCartao), HttpStatus.CREATED);
		}catch (CartaoInvalidoException ex) {
            return new ResponseEntity<CartaoRequest>(novoCartao, HttpStatus.UNPROCESSABLE_ENTITY);
        }
	}
	
	@GetMapping("/cartoes/{numero}")
	private ResponseEntity<Double> consultarSaldo(@PathVariable("numero") String numero){
		try {
			return new ResponseEntity<Double>(service.consultarCartao(numero).getSaldo(), HttpStatus.OK);
		}catch(CartaoInvalidoException ex){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/transacoes")
	private ResponseEntity<String> criarTransacoes(@RequestBody(required = true) @Validated TransacaoDto transacaoDto){
		try {
			return new ResponseEntity<String>(service.criarTransacoes(transacaoDto), HttpStatus.CREATED);
		}catch (CartaoInvalidoException ex) {
            return new ResponseEntity<String>("CARTAO_INEXISTENTE", HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (SaldoInsuficienteException ex) {
            return new ResponseEntity<String>("SALDO_INSUFICIENTE", HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (SenhaInvalidaException ex) {
            return new ResponseEntity<String>("SENHA_INVALIDA", HttpStatus.UNPROCESSABLE_ENTITY);
        }
	}
}
