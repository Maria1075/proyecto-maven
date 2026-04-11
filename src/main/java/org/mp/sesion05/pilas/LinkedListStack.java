package org.mp.sesion05.pilas;

import org.mp.sesion04.list.linkedlist.LinkedList;
/**
 * {@code LinkedListStack<E>} es una implementación de la interfaz {@link Stack}
 * que utiliza una {@link LinkedList} subyacente para almacenar los elementos de la pila.
 * Esto permite operaciones de push (añadir al principio de la lista) y pop
 * (eliminar del principio de la lista) de manera eficiente.
 *
 * @param <E> El tipo de los elementos que contendrá esta pila.
 */
public class LinkedListStack<E> implements Stack<E>{

	private LinkedList<E> list;
	/**
	 * Constructor: Inicializa una nueva pila vacía utilizando una instancia de {@link LinkedList}.
	 */
	public LinkedListStack() {
		this.list = new LinkedList<>();
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el número de elementos que contiene la pila. Esta operación se delega
	 * al método {@code size()} de la {@link LinkedList} subyacente.
	 *
	 * @return El número de elementos en la pila.
	 */
	@Override
	public int getSize() {
		return this.list.size();
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el elemento que se encuentra en la cima de la pila sin eliminarlo.
	 * Esta operación se delega al método {@code getFirst()} de la {@link LinkedList}
	 * subyacente, que devuelve el primer elemento de la lista (la cima de la pila).
	 *
	 * @return El elemento en la cima de la pila, o {@code null} si la pila está vacía.
	 */
	@Override
	public E peek() {
		return this.list.getFirst();
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un elemento a la cima de la pila (operación push). Esta operación se delega
	 * al método {@code addFirst()} de la {@link LinkedList} subyacente, que añade el
	 * elemento al principio de la lista (la nueva cima de la pila).
	 *
	 * @param o El elemento que se va a añadir a la cima de la pila.
	 */
	@Override
	public void push(E o) {
		this.list.addFirst(o);
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina y devuelve el elemento que se encuentra en la cima de la pila (operación pop).
	 * Esta operación se delega al método {@code removeFirst()} de la {@link LinkedList}
	 * subyacente, que elimina y devuelve el primer elemento de la lista (la cima de la pila).
	 *
	 * @return El elemento que estaba en la cima de la pila, o {@code null} si la pila está vacía.
	 */
	@Override
	public E pop() {
		return this.list.removeFirst();
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve {@code true} si la pila no contiene ningún elemento. Esta operación se
	 * delega al método {@code isEmpty()} de la {@link LinkedList} subyacente.
	 *
	 * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
	 */
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

}
