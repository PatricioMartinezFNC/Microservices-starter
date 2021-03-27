package com.pdr.starter.cliente.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ClienteDatosResponseDTO {
	
	private String persTipo;
	private String persTipoId;
	private String persTipoIdDesc;
	private BigDecimal persId;
	private String persDigVer;
	private String persIdFmt;
	private String persApePat;
	private String persApeMat;
	private String persNombres;
	private String persRazonSocial;
	private String persNomFantasia;
	private String persNomFMT;
	private String persNivelEduc;
	private Date persFecNac;
	private Date persFecDefun;
	private String persEdadDefun;
	private String edadFmt;
	private String persEstCivil;
	private String persEstCivilFmt;
	private String persNaci;
	private String persSexo;
	private String persMod;
	private String persGiro;
	private String persModFall;
	private String sexoDesc;
	private String persFecNacFmt;
	private String persFecDefunFmt;


	public ClienteDatosResponseDTO() {
		super();
		
	}
	
	
	
}
