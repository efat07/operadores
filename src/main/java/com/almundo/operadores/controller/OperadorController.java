package com.almundo.operadores.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almundo.operadores.model.Operador;
import com.almundo.operadores.payload.OperadorResponse;

/**
 * @author https://github.com/efat07 - Eyner Arias - efat07@gmail.com
 *
 */

@RestController
@CrossOrigin(origins = "*")
public class OperadorController {

    @GetMapping("/validarDispOperador")
    public ResponseEntity<?> validarDisponibilidad() {
        int segundosDemora = 0;
    	Operador operador = Operador.getInstanciaSingleton();
    	segundosDemora = operador.verificaDisponibilidadSegundo();
    	int tiempoLlamada = Integer.parseInt(operador.getTiempoLlamada().toString());
        if(segundosDemora >= tiempoLlamada) {
        	segundosDemora = 0;
        	operador.setTiempoInicio(0L);
        	operador.setTiempoFinal(0L);
        }else {
        	segundosDemora = tiempoLlamada - segundosDemora;
        	segundosDemora = Math.abs(segundosDemora);
        }
    	OperadorResponse operadorResponse = new OperadorResponse();
    	if(operador.getLlamada() != null) {
    		operadorResponse.setIdLlamada(operador.getLlamada().getLlamadaId());
    	}
    	operadorResponse.setDuracionAtendiendo(segundosDemora);
    	operadorResponse.setCantidadEnCola(0);
    	return ResponseEntity.ok(operadorResponse);
    }
}