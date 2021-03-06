package com.pdr.starter.cliente.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Generated by BS2
 */
@Entity
@Table(name = "CBZ_ARBOL_GESTION_VERSION", schema = "CBZPAR")
public class CbzArbolGestionVersionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idArbGestVersion;
	private String arbgestVersion;
	private BigDecimal arbgestVerEliminado;
	private Set<CbzArbolGestionModel> cbzArbolGestions = new HashSet<CbzArbolGestionModel>(0);

	public CbzArbolGestionVersionModel() {
	}

	public CbzArbolGestionVersionModel(BigDecimal idArbGestVersion) {
		this.idArbGestVersion = idArbGestVersion;
	}

	public CbzArbolGestionVersionModel(BigDecimal idArbGestVersion, String arbgestVersion, BigDecimal arbgestVerEliminado,
			Set<CbzArbolGestionModel> cbzArbolGestions) {
		this.idArbGestVersion = idArbGestVersion;
		this.arbgestVersion = arbgestVersion;
		this.arbgestVerEliminado = arbgestVerEliminado;
		this.cbzArbolGestions = cbzArbolGestions;
	}

	@Id

	@Column(name = "ID_ARB_GEST_VERSION", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getIdArbGestVersion() {
		return this.idArbGestVersion;
	}

	public void setIdArbGestVersion(BigDecimal idArbGestVersion) {
		this.idArbGestVersion = idArbGestVersion;
	}

	@Column(name = "ARBGEST_VERSION", length = 10)
	public String getArbgestVersion() {
		return this.arbgestVersion;
	}

	public void setArbgestVersion(String arbgestVersion) {
		this.arbgestVersion = arbgestVersion;
	}

	@Column(name = "ARBGEST_VER_ELIMINADO", precision = 22, scale = 0)
	public BigDecimal getArbgestVerEliminado() {
		return this.arbgestVerEliminado;
	}

	public void setArbgestVerEliminado(BigDecimal arbgestVerEliminado) {
		this.arbgestVerEliminado = arbgestVerEliminado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzArbolGestionVersion")
	public Set<CbzArbolGestionModel> getCbzArbolGestions() {
		return this.cbzArbolGestions;
	}

	public void setCbzArbolGestions(Set<CbzArbolGestionModel> cbzArbolGestions) {
		this.cbzArbolGestions = cbzArbolGestions;
	}

}
