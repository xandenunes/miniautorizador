package com.exemplo.autorizador.exceptions;

import org.springframework.stereotype.Component;

@Component
public class AtivadorException {

	public boolean throwSenhaException() {
	    throw new SenhaInvalidaException();
	}
	
	public boolean throwSaldoInsuficienteException() {
	    throw new SaldoInsuficienteException();
	}
	
	public boolean throwCartaoInvalidoException() {
	    throw new CartaoInvalidoException();
	}
}
