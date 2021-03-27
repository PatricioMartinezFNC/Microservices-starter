package com.pdr.starter.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.dto.GenPersonasDTO;
import com.pdr.starter.cliente.exception.UserNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author Patricio Martínez
 *
 */
@Api( value = "Microservicio de clientes")
public interface ClienteController {

	/**
	 * Metodo que un cliente a partir del RUT
	 * 
	 * @return GenPersonaIdRequest
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Buscar Cliente", notes = "Retorna la persona solicitada a partir de los datos!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<GenPersonasDTO> buscarCliente(GenPersonaIdRequest personaId) throws UserNotFoundException;
	
	
	
	/**
	 * Metodo que retorna los contratos que estan asociados a un cliente
	 * 
	 * @return 
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Retorno de contratos asociados", notes = "Retorna contratos asociados a un cliente !")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<ClienteContratosResponseDTO>> buscarContratosCliente(GenPersonaIdRequest personaId) throws UserNotFoundException;
	
	
	
	/**
	 * Metodo que busca clientes por String (primer nombre, segundo nombre, nombre completo, etc.)
	 * 
	 * @return 
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Retorno clientes asociados a la palabra", notes = "Retorno clientes asociados a la palabra !")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<ClienteDatosResponseDTO> buscarClientesPorString(GenPersonaIdRequest personaId) throws UserNotFoundException;
	
	
	
}
