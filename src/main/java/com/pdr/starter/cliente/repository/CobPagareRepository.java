/**
 * 
 */
package com.pdr.starter.cliente.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.CobPagareModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface CobPagareRepository extends JpaRepository<CobPagareModel, BigDecimal> {
    
}

