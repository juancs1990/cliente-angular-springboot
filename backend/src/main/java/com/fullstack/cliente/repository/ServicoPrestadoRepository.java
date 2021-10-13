package com.fullstack.cliente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstack.cliente.modelo.ServicoPrestado;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

	
 @Query("select s from ServicoPrestado s join s.cliente c where  upper(c.nome) like upper(concat('%',:nome,'%'))  and   month(s.data) = :mes") 
 	List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes")  Integer mes);

}
