package com.pdr.starter.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.VtaPgreOperContIdModel;
import com.pdr.starter.cliente.model.VtaPgreOperContModel;

/**
 * @description The Interface VtaPgreOperContRepository.
 * @author BS2
 */
@Repository
public interface VtaPgreOperContRepository extends JpaRepository<VtaPgreOperContModel, VtaPgreOperContIdModel> {
    
}

