package com.exemplo.autorizador.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.exemplo.autorizador.models.Dto.CartaoRequest;

@Entity
public class Cartao {
	@Id
	@Column(unique = true)
	private String numeroCartao;
	private double saldo;
    private String senha; 
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;
    private LocalDate validade;
    @ManyToOne
    @JoinColumn(name="cartoes")
    private Cliente cliente;
   
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
        this.dataCriacao = LocalDate.now();
        this.validade = LocalDate.now().plusYears(3).plusMonths(10);
	}
	
	public static String formatarData(LocalDate data){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
