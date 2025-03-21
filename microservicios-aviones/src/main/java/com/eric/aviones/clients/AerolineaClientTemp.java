package com.eric.aviones.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eric.commons.entities.models.Aerolinea;

@FeignClient(name = "microservicios-aerolineas")
public interface AerolineaClientTemp {
	
	@GetMapping("/{id}")
	public Optional<Aerolinea> getAerolineaById(@PathVariable Long id);
	

}
