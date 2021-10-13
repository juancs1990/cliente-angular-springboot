package com.fullstack.cliente.modelo;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fullstack.cliente.services.validations.ClienteInsertValid;

@Entity
@ClienteInsertValid
public class Cliente  {
 
	 
	public Cliente(Long id,  String nome,
			  String cpf, Date data) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
	}
 
	public Cliente() {
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty(message="{nome.vazio}")
	private String nome;
	@Column (unique = true ,nullable = false, length=11)
 	@NotNull(message="{cpf.vazio}")
	@CPF(message="{cpf.invalido}")
	@Size(min = 1, max=11,message = "{cpf.invalido}")
	private String cpf;
	@Column (updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	@PrePersist
	void prePersiste (){
		 
		this.data = Date.from(Instant.now());
		
	}

}
