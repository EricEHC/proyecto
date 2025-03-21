package com.eric.commons.entities.models;


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
import jakarta.validation.constraints.Size;


@Entity
@Table(name="AEROPUERTO")
public class Aeropuerto {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator ="AEROPUERTO_SEQ")
	@SequenceGenerator(name="AEROPUERTO_SEQ", sequenceName ="AEROPUERTO_SEQ", allocationSize = 1 )
    @Column(name= "ID_AEROPUERTO")
	private Long id;
	
	@Column(name= "NOMBRE")
	@NotBlank(message = "El nombre de la arolinea es obligatoria")
	@Size(min=1,max=50,message="El nombre de la aerolinea debe tenetr entre 1 y 50 caracteres")
	private String nombre;
	
	@Column(name= "CODIGO")
	@NotBlank(message = "El codigo de la arolinea es obligatorio")
	@Size(min=1,max=50,message="El codigo de la aerolinea debe tenetr entre 1 y 50 caracteres")
	private String codigo;
	
	@Column(name= "LATITUD")
	@NotBlank(message = "La latitud de la arolinea es obligatoria")
	@Size(min=1,max=50,message=" Latitud de la aerolinea debe tenetr entre 1 y 50 caracteres")
	private String latitud;
	

	@Column(name= "LONGITUD")
	@NotBlank(message = "La longitud de la arolinea es obligatoria")
	@Size(min=1,max=50,message="la longitudde la aerolinea debe tenetr entre 1 y 50 caracteres")
	private String longitud;
	
	
	@Column(name= "PAIS")
	@NotBlank(message = "El pais de la arolinea es obligatoria")
	@Size(min=1,max=50,message="El pais de la aerolinea debe tener entre 1 y 50 caracteres")	
	private String pais;
	
	
	
	@Column(name= "ID_ESTATUS")
	@NotNull(message = "El estatus es obligatorio")
	@Min(value=1, message="El estatus debe ser de al menos 1")
	@Max(value=2, message="El estatus no debe ser mayor a 2")
	private Long idEstatus;



	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public String getLatitud() {
		return latitud;
	}




	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}




	public String getLongitud() {
		return longitud;
	}




	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}




	public String getPais() {
		return pais;
	}




	public void setPais(String pais) {
		this.pais = pais;
	}




	public Long getStatus() {
		return idEstatus;
	}




	public void setStatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}


}
