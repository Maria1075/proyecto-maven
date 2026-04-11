/**
 * Clase que representa una lista circular basada en una lista enlazada.
 * Permite agregar, eliminar y acceder a elementos de forma circular.
 * 
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */
package org.mp.sesion06.circularlist;

import java.util.Iterator;
import org.mp.sesion04.list.List;
import org.mp.sesion04.list.linkedlist.LinkedList;

public class CircularList<T> {
	private List<T> list; // Lista interna que almacena los elementos
	private int current;  // Número actual de elementos en la lista

	/**
	 * Constructor que inicializa la lista como vacía y el contador en 0.
	 */
	public CircularList() {
		this.list = new LinkedList<>();
		this.current = 0;
	}

	/**
	 * Agrega un elemento al final de la lista circular.
	 * 
	 * @param element Elemento a agregar
	 */
	public void addElement(T element) {
		this.list.add(element);
		this.current++;
	}

	/**
	 * Elimina el elemento especificado de la lista.
	 * 
	 * @param element Elemento a eliminar
	 * @return true si se eliminó, false si no se encontró
	 */
	public boolean removeElement(T element) {
		int index = this.list.indexOf(element); // Es obligatorio el equals para poder usar indexOf
		if (index == -1)
			return false;
		this.list.remove(index);
		this.current--;
		return true;
	}

	/**
	 * Devuelve el elemento en la posición indicada, considerando la circularidad.
	 * 
	 * @param index Índice solicitado
	 * @return Elemento en la posición (index % tamaño)
	 */
	public T getElement(int index) {
		return this.list.get(wrapIndex(index)); // el wrap es un array circular si tiene tamaño 4 si el usuario pide
												// meter en la posición 5 el elemento se mete en la posicion 0
	}

	/**
	 * Obtiene el índice de un elemento dado en la lista.
	 * 
	 * @param element Elemento a buscar
	 * @return Índice del elemento, o -1 si no existe
	 */
	public int getIndex(T element) {
		return this.list.indexOf(element);
	}

	/**
	 * Verifica si la lista está vacía.
	 * 
	 * @return true si la lista no tiene elementos
	 */
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * Devuelve el tamaño actual de la lista.
	 * 
	 * @return Número de elementos en la lista
	 */
	public int getSize() {
		return this.list.size();
	}

	/**
	 * Retorna un iterador circular para recorrer la lista.
	 * 
	 * @return Un iterador que recorre hasta el número de elementos actuales
	 */
	public Iterator<T> iterator() {
		return new CircularIterator();
	}

	/**
	 * Método auxiliar que envuelve el índice dentro del rango de la lista.
	 * 
	 * @param index Índice potencialmente fuera de rango
	 * @return Índice ajustado dentro del rango [0, tamaño)
	 */
	private int wrapIndex(int index) {
		return index % this.list.size();
	}

	/**
	 * Clase interna que implementa un iterador para la lista circular.
	 */
	private class CircularIterator implements Iterator<T> {
		private int currentIndex;    // Posición actual del iterador
		private int iteratorIndex;   // No se utiliza en la implementación actual

		/**
		 * Constructor del iterador circular.
		 */
		public CircularIterator() {
			this.currentIndex = 0;
			this.iteratorIndex = 0;
		}

		/**
		 * Verifica si hay más elementos por iterar.
		 * 
		 * @return true si no se ha llegado al final
		 */
		@Override
		public boolean hasNext() {
			return currentIndex < current;
		}

		/**
		 * Retorna el siguiente elemento en la iteración.
		 * 
		 * @return Elemento actual y avanza el iterador
		 */
		@Override
		public T next() {
			T aux = getElement(currentIndex);
			currentIndex++;
			return aux;
		}
	}
}
