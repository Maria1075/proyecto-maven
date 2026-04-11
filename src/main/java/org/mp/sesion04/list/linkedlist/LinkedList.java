package org.mp.sesion04.list.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.mp.sesion04.list.AbstractList;
/**
 * {@code LinkedList<E>} es una implementación de la interfaz {@link org.mp.sesion04.list.List}
 * que utiliza una lista doblemente enlazada para almacenar los elementos. Esto permite
 * una inserción y eliminación eficientes de elementos en cualquier posición de la lista.
 * Hereda de la clase abstracta {@link AbstractList}, proporcionando implementaciones
 * específicas para las operaciones de lista basadas en una estructura enlazada.
 *
 * @param <E> El tipo de los elementos que contendrá esta lista.
 */
public class LinkedList<E> extends AbstractList<E> {
	private Node<E> head, tail;

	/**
	 * Crea una lista enlazada vacía.
	 */
	public LinkedList() {
	}

	/**
	 * Crea una lista enlazada e inicializa sus elementos a partir de los elementos de un array dado.
	 *
	 * @param objects El array de objetos cuyos elementos se añadirán a la nueva lista.
	 */
	public LinkedList(E[] objects) {
		super(objects);
	}

	/**
	 * Compara esta lista enlazada con otro objeto para determinar si son iguales.
	 * Dos listas enlazadas son iguales si tienen el mismo tamaño y contienen los mismos
	 * elementos en el mismo orden.
	 *
	 * @param obj El objeto con el que se va a comparar esta lista.
	 * @return {@code true} si el objeto especificado es igual a esta lista, {@code false} en caso contrario.
	 */
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		LinkedList<E> otro = (LinkedList<E>) obj;
		if(this.size() != otro.size()) return false;
		Node<E> temp1 = this.head;
		Node<E> temp2 = otro.head;
		while(temp1 != null) {
			if(!temp1.element.equals(temp2.element)) return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return true;
	}

	/**
	 * Devuelve el primer elemento de la lista.
	 *
	 * @return El primer elemento de la lista, o {@code null} si la lista está vacía.
	 */
	public E getFirst() {
		if(head != null) return head.element;
		return null;
	}

	/**
	 * Devuelve el último elemento de la lista.
	 *
	 * @return El último elemento de la lista, o {@code null} si la lista está vacía.
	 */
	public E getLast() {
		if(tail != null) return tail.element;
		return null;
	}

