package com.eric.vuelos.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eric.commons.entities.models.Aeropuerto;

@FeignClient(name = "Microservicios-Aeropuerto")
public interface AeropuertoClientTemp {
	
	@GetMapping("/id")
	public Optional<Aeropuerto> getAeropuertoById(@PathVariable Long id);

}
