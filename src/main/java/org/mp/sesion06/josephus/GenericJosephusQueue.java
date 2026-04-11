/**
 * Implementación genérica del problema de Josephus utilizando una cola.
 * Se eliminan elementos cada k pasos hasta que la cola esté vacía.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion06.josephus;

import org.mp.sesion05.colas.LinkedListQueue;
import org.mp.sesion05.colas.Queue;

public class GenericJosephusQueue<T> {

	private int k; // Número de pasos antes de eliminar a alguien
	private int n; // Número total de elementos
	private Queue<T> elementos; // Cola que representa el círculo de personas

	/**
	 * Constructor de la clase.
	 *
	 * @param k Número de pasos para eliminar a una persona
	 * @param n Cantidad total de personas
	 * @param elementos Arreglo con los elementos a insertar en la cola
	 */
	public GenericJosephusQueue(int k, int n, T[] elementos) {
		this.k = k;
		this.n = n;
		this.elementos = new LinkedListQueue<>();
		if (elementos != null) {
			for (int i = 0; i < elementos.length; i++) {
				this.elementos.enqueue(elementos[i]);
			}
		}
	}

	/**
	 * Devuelve el orden en el que los elementos son eliminados del "círculo".
	 *
	 * @return Cadena con el orden de eliminación
	 */
	public String ordenEliminar() {
		if (n == 0) {
			throw new RuntimeException("No hay ninguna persona");
		}
		if (n == 1)
			return "Solo hay una persona";

		String s = "Orden de eliminación:\n";
		int cont = 0;

		// Repetir hasta que la cola esté vacía
		while (this.elementos.getSize() != 0) {
			T aux = elementos.dequeue(); // Se saca el primero
			cont++;
			if (cont % k == 0) {
				// Si el contador es múltiplo de k, se elimina
				s += "Debe morir " + aux + "\n";
			} else {
				// Si no, se vuelve a encolar
				this.elementos.enqueue(aux);
			}
		}
		return s;
	}

	/**
	 * Representación textual del problema de Josephus con la cola inicial.
	 *
	 * @return Cadena que describe los parámetros y el contenido de la cola
	 */
	public String toString() {
		return "Problema de Josephus: k=" + this.k + ", n=" + this.n + "\n" + "Cola: " + this.elementos.toString();
	}
}
