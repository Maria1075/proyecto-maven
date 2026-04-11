package org.mp.sesion05.pilas;
/**
 * {@code NodeStack<E>} es una implementación de la interfaz {@link Stack} que utiliza
 * nodos enlazados para almacenar los elementos de la pila. Esto permite operaciones
 * push (añadir en la cima) y pop (remover de la cima) con eficiencia de tiempo constante.
 *
 * @param <E> El tipo de los elementos que contendrá esta pila.
 */
public class NodeStack<E> implements Stack<E>{

	private Node<E> top;
	private int size;
	/**
	 * Constructor: Inicializa una nueva pila vacía. La referencia {@code top} se
	 * establece en {@code null}, y el tamaño en 0.
	 */
	public NodeStack() {
		this.top = null;
		this.size = 0;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el número de elementos que contiene la pila.
	 *
	 * @return El número de elementos en la pila.
	 */
	@Override
	public int getSize() {
		return this.size;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el elemento que se encuentra en la cima de la pila sin eliminarlo.
	 * Si la pila está vacía ({@code top} es {@code null}), devuelve {@code null}.
	 *
	 * @return El elemento en la cima de la pila, o {@code null} si la pila está vacía.
	 */
	@Override
	public E peek() {
		if(top == null) return null;
		return top.element;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un elemento a la cima de la pila (operación push).
	 * Crea un nuevo nodo con el elemento proporcionado. El {@code next} de este
	 * nuevo nodo se establece para que apunte al nodo {@code top} actual (la antigua
	 * cima), y luego {@code top} se actualiza para que se refiera al nuevo nodo.
	 * El tamaño de la pila se incrementa.
	 *
	 * @param o El elemento que se va a añadir a la cima de la pila.
	 */
	@Override
	public void push(E o) {
		Node<E> nuevoNodo = new Node<>(o);
		nuevoNodo.next = top;
		top = nuevoNodo;
		size++;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina y devuelve el elemento que se encuentra en la cima de la pila (operación pop).
	 * Si la pila está vacía ({@code top} es {@code null}), devuelve {@code null}.
	 * De lo contrario, se guarda el elemento del nodo {@code top}. Luego, {@code top}
	 * se actualiza para que se refiera al siguiente nodo ({@code top.next}),
	 * efectivamente eliminando la antigua cima. El tamaño de la pila se decrementa
	 * y el elemento original de la cima se devuelve.
	 *
	 * @return El elemento que estaba en la cima de la pila, o {@code null} si la pila está vacía.
	 */
	@Override
	public E pop() {
		if(top == null) return null;
		E aux = top.element;
		top = top.next;
		size--;
		return aux;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve {@code true} si la pila no contiene ningún elemento (es decir, si
	 * {@code top} es {@code null}).
	 *
	 * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	/**
	 * Clase interna estática que representa un nodo en la pila enlazada.
	 * Cada nodo contiene un elemento de tipo E y una referencia al siguiente nodo en la pila.
	 */
	private static class Node<E> {
		E element;
		Node<E> next;
		/**
		 * Constructor: Crea un nuevo nodo con el elemento especificado.
		 *
		 * @param element El elemento que se almacenará en este nodo.
		 */
		public Node(E element) {
			this.element = element;
		}
	}

}
