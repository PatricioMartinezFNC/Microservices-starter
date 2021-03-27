/**
 * 
 */
package com.pdr.starter.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.CobContMantencionIdModel;
import com.pdr.starter.cliente.model.CobContMantencionModel;

/**
 * @description The Interface CobContMantencionRepository.
 * @author BS2
 */
@Repository
public interface CobContMantencionRepository extends JpaRepository<CobContMantencionModel, CobContMantencionIdModel> {
    
}