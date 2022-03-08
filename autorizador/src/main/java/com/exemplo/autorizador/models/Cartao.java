package com.exemplo.autorizador.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.exemplo.autorizador.models.resquest.CartaoRequest;

@Entity
public class Cartao {
	@Id
	private String numeroCartao;
	private double saldo;
    private String senha; 
   
    public Cartao() {
	}
	public Cartao(String numeroCartao, double saldo, String senha) {
		this.numeroCartao = numeroCartao;
		this.saldo = saldo;
		this.senha = senha;
	}
	
	public Cartao(CartaoRequest cartao) {
		this.numeroCartao = cartao.getNumeroCartao();
		this.saldo = 500.00;
		this.senha = cartao.getSenha();
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
