package com.pdr.starter.cliente.model;

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
@Table(name = "CBZ_ARBOL_GESTION_VALOR", schema = "CBZPAR")
public class CbzArbolGestionValorModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idArbolValor;
	private String arbvalDescripcion;
	private Set<CbzArbolGestionModel> cbzArbolGestions = new HashSet<CbzArbolGestionModel>(0);

	public CbzArbolGestionValorModel() {
	}

	public CbzArbolGestionValorModel(int idArbolValor) {
		this.idArbolValor = idArbolValor;
	}

	public CbzArbolGestionValorModel(int idArbolValor, String arbvalDescripcion, Set<CbzArbolGestionModel> cbzArbolGestions) {
		this.idArbolValor = idArbolValor;
		this.arbvalDescripcion = arbvalDescripcion;
		this.cbzArbolGestions = cbzArbolGestions;
	}

	@Id

	@Column(name = "ID_ARBOL_VALOR", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdArbolValor() {
		return this.idArbolValor;
	}

	public void setIdArbolValor(int idArbolValor) {
		this.idArbolValor = idArbolValor;
	}

	@Column(name = "ARBVAL_DESCRIPCION", length = 100)
	public String getArbvalDescripcion() {
		return this.arbvalDescripcion;
	}

	public void setArbvalDescripcion(String arbvalDescripcion) {
		this.arbvalDescripcion = arbvalDescripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzArbolGestionValor")
	public Set<CbzArbolGestionModel> getCbzArbolGestions() {
		return this.cbzArbolGestions;
	}

	public void setCbzArbolGestions(Set<CbzArbolGestionModel> cbzArbolGestions) {
		this.cbzArbolGestions = cbzArbolGestions;
	}

}
