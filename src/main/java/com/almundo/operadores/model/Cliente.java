package com.almundo.operadores.model;

/**
 * @author https://github.com/efat07 - Eyner Arias - efat07@gmail.com
 *
 */

public class Cliente {

	private Integer clienteId = null;

	//Se puede añadir más información del cliente de la llamada, por ahora se trabajará con el Id 

	public Cliente() {
	}
	
	public Cliente(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
