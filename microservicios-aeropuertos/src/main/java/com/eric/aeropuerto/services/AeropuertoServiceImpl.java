package com.eric.aeropuerto.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eric.aeropuerto.repositories.AeropuertoRepository;
import com.eric.commons.entities.models.Aeropuerto;
import com.eric.commons.services.CommonServiceImpl;

@Service
public class AeropuertoServiceImpl extends CommonServiceImpl<Aeropuerto,AeropuertoRepository>
implements AeropuertoService{

	@Override
	@Transactional
	public Aeropuerto actualizar(Aeropuerto aeropuerto, Long id) {
		Optional<Aeropuerto> optAeropuerto=repository.findById(id);
		if(optAeropuerto.isPresent()) {
			Aeropuerto aeropuertoDb=optAeropuerto.get();
			aeropuertoDb.setNombre(aeropuerto.getNombre());
			aeropuertoDb.setCodigo(aeropuerto.getCodigo());
			aeropuertoDb.setLatitud(aeropuerto.getLatitud());
			aeropuertoDb.setLongitud(aeropuerto.getLongitud());
			aeropuertoDb.setPais(aeropuerto.getPais());
			aeropuertoDb.setStatus(aeropuerto.getStatus());
			return aeropuertoDb;
		}
		return null;
	}
	
	

}
