package com.pdr.starter.cliente.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.VtaContratosModel;

/**
 * @description The Interface VtaContratosRepository.
 * @author BS2
 */
@Repository
public interface VtaContratosRepository extends JpaRepository<VtaContratosModel, BigDecimal> {
    
}

