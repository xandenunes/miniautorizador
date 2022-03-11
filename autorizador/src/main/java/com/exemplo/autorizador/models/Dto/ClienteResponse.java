package com.exemplo.autorizador.models.Dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.exemplo.autorizador.models.Cartao;
import com.exemplo.autorizador.models.Cliente;

public class ClienteResponse {
	public String cpf;
	public Integer id;
    public String data_inicio;
    List<Cartao> cartoes = new ArrayList<>();
    EnderecoResponse endereco;

    public ClienteResponse(String cpf, Integer id, String data_inicio, List<Cartao> cartoes, EnderecoResponse endereco) {
        this.cpf=cpf;
        this.id = id;
        this.data_inicio = data_inicio;
        this.cartoes = cartoes;
        this.endereco = endereco;
    }

    public ClienteResponse(){}

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.cpf=cliente.getCpf();
        this.data_inicio = formatarData(cliente.getData_inicio());
        this.cartoes = cliente.getCartoes();
        this.endereco = new EnderecoResponse(cliente.getEndereco());
    }
    
    public static String formatarData(LocalDate data){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public EnderecoResponse getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResponse endereco) {
		this.endereco = endereco;
	}
    
}
