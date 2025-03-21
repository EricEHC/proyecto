package com.eric.vuelos.models.entity;

import java.time.LocalDate;

import com.eric.commons.entities.models.Aeropuerto;
import com.eric.commons.entities.models.Avion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "VUELO_SEQ")
	@SequenceGenerator(name="VUELO_SEQ", sequenceName = "VUELO_SEQ", allocationSize=1 )
    @Column(name = "ID_VUELO")
	private Long id;
	
	
	@Column(name = "CODIGO_VUELO")
	@NotBlank(message = "El nombre de la aerolinea es obligatoria")
	@Size(min = 1, max = 50, message ="El nombre de la aerolinea debe tener entre 1 y 50 caracteres ")
	private String codigoVuelo;
	
	
	
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializar"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_AVION", referencedColumnName = "ID_AVION")
	@NotNull(message = "El avion es obligatorio")
	private Avion idAvion;
	
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializar"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ORIGEN", referencedColumnName = "ID_AEROPUERTO")
	@NotNull(message = "El aeropuerto de origen es obligatorio")
	private Aeropuerto aeropuertoOrigen;
	
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializar"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_DESTINO", referencedColumnName = "ID_AEROPUERTO")
	@NotNull(message = "El aeropuerto de destino es obligatorio")
	private Aeropuerto aeropuertoDestino;
	
	
	@Column(name = "FECHA_SALIDA")
	@NotNull(message = "La fecha de salida  es obligatoria")
	@Past(message = "La fecha de la fundacion debe ser posterior a la fecha actual")
	
	private LocalDate fechaSalida;
	
	
	
	@Column(name = "ID_ESTATUS")
	@NotBlank(message = "El estatus  es obligatoria")
	@Min(value =1 ,message = "El status debe ser al menos 1")
	@Max(value =2 ,message = "El status no debe ser al mayor a 2")
	@Size(min = 1, max = 50, message ="El status del avion debe tener entre 1 y 50 caracteres ")
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


	public Avion getIdAvion() {
		return idAvion;
	}



	public void setIdAvion(Avion idAvion) {
		this.idAvion = idAvion;
	}



	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}



	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}



	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}



	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
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
