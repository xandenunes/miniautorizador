package com.exemplo.autorizador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.exemplo.autorizador.models.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{
	
}
