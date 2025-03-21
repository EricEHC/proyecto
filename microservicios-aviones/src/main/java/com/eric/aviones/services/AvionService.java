package com.eric.aviones.services;

import com.eric.aviones.dto.AvionDTO;
import com.eric.commons.entities.models.Avion;
import com.eric.commons.services.CommonService;

public interface AvionService extends CommonService<Avion>{
	
	public Avion createAvionDTO(AvionDTO avionDTO);
	
	public Avion update(AvionDTO avionDTO, Long id);

}