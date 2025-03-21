package com.eric.aviones.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eric.aviones.dto.AvionDTO;
import com.eric.aviones.mappers.AvionMapper;
import com.eric.aviones.models.repository.AvionRepository;
import com.eric.commons.entities.models.Avion;
import com.eric.commons.services.CommonServiceImpl;

import jakarta.transaction.Transactional;

@Service
public class AvionServiceImpl extends CommonServiceImpl<Avion, AvionRepository> implements AvionService{
	
	private final AvionMapper mapper;
	
	public AvionServiceImpl(AvionMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public Avion createAvionDTO(AvionDTO avionDTO) {
		Avion avion = mapper.dtoToEntity(avionDTO);
		return repository.save(avion);
	}
	
	@Override
	@Transactional
	public Avion update(Avion avion, Long id) {
		Optional<Avion> optAvion=repository.findById(id);
		if(optAvion.isPresent()) {
			Avion avionDb=optAvion.get();
			avionDb.setTipo(avion.getTipo());
			avionDb.setStatus(avion.getStatus());
			avionDb.setNumeroRegistro(avion.getNumeroRegistro());
			avionDb.setFechaPrimerVuelo(avion.getFechaPrimerVuelo());
			avionDb.setCodigoModelo(avion.getCodigoModelo());
			avionDb.setCapacidad(avion.getCapacidad());
			avionDb.setAerolinea(avion.getAerolinea());			
			return avionDb;
	}
		return null;
	}

	@Override
	public Avion update(AvionDTO avionDTO, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
