package com.eric.aerolinea.controller;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.eric.aerolinea.services.AerolineaService;
import com.eric.commons.controllers.CommonController;
import com.eric.commons.entities.models.Aerolinea;

import jakarta.validation.Valid;


@RestController
public class AerolineaController extends CommonController<Aerolinea, AerolineaService>  {
		
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Aerolinea aerolinea,BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Aerolinea aerolineaDb= service.update(aerolinea, id);
		if(aerolineaDb != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(aerolineaDb);
		}
		return ResponseEntity.notFound().build();
	}
	
}
