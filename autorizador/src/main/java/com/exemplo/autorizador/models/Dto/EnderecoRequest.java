package com.exemplo.autorizador.models.Dto;

public class EnderecoRequest {
    private String logradouro;
    private String cidade;
    private String estado;
    private String complemento;

    public EnderecoRequest(String logradouro, String cidade, String estado, String complemento) {
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    public EnderecoRequest() {
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
