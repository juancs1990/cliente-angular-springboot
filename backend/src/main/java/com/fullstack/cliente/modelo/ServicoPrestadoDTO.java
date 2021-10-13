package com.fullstack.cliente.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ServicoPrestadoDTO implements Serializable {
	
 
	private static final long serialVersionUID = 1L;
	public ServicoPrestadoDTO( String descricao,
			  String preco,  String data,
			 Long idCliente) {
		this.descricao = descricao;
		this.preco = preco;
		this.data = data;
		this.idCliente = idCliente;
		
	}
	@Column(nullable = false)
	@NotEmpty(message="{descricao.vazio}")
	private String descricao;
	@Column(nullable = false)
	@NotEmpty(message="{valor.vazio}")
	private String preco;
	@Column(nullable = false)
	@NotNull(message="{data.vazio}")
	private String data;
	@Column(nullable = false)
    @NotNull(message="{cliente.invalido}")
	private Long idCliente;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
}
