package com.pdr.starter.cliente.service;

import java.util.List;

import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.dto.GenPersonasDTO;

/**
 * @author BS2
 *
 */
public interface ClienteService {

	/**
	 * Busca la informacion de los clientes a traves de un tipo de documento
	 * 
	 * @param PersonaId
	 * @return
	 */
	public GenPersonasDTO buscarCliente(GenPersonaIdRequest personaId);

	public List<ClienteContratosResponseDTO> obtenerContratosPorCliente(GenPersonaIdRequest personaId);

	public ClienteDatosResponseDTO obtenerClientesPersId(GenPersonaIdRequest personaId);
	
	

}
