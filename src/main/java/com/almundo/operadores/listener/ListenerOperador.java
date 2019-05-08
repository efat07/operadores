package com.almundo.operadores.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.almundo.operadores.constantes.Constante;
import com.almundo.operadores.model.Llamada;
import com.almundo.operadores.model.Operador;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author https://github.com/efat07 - Eyner Arias - efat07@gmail.com
 *
 */

@Component
public class ListenerOperador {
	
	ObjectMapper mapper = new ObjectMapper();
	Llamada llamada = null;
	
	@JmsListener(destination = Constante.nombreColaOperador, containerFactory = Constante.nombreFactory)
	public void onMessage( final Message msgLlamadaIn ) throws JMSException {
		
		try {
			System.out.println("Llamada Recibida por el Operador: ");
			TextMessage msgLlamada = (TextMessage) msgLlamadaIn;
			System.out.println( msgLlamada.getText() );
			
			llamada = mapper.readValue(msgLlamada.getText(), Llamada.class);
			Operador operador = Operador.getInstanciaSingleton(1, llamada);
			operador.correrTiempo();
			System.out.println("Pasaron " + operador.verificaDisponibilidadSegundo() + " segundos");
			System.out.println("________________________________________________");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
