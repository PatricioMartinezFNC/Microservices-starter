package com.pdr.starter.cliente.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pdr.starter.cliente.controller.ClienteController;
import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.dto.GenPersonasDTO;
import com.pdr.starter.cliente.exception.UserNotFoundException;
import com.pdr.starter.cliente.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/buscar-cliente")
	public ResponseEntity<GenPersonasDTO> buscarCliente(@Valid @RequestBody GenPersonaIdRequest cliente)
			throws UserNotFoundException {
		log.info("BuscarCliente::Inicio del metodo");
		ResponseEntity<GenPersonasDTO> response = null;

		GenPersonasDTO dto = clienteService.buscarCliente(cliente);

		if (dto != null)
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			throw UserNotFoundException.createWith(cliente.getPersId());

		log.info("BuscarCliente::fin del metodo");
		return response;
	}
	
	
	@PostMapping("/buscar-contratos-cliente")
	public ResponseEntity<List<ClienteContratosResponseDTO>> buscarContratosCliente(@Valid @RequestBody GenPersonaIdRequest personaId) 
			throws UserNotFoundException{
		
		
		log.info("BuscarContratosCliente::Inicio del metodo");
		
		ResponseEntity<List<ClienteContratosResponseDTO>> response = null;
		List<ClienteContratosResponseDTO> dto = clienteService.obtenerContratosPorCliente(personaId);
		
		
		if (dto != null)
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			throw UserNotFoundException.createWith(personaId.getPersId());

		log.info("BuscarContratosCliente::Fin del metodo");
		return response;
	}
	
	
	@PostMapping("/buscar-info-cliente")
	public ResponseEntity<ClienteDatosResponseDTO> buscarClientesPorString(@Valid @RequestBody GenPersonaIdRequest personaId) 
			throws UserNotFoundException{

		
		log.info("buscarClientesPorString::Inicio del metodo");
	
		ResponseEntity<ClienteDatosResponseDTO> response = null;
		ClienteDatosResponseDTO dto = clienteService.obtenerClientesPersId(personaId);

		if (dto != null)
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			throw UserNotFoundException.createWith(personaId.getPersId());
		
		
		log.info("buscarClientesPorString::Fin del metodo");
		return response;
	}
	
}
