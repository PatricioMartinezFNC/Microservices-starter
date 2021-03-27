package com.pdr.starter.cliente.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.dto.GenPersonasDTO;
import com.pdr.starter.cliente.model.GenPersonasIdModel;
import com.pdr.starter.cliente.model.GenPersonasModel;
import com.pdr.starter.cliente.repository.GenPersonaRepository;
import com.pdr.starter.cliente.repository.sp.AtcparGetListContRolRepository;
import com.pdr.starter.cliente.repository.sp.GenLstDatosPersonaRepository;
import com.pdr.starter.cliente.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private GenPersonaRepository personaRepository;

	@Autowired
	private AtcparGetListContRolRepository atcparGetListContRolRepository;
	
	@Autowired
	private GenLstDatosPersonaRepository genLstDatosPersonaRepository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public GenPersonasDTO buscarCliente(GenPersonaIdRequest cliente) {

		log.info("[buscarCliente]:: inicio del metodo");
		
		GenPersonasDTO dto;
		GenPersonasIdModel model = new GenPersonasIdModel();
		model.setPersTipoId(cliente.getPersTipoId());
		model.setPersId(cliente.getPersId());
		Optional<GenPersonasModel> optionalPersona = personaRepository.findById(model);
		dto = optionalPersona.isPresent() ? mapper.map(optionalPersona.get(), GenPersonasDTO.class) : null;
		
		log.info("[buscarCliente]:: fin del metodo");
		return dto;	
	}
	
	
	@Override
	public List<ClienteContratosResponseDTO> obtenerContratosPorCliente(GenPersonaIdRequest personaId){
		
		log.info("[obtenerContratosPorCliente]:: inicio del metodo");
		
		Map<String, Object> result = atcparGetListContRolRepository.getListContratos(personaId);
		@SuppressWarnings("unchecked")
		List<ClienteContratosResponseDTO> listaContratos = (List<ClienteContratosResponseDTO>) result.get("result");
	
		log.info("[obtenerContratosPorCliente]:: fin del metodo"); 
		return listaContratos;
	}


	@Override
	public ClienteDatosResponseDTO obtenerClientesPersId(GenPersonaIdRequest personaId) {

		log.info("[obtenerClientesPersId]:: inicio del metodo");
		
		Map<String, Object> result = genLstDatosPersonaRepository.getDatosCliente(personaId);

		@SuppressWarnings("unchecked")
		List<ClienteDatosResponseDTO> listaClientes =  (List<ClienteDatosResponseDTO>) result.get("result");
	
		log.info("[obtenerClientesPersId]:: fin del metodo"); 
		return listaClientes.size() > 0 ? listaClientes.get(0): null;
	}
	

	
}
