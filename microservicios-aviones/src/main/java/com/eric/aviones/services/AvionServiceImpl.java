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
	public Avion update(AvionDTO avionDTO, Long id) {
		Optional<Avion> opt = repository.findById(id);
		if (opt.isPresent()) {
			Avion avion = mapper.dtoToEntity(avionDTO);
			avion.setId(id);
			return repository.save(avion);
		}
		return null;
	}

}
