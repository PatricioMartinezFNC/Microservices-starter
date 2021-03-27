package com.pdr.starter.cliente.controller.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pdr.starter.cliente.dto.ClienteContratosResponseDTO;
import com.pdr.starter.cliente.dto.ClienteDatosResponseDTO;
import com.pdr.starter.cliente.dto.GenPersonasDTO;
import com.pdr.starter.cliente.model.GenPersonasIdModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClienteMock {

	public static GenPersonasDTO mockPersona() {
		log.info("[mockPersona]:: creamos un mock de dto.setPersona");
		GenPersonasDTO dto = new GenPersonasDTO();
		GenPersonasIdModel id = new GenPersonasIdModel();
		id.setPersId("7296795");
		id.setPersTipoId("RUT");
		dto.setId(id);
		dto.setPersApeMat("SANHUESA");
		dto.setPersDigVer(" K");
		dto.setPersApePat(" SANHUEZA");
		dto.setPersApeMat(" NECOCHEA");
		dto.setPersNombres(" VERONICA EDITH");
		dto.setPersRazonSocial(" null");
		dto.setPersNomFantasia(" null");
		dto.setPersNivelEduc(" null");
		dto.setPersFecNac(null);
		dto.setPersFecDefun(null);
		dto.setPersEdadDefun(" null");
		dto.setPersEstCivil(" null");
		dto.setPersNaci(" CHILENO");
		dto.setPersSexo(" F");
		dto.setPersTipo(" NAT");
		dto.setPersGiro(" null");
		dto.setPersUserMod(" MIGRACION");
		dto.setPersFecMod(new Date());
		log.info("[mockPersona]:: fin");
		log.debug("[mockPersona]:: return-->" + dto.toString());
		return dto;
	}
	
	public static List<ClienteContratosResponseDTO> mockContratosClientes(){
		
		log.info("[mockPersona]:: creamos un mock de ClienteContratosResponseDTO");
		List<ClienteContratosResponseDTO> result = new ArrayList<ClienteContratosResponseDTO>();
		ClienteContratosResponseDTO dto = new ClienteContratosResponseDTO();
		
		dto.setEmprCod("02");
		dto.setUnegCod("PCO");
		dto.setUnegEmprDesc("02-PCO");
		dto.setContVtopNumFmt("s-11479");
		dto.setTipoProducto("Sepultura");
		dto.setContVtopFech(new Date(12584));
		dto.setContVtopFechFmt("30/05/2011");
		dto.setContVtopEsta("ACTIVO");
		dto.setContVtopEstaDesc("Activo");
		dto.setConVtopNece("NI");
		dto.setConVtopNeceDesc("Necesidad Inmediata");
		dto.setRol("Titular");
		dto.setIndEstaDeudaDesc("Con Deuda Credito - Sin Deuda Mantencion");
		dto.setPersIdCompFmt("8.107.621-9");
		dto.setPersNomCompFmt("Gladys Del Rosario Mondaca Sotelo ***");
		dto.setUbicFmt("B05-338-2 1B04");
		dto.setPersTipoIdComp("RUT");
		dto.setPersIdComp(new BigDecimal(8107621));
		dto.setVtopCod(new BigDecimal(79154));
		dto.setVtopCodCont(new BigDecimal(79154));
		dto.setPesoRol(new BigDecimal(3));
		dto.setTipoDocto("VTA_OPER");
		dto.setNumDocto(new BigDecimal(79154));
		dto.setLnngCod("SEPULTURA");
		dto.setVtopIndNif("");
		dto.setNumOpe(new BigDecimal(79154));
		result.add(dto);
		
		dto = new ClienteContratosResponseDTO();
		dto.setEmprCod("02");
		dto.setUnegCod("PCO");
		dto.setUnegEmprDesc("02-PCO");
		dto.setContVtopNumFmt("s-11479");
		dto.setTipoProducto("Sepultura");
		dto.setContVtopFech(new Date(12584));
		dto.setContVtopFechFmt("30/05/2011");
		dto.setContVtopEsta("ACTIVO");
		dto.setContVtopEstaDesc("Activo");
		dto.setConVtopNece("NI");
		dto.setConVtopNeceDesc("Necesidad Inmediata");
		dto.setRol("Titular 2");
		dto.setIndEstaDeudaDesc("Con Deuda Credito - Sin Deuda Mantencion");
		dto.setPersIdCompFmt("8.107.621-9");
		dto.setPersNomCompFmt("Gladys Del Rosario Mondaca Sotelo ***");
		dto.setUbicFmt("B05-338-2 1B04");
		dto.setPersTipoIdComp("RUT");
		dto.setPersIdComp(new BigDecimal(8107621));
		dto.setVtopCod(new BigDecimal(79154));
		dto.setVtopCodCont(new BigDecimal(79154));
		dto.setPesoRol(new BigDecimal(3));
		dto.setTipoDocto("VTA_OPER");
		dto.setNumDocto(new BigDecimal(79154));
		dto.setLnngCod("SEPULTURA");
		dto.setVtopIndNif("");
		dto.setNumOpe(new BigDecimal(79154));
		result.add(dto);
		
		return result;
		
	}
	
	
	
	
	public static ClienteDatosResponseDTO mockGenPersonaCliente() {
		
		log.info("[mockGenPersonaCliente]:: creamos un mock para el DTO ClienteDatosResponseDTO");
		ClienteDatosResponseDTO dto = new ClienteDatosResponseDTO();
		dto.setPersTipo("NAT");
		dto.setPersTipoId("RUT");
		dto.setPersTipoIdDesc("rut");
		dto.setPersId(new BigDecimal(19004920));
		dto.setPersDigVer("k");
		dto.setPersIdFmt("19004920-k");
		dto.setPersApePat("");
		dto.setPersApeMat("");
		dto.setPersNombres("McLovin");
		dto.setPersRazonSocial("");
		dto.setPersNomFantasia("");
		dto.setPersNomFMT("McLovin  ****");
		dto.setPersNivelEduc("");
		dto.setPersFecNac(new Date(45645678));
		dto.setPersFecDefun(new Date(1214563));
		dto.setPersEdadDefun("40");
		dto.setEdadFmt("40 años");
		dto.setPersEstCivil("SOLTERO");
		dto.setPersEstCivilFmt("soltero");
		dto.setPersNaci("EEUU");
		dto.setPersSexo("SIEMPRE");
		dto.setPersMod("NO");
		dto.setPersGiro("");
		dto.setPersModFall("NO");
		dto.setSexoDesc("Masculino");
		dto.setPersFecNacFmt("06/03/1981");
		dto.setPersFecDefunFmt("02/09/2011");
		log.info("[mockGenPersonaCliente]:: fin");
		return dto;
		
		
	}

	

}
