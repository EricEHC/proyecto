package com.eric.commons.entities.models;


import java.time.LocalDate;

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



@Entity
@Table(name="AVION")
public class Avion {
	
    @Id
 	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="AVION_SEQ")
 	@SequenceGenerator(name="AVION_SEQ", sequenceName ="AVION_SEQ", allocationSize = 1 )
    @Column(name= "ID_AVION")
    private long id;
    
	@Column(name= "NUM_REGISTRO")
	@NotBlank(message = "El numero de registro es obligatorio")
    private long numeroRegistro;
	
	@Column(name= "TIPO")
	@NotBlank(message = "El tipo de avion es obligatorio")
	@Size(min=1,max=50,message="El tipo de avion debe tener entre 1 y 50 caracteres")
    private String tipo;
	
	
	
	
	@Column(name= "CODIGO_MODELO")
	@NotBlank(message = "El codigo del modelo de avion es obligatorio")
	@Size(min=1,max=50,message="El codigo del modelo debe tener entre 1 y 50 caracteres")		
    private String codigoModelo;
	
	@Column(name= "CAPACIDAD")
	@NotNull(message = "LA capacidad es obligatoriao")
	@Min(value = 0, message = "La capacidad debe de ser al menos 0")
    private Long capacidad;
	
	@Column(name= "FECHA_PRIMER_VUELO")
	@NotNull(message = "La fecha de primer vuelo es obligatoria")
	@Past(message = "La fecha de primer vuelo debe ser anterior a la fecha actual")
    private LocalDate fechaPrimerVuelo;
	
	
	
	@Column(name= "ID_ESTATUS")
	@NotNull(message = "El estatus es obligatorio")
	@Min(value=1, message="El estatus debe ser de al menos 1")
	@Max(value=2, message="El estatus no debe ser mayor a 2")
	private Long status;
    
	
	
	
	@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name= "ID_AEROLINEA",referencedColumnName = "ID_AEROLINEA")
	@NotNull(message = "La aerolinea es obligatoria")
    private Aerolinea aerolinea;


	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public long getNumeroRegistro() {
		return numeroRegistro;
	}





	public void setNumeroRegistro(long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}





	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public String getCodigoModelo() {
		return codigoModelo;
	}





	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}





	public Long getCapacidad() {
		return capacidad;
	}





	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}





	public LocalDate getFechaPrimerVuelo() {
		return fechaPrimerVuelo;
	}





	public void setFechaPrimerVuelo(LocalDate fechaPrimerVuelo) {
		this.fechaPrimerVuelo = fechaPrimerVuelo;
	}





	public Long getStatus() {
		return status;
	}





	public void setStatus(Long status) {
		this.status = status;
	}





	public Aerolinea getAerolinea() {
		return aerolinea;
	}





	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
    
   
    
    

}
