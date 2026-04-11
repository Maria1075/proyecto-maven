package org.mp.sesion05.colas;

import org.mp.sesion04.list.linkedlist.LinkedList;
/**
 * {@code LinkedListQueue<E>} es una implementación de la interfaz {@link Queue}
 * que utiliza una {@link LinkedList} subyacente para almacenar los elementos de la cola.
 * Esto permite operaciones de enqueue (añadir al final de la lista) y dequeue
 * (eliminar del principio de la lista) de manera eficiente.
 *
 * @param <E> El tipo de los elementos que contendrá esta cola.
 */
public class LinkedListQueue<E> implements Queue<E>{
	
	private LinkedList<E> list;
	/**
	 * Constructor: Inicializa una nueva cola vacía utilizando una instancia de {@link LinkedList}.
	 */
	public LinkedListQueue() {
		this.list = new LinkedList<>();
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un elemento al final de la cola. Esta operación se delega al método
	 * {@code addLast()} de la {@link LinkedList} subyacente.
	 *
	 * @param e El elemento que se va a añadir a la cola.
	 */
	@Override
	public void enqueue(E e) {
		this.list.addLast(e);
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina y devuelve el elemento del frente de la cola. Esta operación se delega
	 * al método {@code removeFirst()} de la {@link LinkedList} subyacente.
	 *
	 * @return El elemento que estaba al frente de la cola.
	 */
	@Override
	public E dequeue() {
		return this.list.removeFirst();
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el número de elementos que contiene la cola. Esta operación se delega
	 * al método {@code size()} de la {@link LinkedList} subyacente.
	 *
	 * @return El número de elementos en la cola.
	 */
	@Override
	public int getSize() {
		return this.list.size();
	}
	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return this.list.toString();
	}

}
