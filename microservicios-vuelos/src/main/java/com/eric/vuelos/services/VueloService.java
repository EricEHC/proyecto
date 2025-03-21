package com.eric.vuelos.services;

import com.eric.commons.services.CommonService;
import com.eric.vuelos.dto.VueloDTO;
import com.eric.vuelos.models.entity.Vuelo;

public interface VueloService extends CommonService<Vuelo>{
	
	public Vuelo CreateVueloDto(VueloDTO vueloDto);
	public Vuelo update (Vuelo vuelo, Long id);
	

}
