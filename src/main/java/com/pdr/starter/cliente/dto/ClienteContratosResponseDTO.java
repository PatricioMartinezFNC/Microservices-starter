package com.pdr.starter.cliente.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ClienteContratosResponseDTO {

	private String emprCod;
	private String unegCod;
	private String unegEmprDesc;
	private String contVtopNumFmt;
	private String tipoProducto;
	private Date contVtopFech;
	private String contVtopFechFmt;
	private String contVtopEsta;
	private String contVtopEstaDesc;
	private String conVtopNece;
	private String conVtopNeceDesc;
	private String rol;
	private String indEstaDeudaDesc;
	private String persIdCompFmt;
	private String persNomCompFmt;
	private String ubicFmt;
	private String persTipoIdComp;
	private BigDecimal persIdComp;
	private BigDecimal vtopCod;
	private BigDecimal vtopCodCont;
	private BigDecimal pesoRol;
	private String tipoDocto;
	private BigDecimal numDocto;
	private String lnngCod;
	private String vtopIndNif;
	private BigDecimal numOpe;
	
}
