package com.pdr.starter.cliente.repository.sp;

import java.util.Map;

import com.pdr.starter.cliente.dto.GenPersonaIdRequest;

/**
 * Interfaz del repositorio que hace el llamado a una funcion de oracle
 * 
 * @author Patricio Martinez
 *
 */

public interface AtcparGetListContRolRepository {
	
	/**
	 * Funcion que obtiene todos los contratos activos de un cliente.
	 * 
	 * @param dto
	 * @return
	 */
	
	public Map<String, Object> getListContratos(GenPersonaIdRequest dto);

}
