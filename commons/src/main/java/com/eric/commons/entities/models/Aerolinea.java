package com.eric.commons.entities.models;

import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="AEROLINEA")
public class Aerolinea {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="AEROLINEA_SEQ")
	@SequenceGenerator(name="AEROLINEA_SEQ", sequenceName ="AEROLINEA_SEQ", allocationSize = 1 )
    @Column(name= "ID_AEROLINEA")
	private Long id;
	
	@Column(name= "NOMBRE")
	@NotBlank(message = "El nombre de la arolinea es obligatoria")
	@Size(min=1,max=50,message="El nombre de la aerolinea debe tenetr entre 1 y 50 caracteres")
	private String nombre;
	
	@Column(name= "IATA")
	@NotBlank(message = "El iata de la arolinea es obligatoria")
	@Size(min=1,max=50,message="El iata de la aerolinea debe tenetr entre 1 y 50 caracteres")
	private String iata;
	
	@Column(name= "PAIS")
	@NotBlank(message = "El pais de la arolinea es obligatoria")
	@Size(min=1,max=50,message="El pais de la aerolinea debe tener entre 1 y 50 caracteres")	
	private String pais;
	
	@Column(name= "FECHA_FUNDACION")
	@NotNull(message = "La fecha de fundacion es obligatoria")
	@Past(message = "La fecha de fundacion debe ser anterior a la fecha actual")
	private LocalDate fechaFundacion;
	
	@Column(name= "ID_ESTATUS")
	@NotNull(message = "El estatus es obligatorio")
	@Min(value=1, message="El estatus debe ser de al menos 1")
	@Max(value=2, message="El estatus no debe ser mayor a 2")
	private Long estatus;
		

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getIata() {
		return iata;
	}


	public void setIata(String iata) {
		this.iata = iata;
	}


	public Long getStatus() {
		return estatus;
	}


	public void setStatus(Long estatus) {
		this.estatus = estatus;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}


	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

}
