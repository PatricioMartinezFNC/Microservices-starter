/**
 * 
 */
package com.pdr.starter.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.CobContMantCuotaIdModel;
import com.pdr.starter.cliente.model.CobContMantCuotaModel;

/**
 * @description The Interface CobContMantCuotaRepository.
 * @author BS2
 */
@Repository
public interface CobContMantCuotaRepository extends JpaRepository<CobContMantCuotaModel, CobContMantCuotaIdModel> {
    
}

