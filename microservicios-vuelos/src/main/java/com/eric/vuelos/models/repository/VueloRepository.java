package com.eric.vuelos.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.vuelos.models.entity.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long>{
	
	

}
