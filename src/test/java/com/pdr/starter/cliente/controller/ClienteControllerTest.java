package com.pdr.starter.cliente.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pdr.starter.cliente.controller.impl.ClienteControllerImpl;
import com.pdr.starter.cliente.controller.mock.ClienteMock;
import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.GenPersonaIdRequest;
import com.pdr.starter.cliente.dto.GenPersonasDTO;
import com.pdr.starter.cliente.exception.UserNotFoundException;
import com.pdr.starter.cliente.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Patricio Martínez
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class ClienteControllerTest {

	// Buscar Cliente Test y datos desactualizados
	public static final String DATA_ID = "8714763";
	public static final String DATA_TIPO_ID = "RUT";


	@InjectMocks
	private ClienteControllerImpl clienteController;

	@Mock
	private ClienteService clienteService;
	
	@Test
    public void buscarClienteTest() throws UserNotFoundException 
    {
		log.info("[buscarClienteTest]:: inicio del metodo");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        GenPersonaIdRequest pers = new GenPersonaIdRequest();
        pers.setPersId(DATA_ID);
        pers.setPersTipoId(DATA_TIPO_ID);
        
        when(clienteService.buscarCliente(pers)).thenReturn(ClienteMock.mockPersona());
        ResponseEntity<GenPersonasDTO> responseEntity = clienteController.buscarCliente(pers);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        try { 
        	when(clienteService.buscarCliente(pers)).thenReturn(null);
		    clienteController.buscarCliente(pers);
        } catch (UserNotFoundException e) {
        	log.error("[buscarClienteTest][UserNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
        
    }
	
	@Test
	public void buscarContratosClienteTest() throws UserNotFoundException {
		
		log.info("[buscarContratosClienteTest]:: inicio del metodo");
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		GenPersonaIdRequest pers = new GenPersonaIdRequest();
		pers.setPersId(DATA_ID);
		pers.setPersTipoId(DATA_TIPO_ID);
		
		when(clienteService.obtenerContratosPorCliente(pers)).thenReturn(ClienteMock.mockContratosClientes());
		ResponseEntity<List<ClienteContratosResponseDTO>> responseEntity = clienteController.buscarContratosCliente(pers);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		try { 
        	when(clienteService.obtenerContratosPorCliente(pers)).thenReturn(null);
		    clienteController.buscarContratosCliente(pers);
        } catch (UserNotFoundException e) {
        	log.error("[buscarContratosClienteTest][UserNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
		
	}
	
	
	@Test
	public void buscarContratosClientePorStringTest() throws UserNotFoundException {
		
		log.info("[buscarContratosClientePorStringTest]:: inicio del metodo");
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		GenPersonaIdRequest pers = new GenPersonaIdRequest();
		pers.setPersId(DATA_ID);
		pers.setPersTipoId(DATA_TIPO_ID);
		
		when(clienteService.obtenerClientesPersId(pers)).thenReturn(ClienteMock.mockGenPersonaCliente());
		ResponseEntity<ClienteDatosResponseDTO> responseEntity = clienteController.buscarClientesPorString(pers);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		try { 
        	when(clienteService.obtenerClientesPersId(pers)).thenReturn(null);
		    clienteController.buscarClientesPorString(pers);
        } catch (UserNotFoundException e) {
        	log.error("[buscarContratosClientePorStringTest][UserNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
		
	}
	
	

}
