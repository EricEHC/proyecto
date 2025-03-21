package com.eric.aerolinea.services;

import com.eric.aerolinea.repositories.AerolineaRepository;
import com.eric.commons.entities.models.Aerolinea;
import com.eric.commons.services.CommonServiceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AerolineaServiceImpl extends CommonServiceImpl<Aerolinea, AerolineaRepository> 
implements AerolineaService {
	@Override
	@Transactional
	public Aerolinea update(Aerolinea aerolinea, Long id) {
		Optional<Aerolinea> optAerolinea= repository.findById(id);
		if(optAerolinea.isPresent()) {
			Aerolinea aerolineaDb=optAerolinea.get();
			aerolineaDb.setNombre(aerolinea.getNombre());
			aerolineaDb.setIata(aerolinea.getIata());
			aerolineaDb.setStatus(aerolinea.getStatus());
			aerolineaDb.setFechaFundacion(aerolinea.getFechaFundacion());
			aerolineaDb.setPais(aerolinea.getPais());
			repository.save(aerolineaDb);
			return aerolineaDb;
		}
		return null;
		
	}
	
	

}