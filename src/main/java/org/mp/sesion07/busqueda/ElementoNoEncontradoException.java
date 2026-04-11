/**
 * Excepción personalizada que se lanza cuando un elemento no se encuentra
 * durante un proceso de búsqueda.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.busqueda;

public class ElementoNoEncontradoException extends Exception {

	/**
	 * Constructor que recibe un mensaje descriptivo del error.
	 *
	 * @param mensaje Mensaje que describe la causa de la excepción
	 */
	public ElementoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
