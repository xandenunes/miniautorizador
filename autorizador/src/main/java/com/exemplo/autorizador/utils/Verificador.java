package com.exemplo.autorizador.utils;

import org.springframework.stereotype.Component;

import com.exemplo.autorizador.models.Dto.CartaoRequest;
@Component
public class Verificador {
	public boolean verificarCartaoResquest(CartaoRequest cartao) {
        return !ehNuloOuVazio(cartao.getNumeroCartao()) && cartao.getNumeroCartao().length() == 16 && !ehNuloOuVazio(cartao.getSenha());
    }

    private boolean ehNuloOuVazio(String s) {
        return s == null || s.isBlank();
    }
}