	/**
	 * Añade un nuevo elemento al principio de la lista.
	 *
	 * @param e El elemento que se va a añadir al principio de la lista.
	 */
	public void addFirst(E e) {
		Node<E> nuevoNodo = new Node<E>(e); 
		if (tail == null) { 
			head = tail = nuevoNodo; 
		} else {
			nuevoNodo.next = head; 
			head = nuevoNodo; 
		} 
		size++;
		
		// HECHO
		/*
		 * Otra forma Podemos comprobar primero si la lista esta vacia Node<E> nuevoNodo
		 * = new Node<E>(e); if (tail == null) { head = tail = nuevoNodo; } else {
		 * nuevoNodo.next = head; head = nuevoNodo; } size++;
		 */
	}
	/**
	 * Añade un nuevo elemento al final de la lista.
	 *
	 * @param e El elemento que se va a añadir al final de la lista.
	 */
	public void addLast(E e) {
		Node<E> nuevoNodo = new Node<E>(e); 
		if (tail == null) { 
			head = tail = nuevoNodo; 
		} else {
			tail.next = nuevoNodo;
			tail = nuevoNodo;
		} 
		size++;

	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un nuevo elemento en la posición especificada por el índice.
	 * Si el índice es 0, el elemento se añade al principio.
	 * Si el índice es igual o mayor que el tamaño actual, el elemento se añade al final.
	 * Para otros índices, el elemento se inserta en la posición especificada.
	 *
	 * @param index El índice en el que se va a insertar el elemento (comenzando desde 0).
	 * @param e     El elemento que se va a añadir a la lista.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index > size()}).
	 */
	public void add(int index, E e) {
		if(index <= 0) {
			addFirst(e);
		}else if(index >= size) {
			addLast(e);
		}else {
			Node<E> nuevoNodo = new Node<>(e);
			Node<E> temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			nuevoNodo.next = temp.next;
			temp.next = nuevoNodo;
			size++;
		}
	}

	/**
	 * Elimina el primer nodo de la lista y devuelve el elemento contenido en el nodo eliminado.
	 *
	 * @return El elemento del primer nodo, o {@code null} si la lista está vacía.
	 */
	public E removeFirst() {
		if(head != null) {
			E aux = head.element;
			head = head.next;
			size--;
			if(head == null) {
				tail = null;
			}
			return aux;
		}
		return null;
	}
	/**
	 * Elimina el último nodo de la lista y devuelve el elemento contenido en el nodo eliminado.
	 *
	 * @return El elemento del último nodo, o {@code null} si la lista está vacía.
	 */
	public E removeLast() {
		if(tail != null) {
			E aux = tail.element;
			if(size == 1) {
				head = null;
				tail = null;
			}else {
				Node<E> temp = head;
				for (int i = 0; i < size-2; i++) {
					temp = temp.next;
				}
				temp.next = null;
				tail = temp;
			}
			size--;
			return aux;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina el elemento en la posición especificada por el índice y devuelve el elemento eliminado.
	 *
	 * @param index El índice del elemento que se va a borrar (comenzando desde 0).
	 * @return El elemento que fue borrado de la lista.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	public E remove(int index) {
		if(index <= 0) {
			return removeFirst();
		}else if(index >= size-1) {
			return removeLast();
		}else {
			Node<E> temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			E aux = temp.next.element;
			temp.next = temp.next.next;
			size--;
			return aux;
		}
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve una representación en cadena de la lista, que consiste en una secuencia
	 * de los elementos de la lista en el orden en que se encuentran, encerrados entre
	 * corchetes ("[]"). Los elementos adyacentes están separados por una coma y un espacio.
	 */
	@Override /** Sobre-escribe toString() */
	public String toString() {
		// [A, B, C, D]
		StringBuilder sb = new StringBuilder("[");
		Node<E> temp = head;
		while(temp != null) {
			sb.append(temp.element);
			if(temp.next != null) {
				sb.append(", ");
			}
			temp = temp.next;
		}
		return sb.toString() + "]";
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina todos los elementos de la lista, dejándola vacía.
	 */
	public void clear() {
		size = 0;
		head = tail = null;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve {@code true} si la lista contiene el elemento especificado.
	 *
	 * @param e El elemento cuya presencia en la lista se va a verificar.
	 * @return {@code true} si la lista contiene el elemento {@code e}, {@code false} en caso contrario.
	 */
	/** Devuelve true si la lista contiene el elemento e */
	public boolean contains(E e) {
		Node<E> temp = head;
		while (temp != null) {
			if(temp.element.equals(e)) return true;
			temp = temp.next;
		}
		return false;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el elemento de la lista que se encuentra en la posición especificada por el índice.
	 *
	 * @param index El índice del elemento que se va a devolver (comenzando desde 0).
	 * @return El elemento en la posición especificada por el índice.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	/** Devuelve el elemento especificado por la posicion index */
	public E get(int index) {
		if(index <= 0) return getFirst();
		if(index >= size-1) return getLast();
		Node<E> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.element;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el índice de la primera ocurrencia del elemento especificado en la lista.
	 *
	 * @param e El elemento cuyo índice se va a buscar.
	 * @return El índice de la primera ocurrencia del elemento {@code e} en la lista, o -1 si el elemento no está presente.
	 */
	
	public int indexOf(E e) {
		Node<E> temp = head;
		int pos = -1;
		while(temp != null) {
			pos++;
			if(temp.element.equals(e)) return pos;
			temp = temp.next;
		}
		return -1;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el índice de la última ocurrencia del elemento especificado en la lista.
	 *
	 * @param e El elemento cuyo último índice se va a buscar.
	 * @return El índice de la última ocurrencia del elemento {@code e} en la lista, o -1 si el elemento no está presente.
	 */
	public int lastIndexOf(E e) {
		Node<E> temp = head;
		int pos = -1;
		int posUltima = -1;
		while(temp != null) {
			pos++;
			if(temp.element.equals(e)) {
				posUltima = pos;
			}
			temp = temp.next;
		}
		return posUltima;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Sustituye el elemento en la posición especificada por el índice en la lista
	 * con el elemento especificado y devuelve el elemento que estaba previamente en esa posición.
	 *
	 * @param index El índice del elemento que se va a sustituir (comenzando desde 0).
	 * @param e     El nuevo elemento que se va a almacenar en la lista.
	 * @return El elemento que estaba previamente en la posición especificada por el índice, o {@code null} si el índice está fuera de rango.
	 * @throws IndexOutOfBoundsException Si el índice está fuera del rango válido ({@code index < 0 || index >= size()}).
	 */
	public E set(int index, E e) {
		if(index < 0 || index >= size) return null;
		Node<E> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		E aux = temp.element;
		temp.element = e;
		return aux;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve un iterador sobre los elementos de esta lista en la secuencia apropiada.
	 * El iterador proporcionado por esta clase permite la eliminación de elementos durante la iteración.
	 */
	@Override
	/** Sobre-escribe iterator() definido en Iterable */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	/**
	 * Clase interna que implementa la interfaz {@link Iterator} para la clase {@code LinkedList}.
	 * Proporciona la funcionalidad para recorrer y eliminar elementos de la lista.
	 */
	private class LinkedListIterator implements Iterator<E> {
		private Node<E> current = head; // nodo current
		private Node<E> previous = null; // nodo previous
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}
		/**
		 * {@inheritDoc}
		 *
		 * @throws NoSuchElementException Si no hay más elementos para devolver.
		 */
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E aux = current.element;
			previous = current;
			current = current.next;
			return aux;
		}
		/**
		 * {@inheritDoc}
		 *
		 * @throws IllegalStateException Si este método se llama antes de {@link #next()} o si {@link #remove()} ya ha sido llamado después de la última llamada a {@code next()}.
		 */
		@Override
		// elimina el ultimo elemento devuelto por el iterador.
		public void remove() {
			if(previous == null) {
				throw new IllegalStateException();
			}
			if(previous == head) {
				head = current;
				previous = null;
			}else {
				Node<E> temp = head;
				while(temp.next != previous) {
					temp = temp.next;
				}
				temp.next = current;
				previous = temp;
			}
			size--;
		}
	}
	/**
	 * Clase interna estática que representa un nodo en la lista enlazada.
	 * Cada nodo contiene un elemento de tipo E y una referencia al siguiente nodo en la lista.
	 */
	private static class Node<E> {
		E element;
		Node<E> next;
		/**
		 * Crea un nuevo nodo con el elemento especificado.
		 *
		 * @param element El elemento que se almacenará en este nodo.
		 */
		public Node(E element) {
			this.element = element;
		}
	}

}
