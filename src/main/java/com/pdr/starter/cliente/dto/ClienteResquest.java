package com.pdr.starter.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Setter
@Getter
@ToString
public class ClienteResquest {
	
	private String tipoBusqueda;
	
	private String busqueda;

}
