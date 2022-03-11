package com.exemplo.autorizador.models.Dto;

public class ClienteRequest {
    private String cpf;
    private EnderecoRequest endereco;

    public ClienteRequest(String cpf, EnderecoRequest endereco) {
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public ClienteRequest() {
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoRequest endereco) {
		this.endereco = endereco;
	}
    
}
