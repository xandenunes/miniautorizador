package com.exemplo.autorizador.models.resquest;

import com.exemplo.autorizador.models.Cartao;

public class CartaoRequest {
	private String numeroCartao;
	private String senha; 
	
	
    public CartaoRequest(String numeroCartao, String senha) {
		this.numeroCartao = numeroCartao;
		this.senha = senha;
	}
    
    public CartaoRequest(Cartao cartao) {
		this.numeroCartao = cartao.getNumeroCartao();
		this.senha = cartao.getSenha();
	}
    
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
