package com.eric.vuelos.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eric.commons.entities.models.Avion;

@FeignClient(name= "microservicios.aviones")
public interface AvionClientTemp {
	
	@GetMapping("/{id}")
	public Optional<Avion> getAvionById(@PathVariable Long id);

}
