package com.pdr.starter.cliente.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Generated by BS2
 */
@Entity
@Table(name = "CBZ_RESULTADO_ARBOL_GESTION", schema = "CBZPAR")
public class CbzResultadoArbolGestionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idResultadoArbolGest;
	private CbzGestionCobranzaHistModel cbzGestionCobranzaHist;
	private CbzArbolGestionModel cbzArbolGestion;
	private String resRespuesta;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_RESULTADO_ARBOL_GESTION")
	@SequenceGenerator(name = "ID_SEQUENCE_RESULTADO_ARBOL_GESTION", allocationSize = 1, sequenceName = "SEQ_RESULTADO_ARBOL_GESTION", schema = "CBZPAR")
	@Column(name = "ID_RESULTADO_ARBOL_GEST", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdResultadoArbolGest() {
		return this.idResultadoArbolGest;
	}

	public void setIdResultadoArbolGest(BigDecimal idResultadoArbolGest) {
		this.idResultadoArbolGest = idResultadoArbolGest;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GEST_COBRANZA_HIST", nullable = false)
	public CbzGestionCobranzaHistModel getCbzGestionCobranzaHist() {
		return this.cbzGestionCobranzaHist;
	}

	public void setCbzGestionCobranzaHist(CbzGestionCobranzaHistModel cbzGestionCobranzaHist) {
		this.cbzGestionCobranzaHist = cbzGestionCobranzaHist;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARBOL_GESTION_ID_ARBOL_GESTION", nullable = false)
	public CbzArbolGestionModel getCbzArbolGestion() {
		return this.cbzArbolGestion;
	}

	public void setCbzArbolGestion(CbzArbolGestionModel cbzArbolGestion) {
		this.cbzArbolGestion = cbzArbolGestion;
	}

	@Column(name = "RES_RESPUESTA", length = 500)
	public String getResRespuesta() {
		return this.resRespuesta;
	}

	public void setResRespuesta(String resRespuesta) {
		this.resRespuesta = resRespuesta;
	}
}
