package com.pdr.starter.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.starter.cliente.model.CbzTipoDireccionModel;

@Repository
public interface CbzTipoDireccionRepository extends JpaRepository<CbzTipoDireccionModel, Long> {

}
