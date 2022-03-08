package com.exemplo.autorizador.models.resquest;

public class TransacaoDto {
    private String numeroCartao;
    private String senhaCartao;
    private double valor;
    
	public TransacaoDto() {
	
	}
	public TransacaoDto(String numeroCartao, String senhaCartao, double valor) {
	
		this.numeroCartao = numeroCartao;
		this.senhaCartao = senhaCartao;
		this.valor = valor;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getSenhaCartao() {
		return senhaCartao;
	}
	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
