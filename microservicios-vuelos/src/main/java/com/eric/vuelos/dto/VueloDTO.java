package com.eric.vuelos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class VueloDTO {
	
	private Long id;
	
	@NotBlank(message = "El codigo de vuelo no puede estar vacio.")
	@Size(max=50,message = "El codigo de vuelo no puede exceder losw 50 caracteres")
	private String codigoVuelo;
	
	@NotNull(message="El id del avion no puede ser nulo")
	@Min(value=1, message ="El id del avion no puede ser menor que 1")
	private Long idAvion;
	
	@NotNull(message="El id del Aeropuerto de origen no puede ser nulo")
	@Min(value=1, message ="El id del Aeropuerto de origen no puede ser menor que 1")
	private Long idOrigen;
	
	@NotNull(message="El id del Aeropuerto de destino no puede ser nulo")
	@Min(value=1, message ="El id del Aeropuerto de destino no puede ser menor que 1")
	private Long idDestino;
	
	@NotNull(message="La fecha de salida es obligatoria")
	@Past(message = "La fechaq de salida debe ser anterior qa la fecha aqctual")
	private LocalDate fechaSalida;
	
	@NotNull(message="estatus es obligatorio")
	@Min(value=1, message ="El estatus debe ser al menos 1")
	@Max(value=2, message ="El estatus no puede ser mayor que 2")
	private Long estatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public Long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}

	public Long getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Long idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}
	
	

}