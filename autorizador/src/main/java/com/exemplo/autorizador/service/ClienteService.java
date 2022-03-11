package com.exemplo.autorizador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.autorizador.exceptions.AtivadorException;
import com.exemplo.autorizador.models.Cliente;
import com.exemplo.autorizador.models.Dto.ClienteResponse;
import com.exemplo.autorizador.models.Dto.EnderecoResponse;
import com.exemplo.autorizador.models.Dto.ClienteRequest;
import com.exemplo.autorizador.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AtivadorException ativadorException;

    public ClienteResponse criar(ClienteRequest clienteRequest) {

    	Optional<Cliente> clienteExistente = clienteRepository.findByCpf(clienteRequest.getCpf());
        if(clienteExistente.isPresent() ) {
        	ativadorException.throwClienteInvalidoException();
        }else {
        	Cliente cliente = clienteRepository.save(new Cliente(clienteRequest));
        	return new ClienteResponse(cliente);
        }
        
        return new ClienteResponse(clienteExistente.get());
    }
    
    public ClienteResponse obterCliente(Integer idCliente) {

        Optional<Cliente> clienteDto = clienteRepository.findById(idCliente);
        if(clienteDto.isPresent()) {
        	return new ClienteResponse(clienteDto.get());
        }else {
        	ativadorException.throwClienteInvalidoException();
        }
        return null;
    }
    
    public EnderecoResponse obterEndereco(Integer idCliente) {

        Optional<Cliente> clienteDto = clienteRepository.findById(idCliente);
        if(clienteDto.isPresent()) {
        	return new EnderecoResponse(clienteDto.get().getEndereco());
        }else {
        	ativadorException.throwClienteInvalidoException();
        }
        return null;
    }
}
