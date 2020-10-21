package com.matheus.osworks.controller.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheus.osworks.services.exceptions.DoMainException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation (MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String titulo = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente";
		ValidationError err = new ValidationError(status.value(), LocalDateTime.now(), titulo);
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}			
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DoMainException.class)
	public ResponseEntity<StandardError> doMainException(DoMainException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;		
		StandardError se = new StandardError(status.value(), LocalDateTime.now(), e.getMessage());
		return ResponseEntity.status(status).body(se);
	}	
}