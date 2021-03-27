package com.pdr.starter.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.AtcParametrosModel;

@Repository
public interface AtcParametrosRepository extends JpaRepository<AtcParametrosModel, String> {
	
	
	
}
