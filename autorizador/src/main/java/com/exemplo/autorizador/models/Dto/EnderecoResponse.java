package com.exemplo.autorizador.models.Dto;

import com.exemplo.autorizador.models.Endereco;

public class EnderecoResponse {
	
	private Integer id;
	private String logradouro;
    private String cidade;
    private String estado;
    private String complemento;
    
    
	public EnderecoResponse(Integer id, String logradouro, String cidade, String estado, String complemento) {
		this.id = id;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	
	public EnderecoResponse(Endereco endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.complemento = endereco.getComplemento();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
    
}
