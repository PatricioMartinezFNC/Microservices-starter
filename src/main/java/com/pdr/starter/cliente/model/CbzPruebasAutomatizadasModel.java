package com.pdr.starter.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * generated by BS2
 */
@Entity
@Table(name = "CBZ_PRUEBAS_AUTOMATIZADAS", schema = "CBZPAR")
public class CbzPruebasAutomatizadasModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pruebaIdHistoria;
	private String pruebaTituloHistoria;
	private String pruebaUsuario;
	private String pruebaClave;
	private String pruebaRutCliente;
	private String pruebaSerieFolioContrato;
	private String pruebaDescripcion;
	private String pruebaModulo;

	public CbzPruebasAutomatizadasModel() {
	}

	public CbzPruebasAutomatizadasModel(String pruebaIdHistoria) {
		this.pruebaIdHistoria = pruebaIdHistoria;
	}

	public CbzPruebasAutomatizadasModel(String pruebaIdHistoria, String pruebaTituloHistoria, String pruebaUsuario,
			String pruebaClave, String pruebaRutCliente, String pruebaSerieFolioContrato, String pruebaDescripcion,
			String pruebaModulo) {
		this.pruebaIdHistoria = pruebaIdHistoria;
		this.pruebaTituloHistoria = pruebaTituloHistoria;
		this.pruebaUsuario = pruebaUsuario;
		this.pruebaClave = pruebaClave;
		this.pruebaRutCliente = pruebaRutCliente;
		this.pruebaSerieFolioContrato = pruebaSerieFolioContrato;
		this.pruebaDescripcion = pruebaDescripcion;
		this.pruebaModulo = pruebaModulo;
	}

	@Id

	@Column(name = "PRUEBA_ID_HISTORIA", unique = true, nullable = false, precision = 8, scale = 0)
	public String getPruebaIdHistoria() {
		return this.pruebaIdHistoria;
	}

	public void setPruebaIdHistoria(String pruebaIdHistoria) {
		this.pruebaIdHistoria = pruebaIdHistoria;
	}

	@Column(name = "PRUEBA_TITULO_HISTORIA", length = 100)
	public String getPruebaTituloHistoria() {
		return this.pruebaTituloHistoria;
	}

	public void setPruebaTituloHistoria(String pruebaTituloHistoria) {
		this.pruebaTituloHistoria = pruebaTituloHistoria;
	}

	@Column(name = "PRUEBA_USUARIO", length = 100)
	public String getPruebaUsuario() {
		return this.pruebaUsuario;
	}

	public void setPruebaUsuario(String pruebaUsuario) {
		this.pruebaUsuario = pruebaUsuario;
	}

	@Column(name = "PRUEBA_CLAVE", length = 100)
	public String getPruebaClave() {
		return this.pruebaClave;
	}

	public void setPruebaClave(String pruebaClave) {
		this.pruebaClave = pruebaClave;
	}

	@Column(name = "PRUEBA_RUT_CLIENTE", length = 100)
	public String getPruebaRutCliente() {
		return this.pruebaRutCliente;
	}

	public void setPruebaRutCliente(String pruebaRutCliente) {
		this.pruebaRutCliente = pruebaRutCliente;
	}

	@Column(name = "PRUEBA_SERIE_FOLIO_CONTRATO", length = 100)
	public String getPruebaSerieFolioContrato() {
		return this.pruebaSerieFolioContrato;
	}

	public void setPruebaSerieFolioContrato(String pruebaSerieFolioContrato) {
		this.pruebaSerieFolioContrato = pruebaSerieFolioContrato;
	}

	@Column(name = "PRUEBA_DESCRIPCION", length = 100)
	public String getPruebaDescripcion() {
		return this.pruebaDescripcion;
	}

	public void setPruebaDescripcion(String pruebaDescripcion) {
		this.pruebaDescripcion = pruebaDescripcion;
	}

	@Column(name = "PRUEBA_MODULO", length = 100)
	public String getPruebaModulo() {
		return this.pruebaModulo;
	}

	public void setPruebaModulo(String pruebaModulo) {
		this.pruebaModulo = pruebaModulo;
	}

}
