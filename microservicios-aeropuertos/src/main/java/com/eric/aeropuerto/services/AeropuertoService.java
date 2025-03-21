package com.eric.aeropuerto.services;

import com.eric.commons.entities.models.Aeropuerto;
import com.eric.commons.services.CommonService;

public interface AeropuertoService extends CommonService<Aeropuerto>{
	Aeropuerto actualizar(Aeropuerto aeropuerto,Long id);

}
