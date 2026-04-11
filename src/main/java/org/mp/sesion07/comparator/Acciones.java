/**
 * Clase contenedora que mantiene una lista de objetos {@link Accion}.
 * Permite agregar nuevas acciones y recuperar la lista completa.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.comparator;

import java.util.ArrayList;
import java.util.List;

public class Acciones {

	private List<Accion> acciones; // Lista de acciones

	/**
	 * Constructor que inicializa la lista de acciones vacía.
	 */
	public Acciones() {
		super();
		acciones = new ArrayList<Accion>();
	}

	/**
	 * Agrega una acción a la lista.
	 *
	 * @param accion Objeto Accion a añadir
	 */
	public void add(Accion accion) {
		acciones.add(accion);
	}

	/**
	 * Retorna la lista completa de acciones almacenadas.
	 *
	 * @return Lista de objetos Accion
	 */
	public List<Accion> getAcciones() {
		return acciones;
	}
}
