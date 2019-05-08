package com.almundo.operadores.model;

/**
 * @author https://github.com/efat07 - Eyner Arias - efat07@gmail.com
 *
 */

public class Llamada {

	private Integer llamadaId = null;
	private Cliente cliente = null;
	
	public Llamada() {
	}
	
	public Llamada(Integer llamadaId, Cliente cliente) {
		this.llamadaId = llamadaId;
		this.cliente = cliente;
	}
	
	public Integer getLlamadaId() {
		return llamadaId;
	}

	public void setLlamadaId(Integer llamadaId) {
		this.llamadaId = llamadaId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
