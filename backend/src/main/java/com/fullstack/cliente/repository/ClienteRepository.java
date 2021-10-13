package com.fullstack.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.cliente.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long>{

	   Cliente findByCpf(String cpf) ;
	 
}
