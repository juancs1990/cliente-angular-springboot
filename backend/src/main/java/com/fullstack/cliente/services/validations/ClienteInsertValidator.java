package com.fullstack.cliente.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fullstack.cliente.modelo.Cliente;
import com.fullstack.cliente.repository.ClienteRepository;
import com.fullstack.cliente.resources.exceptions.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsertValid, Cliente> {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void initialize(ClienteInsertValid ann) {
	}

	@Override
	public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
	     Cliente user = repository.findByCpf(cliente.getCpf());
		if (user != null) {
			list.add(new FieldMessage("cpf", "Cpf já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
