package com.eric.aviones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eric.aviones.dto.AvionDTO;
import com.eric.aviones.services.AvionService;
import com.eric.commons.controllers.CommonController;
import com.eric.commons.entities.models.Avion;

import jakarta.validation.Valid;

@RestController
public class AvionController extends CommonController<Avion, AvionService>{
	@PutMapping("/avion-dto")
	public ResponseEntity<?> create(@Valid @RequestBody AvionDTO avionDTO, BindingResult result){
		//return ResponseEntity.status(HttpStatus.CREATED).body(avionDto)
		if (result.hasErrors()) {
			return this.validar(result);  
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createAvionDTO(avionDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody AvionDTO avionDTO, BindingResult result,
			@PathVariable Long id){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Avion avion = service.update(avionDTO, id);
		if (avionDTO != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(avion);
		}
		return ResponseEntity.notFound().build();
	}

}
