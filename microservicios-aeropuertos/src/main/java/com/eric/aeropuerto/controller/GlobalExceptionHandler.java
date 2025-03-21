package com.eric.aeropuerto.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> hadleDataIntegrityViolationException(DataIntegrityViolationException e){
		Throwable cause =e.getRootCause();
		
		if(cause !=null && cause.getMessage()!=null) {
			return ResponseEntity.badRequest().body("Errror de integridad"+cause.getMessage());	
			}
		return ResponseEntity.badRequest().body("Violacion en la integridad de datos ");
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> ConstraintViolationException(ConstraintViolationException e){
		return ResponseEntity.badRequest().body("Violacion de restriccion "+ e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> hadleRuntimeException(RuntimeException e){
		return ResponseEntity.badRequest().body("Error "+ e.getMessage());
	}

}
