package com.fullstack.cliente.resources.exceptions;

import java.util.HashSet;
import java.util.Set;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private Set<FieldMessage> errors = new HashSet<>();

	public Set<FieldMessage> getErrors() {
		return errors;
	}	
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
