package com.fullstack.cliente.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
 
@Entity
public class ServicoPrestado  {
	 
	

	public ServicoPrestado(Long id, String descricao, BigDecimal valor, Date data, Cliente cliente) {
 		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.cliente = cliente;
	}
	
	public ServicoPrestado() {
		
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	 
	  
	@Column
	private BigDecimal valor;
	
	@Column (updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@ManyToOne
	Cliente cliente;
	
 
	
}
