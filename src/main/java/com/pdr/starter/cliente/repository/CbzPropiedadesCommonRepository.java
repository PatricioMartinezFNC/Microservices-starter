package com.pdr.starter.cliente.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pdr.starter.cliente.model.CbzPropiedadesModel;


public interface CbzPropiedadesCommonRepository extends JpaRepository<CbzPropiedadesModel, Integer> {
	
	Optional<CbzPropiedadesModel> findByCpPropKey(String key);
	
	@Query(value = " select sysdate  from dual " , nativeQuery = true)
	Date getDate(); 
	
	@Query(value = " select count(*) from cbzpar.cbz_gest_dias_festivos where gdf_dia_festivo = :fecha " , nativeQuery = true)
	Integer getDiaFestivo(Date fecha);
	
	@Query(value = " select value from  cbzpar.CBZ_EXCEPCIONES_PROP where key = :key " , nativeQuery = true)
	String getValueException(String key);

}
