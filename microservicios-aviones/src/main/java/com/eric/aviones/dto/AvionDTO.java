package com.eric.aviones.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class AvionDTO {
	
	private Long id;
	
	@NotNull(message = "El numero de registro es obligatorio")
	@Min(value = 1000, message = "El numero de registro debe ser al menos 1000")
	private Long numRegistro;
	
	@NotBlank(message = "El tipo no puede estar vacio.")
	@Size(max = 50, message = "El tipo no puede exceder los 50 caracteres.")
	private String tipo;
	
	@NotBlank(message = "El codigo de modelo no puede estar vacio.")
	@Size(max = 50, message = "El codigo de modelo no puede exceder los 50 caracteres.")
	private String codigoModelo;
	
	@NotNull(message = "La capacidad es obligatoria")
	@Min(value = 0, message = "La capacidad debe ser al menos 0")
	private Long capacidad;
	
	@NotNull(message = "La fecha del primer vuelo es obligatoria")
	@Past(message = "La fecha de primer vuelo debe ser anterior a la fecha actual")
	private LocalDate fechaPrimerVuelo;
	
	@NotNull(message = "El estatus es obligatorio")
	@Min(value = 1, message = "El estatus debe ser al menos 1")
	@Max(value = 2, message = "El estatus no debe ser mayor que 2")
	private Long estatus;
	
	@NotNull(message = "El id de la Aerolinea no puede ser nulo")
	@Min(value = 1, message = "El valor del id de la Aerolinea no puede ser menor a 1")
	private Long idAerolinea;
	
	

}
