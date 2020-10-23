package com.matheus.osworks.controller.exceptions;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, OffsetDateTime datHora, String titulo, String path) {
		super(status, datHora, titulo, path);		
	}

	public List<FieldMessage> getErrors(){
		return errors;
	}
	
	public void addError(String field, String message) {
		errors.add(new FieldMessage(field, message));
	}	
}