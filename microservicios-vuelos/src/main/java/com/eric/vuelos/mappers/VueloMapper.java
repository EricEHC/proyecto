package com.eric.vuelos.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.eric.commons.entities.models.Aeropuerto;
import com.eric.commons.entities.models.Avion;
import com.eric.vuelos.clients.AeropuertoClientTemp;
import com.eric.vuelos.clients.AvionClientTemp;
import com.eric.vuelos.dto.VueloDTO;
import com.eric.vuelos.models.entity.Vuelo;

public class VueloMapper {
	
	@Autowired
	private AeropuertoClientTemp aeropuertoClientTemp;
	
	@Autowired
	private AvionClientTemp vueloClientTemp;

	public  VueloDTO entityToDto(Vuelo vuelo) {
		if(vuelo==null) {
			return null;
		}
		VueloDTO vueloDTO = new VueloDTO();
		vueloDTO.setId(vuelo.getId());
		vueloDTO.setCodigoVuelo(vuelo.getCodigoVuelo());
		vueloDTO.setFechaSalida(vuelo.getFechaSalida());
		vueloDTO.setEstatus(vuelo.getEstatus());
		
		if(vuelo.getIdAvion()!= null) {
			vueloDTO.setIdAvion(vuelo.getIdAvion().getId());
			
		}
		if(vuelo.getAeropuertoOrigen()!= null) {
			vueloDTO.setIdOrigen(vuelo.getAeropuertoDestino().getId());
			
		}
		if(vuelo.getAeropuertoDestino()!= null) {
			vueloDTO.setIdDestino(vuelo.getAeropuertoDestino().getId());
			
		}
		return vueloDTO;
		
		
	}

	public  Vuelo dtoToEntity(VueloDTO vueloDTO) {
		if(vueloDTO ==null) {
			return null;
		}
		Vuelo vuelo=new Vuelo();
		vuelo.setId(vueloDTO.getId());
		vuelo.setCodigoVuelo(vueloDTO.getCodigoVuelo());
		vuelo.setFechaSalida(vueloDTO.getFechaSalida());
		vuelo.setEstatus(vueloDTO.getEstatus());
	    Optional<Avion> avion=vueloClientTemp.getAvionById(vueloDTO.getIdAvion());
	    vuelo.setIdAvion(avion.isPresent()?avion.get():null);
	    Optional<Aeropuerto> aeropuertoOrigen=aeropuertoClientTemp.getAeropuertoById(vueloDTO.getIdOrigen());
	    vuelo.setAeropuertoOrigen(aeropuertoOrigen.isPresent()?aeropuertoOrigen.get():null);   
	    Optional<Aeropuerto> aeropuertoDestino=aeropuertoClientTemp.getAeropuertoById(vueloDTO.getIdDestino());
	    vuelo.setAeropuertoDestino(aeropuertoDestino.isPresent()?aeropuertoDestino.get():null); 
	
		return vuelo;
		
	}
}
