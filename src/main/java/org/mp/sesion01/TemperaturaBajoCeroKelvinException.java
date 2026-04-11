/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01;

/**
 * La excepción `TemperaturaBajoCeroKelvinException` se lanza cuando se intenta convertir
 * una temperatura por debajo del cero absoluto.
 */

public class TemperaturaBajoCeroKelvinException extends Exception {
  
	/**
     * Construye una nueva excepción con el mensaje especificado.
     *
     */
 
    public TemperaturaBajoCeroKelvinException(String string) {
        super("¡La temperatura no puede estar por debajo de 0 K!");
    }
}