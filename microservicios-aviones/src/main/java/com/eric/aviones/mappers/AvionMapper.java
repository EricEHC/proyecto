package com.eric.aviones.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eric.aviones.clients.AerolineaClientTemp;
import com.eric.aviones.dto.AvionDTO;
import com.eric.commons.entities.models.Aerolinea;
import com.eric.commons.entities.models.Avion;

@Component
public class AvionMapper {
	
	@Autowired
	private AerolineaClientTemp aerolineaClient;
	
	//Convierte una entidad Avion a AvionDTO
	public AvionDTO entityToDto(Avion avion) {
		if (avion == null) {
			return null;
		}
		AvionDTO avionDTO = new AvionDTO();
		avionDTO.setId(avion.getId());
		avionDTO.setNumeroRegistro(avion.getNumeroRegistro());
		avionDTO.setTipo(avion.getTipo());
		avionDTO.setCodigoModelo(avion.getCodigoModelo());
		avionDTO.setCapacidad(avion.getCapacidad());
		avionDTO.setFechaPrimerVuelo(avion.getFechaPrimerVuelo());
		avionDTO.setStatus(avion.getStatus());
		avionDTO.setIdAerolinea(avion.getAerolinea() != null? avion.getAerolinea().getId() : null);
		
		return avionDTO;
		
	}
	
	//Convierte un AvionDTO a una entidad Avion
	public Avion dtoToEntity(AvionDTO avionDTO) {
		if (avionDTO == null) {
			return null;
		}
		Avion avion = new Avion();
		avion.setId(avionDTO.getId());
		avion.setNumeroRegistro(avionDTO.getNumeroRegistro());
		avion.setTipo(avionDTO.getTipo());
		avion.setCodigoModelo(avionDTO.getCodigoModelo());
		avion.setCapacidad(avionDTO.getCapacidad());
		avion.setFechaPrimerVuelo(avionDTO.getFechaPrimerVuelo());
		avion.setStatus(avionDTO.getStatus());
		Optional<Aerolinea> aerolinea = aerolineaClient.getAerolineaById(avionDTO.getIdAerolinea());
		avion.setAerolinea(aerolinea.isPresent()? aerolinea.get() : null);
		return avion;
		
		
	}

}
