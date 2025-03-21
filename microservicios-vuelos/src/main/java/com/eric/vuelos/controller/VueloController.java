package com.eric.vuelos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

import com.eric.commons.controllers.CommonController;
import com.eric.vuelos.dto.VueloDTO;


public class VueloController extends CommonController<Vuelo, VueloService>{
	
	@PostMapping("/vuelo-dto")
	 public ResponseEntity<?> create (@Valid @RequestBody VueloDTO vueloDto,BindingResult result){
		
		if(result.hasErrors()) {
			
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.CreateVueloDto(vueloDto));
	}
	
	
	
       @PutMapping("/{id}")
	public 	ResponseEntity<?> update(@Valid @RequestBody Vuelo vuelo, BindingResult result,
		@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
			
			
		}
		Vuelo vueloDb =service.update(vuelo, id);
		if(vueloDb !=null) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(vuelo);
			
		}
    return ResponseEntity.notFound().build();
		
	}
	

}
