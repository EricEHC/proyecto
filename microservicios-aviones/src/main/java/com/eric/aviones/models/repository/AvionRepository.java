package com.eric.aviones.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.commons.entities.models.Avion;

public interface AvionRepository extends JpaRepository<Avion, Long>{
	

}
