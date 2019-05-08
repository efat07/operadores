package com.almundo.operadores.model;

import java.util.concurrent.TimeUnit;

/**
 * @author https://github.com/efat07 - Eyner Arias - efat07@gmail.com
 *
 */

public class Operador {

	private Integer operadorId = null;
	private Long tiempoLlamada = 0L;
	private Long tiempoInicio = 0L;
	private Long tiempoFinal = 0L;
	private Llamada llamada = null;
	private static Operador operador;
	
	private Operador() {
	}
	
	private Operador(Integer operadorId, Llamada llamada) {
		this.operadorId = operadorId;
		this.llamada = llamada;
	}
	
	public static Operador getInstanciaSingleton() {
		if(operador == null) {
			operador = new Operador();
		}
		return operador;
	}
	
	public static Operador getInstanciaSingleton(Integer operadorId, Llamada llamada) {
		if(operador == null) {
			operador = new Operador(operadorId,llamada);
		}
		return operador;
	}
	
	public void correrTiempo() {
		try {
			tiempoInicio = System.nanoTime();
			tiempoFinal  = 0L;
			tiempoLlamada = getNumeroAleatorioEntreDosNumeros(5,10);
			TimeUnit.SECONDS.sleep(tiempoLlamada);
			tiempoFinal = System.nanoTime();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int verificaDisponibilidadSegundo() {
		long output = tiempoFinal - tiempoInicio;
		return (int) ((output / 1000000)/1000);
	}
	
	private long getNumeroAleatorioEntreDosNumeros(int min, int max) {
		max=(max)+1;
        long resultado = ((long)(Math.random()*(max-min))+min);
		return resultado;
	}

	public Integer getOperadorId() {
		return operadorId;
	}
	public void setOperadorId(Integer operadorId) {
		this.operadorId = operadorId;
	}
	public Llamada getLlamada() {
		return llamada;
	}
	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public Long getTiempoLlamada() {
		return tiempoLlamada;
	}

	public void setTiempoLlamada(Long tiempoLlamada) {
		this.tiempoLlamada = tiempoLlamada;
	}
	
	public Long getTiempoInicio() {
		return tiempoInicio;
	}
	
	public void setTiempoInicio(Long tiempoInicio) {
		this.tiempoInicio = tiempoInicio;
	}
	public Long getTiempoFinal() {
		return tiempoFinal;
	}
	
	public void setTiempoFinal(Long tiempoFinal) {
		this.tiempoFinal = tiempoFinal;
	}
}
