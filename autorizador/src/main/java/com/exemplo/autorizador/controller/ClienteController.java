package com.exemplo.autorizador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exemplo.autorizador.exceptions.CartaoInvalidoException;
import com.exemplo.autorizador.exceptions.ClienteInvalidoException;
import com.exemplo.autorizador.models.Dto.ClienteRequest;
import com.exemplo.autorizador.models.Dto.ClienteResponse;
import com.exemplo.autorizador.models.Dto.EnderecoResponse;
import com.exemplo.autorizador.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<Object> criar(@RequestBody ClienteRequest clienteRequest){

        try {
            return new ResponseEntity<Object>(clienteService.criar(clienteRequest), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(clienteRequest, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<ClienteResponse> obterCliente(@PathVariable(required = true) Integer idCliente){
    	try {
    		return new ResponseEntity<ClienteResponse>(clienteService.obterCliente(idCliente), HttpStatus.OK);
		}catch(ClienteInvalidoException ex){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}  
    }
    
    @GetMapping("/cliente/{idCliente}/endereco")
    public ResponseEntity<EnderecoResponse> obterEndereco(@PathVariable(required = true) Integer idCliente){
    	try {
    		return new ResponseEntity<EnderecoResponse>(clienteService.obterEndereco(idCliente), HttpStatus.OK);
		}catch(ClienteInvalidoException ex){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}  
    }
}
