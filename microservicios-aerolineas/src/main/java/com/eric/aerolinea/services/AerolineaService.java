package com.eric.aerolinea.services;

import com.eric.commons.entities.models.Aerolinea;
import com.eric.commons.services.CommonService;

public interface AerolineaService extends CommonService<Aerolinea>{
	Aerolinea update (Aerolinea aerolinea,Long id);

}
