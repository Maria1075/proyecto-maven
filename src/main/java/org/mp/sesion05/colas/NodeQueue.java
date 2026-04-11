package org.mp.sesion05.colas;
/**
 * {@code NodeQueue<E>} es una implementación de la interfaz {@link Queue} que utiliza
 * nodos enlazados para almacenar los elementos de la cola. Esto permite operaciones
 * de enqueue (añadir al final) y dequeue (eliminar del frente) con eficiencia de tiempo constante.
 *
 * @param <E> El tipo de los elementos que contendrá esta cola.
 */
public class NodeQueue <E> implements Queue <E>{
	/**
	 * Constructor: Inicializa una nueva cola vacía. Tanto {@code front} como {@code rear}
	 * se establecen en {@code null}, y el tamaño en 0.
	 */
	private Node <E> front;
	private Node <E> rear;
	private int size;
	
	public NodeQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un elemento al final de la cola (operación enqueue).
	 * Crea un nuevo nodo con el elemento proporcionado. Si la cola está vacía,
	 * tanto {@code front} como {@code rear} se refieren a este nuevo nodo.
	 * De lo contrario, el {@code next} del nodo {@code rear} actual se establece
	 * para que apunte al nuevo nodo, y {@code rear} se actualiza para que se refiera
	 * al nuevo nodo. El tamaño de la cola se incrementa.
	 *
	 * @param e El elemento que se va a añadir a la cola.
	 */
	
	@Override
	public void enqueue(E e) {
		Node <E> nuevoNodo = new Node <> (e);
		if ( front == null) {
			front = nuevoNodo;
			rear = nuevoNodo;
		} else {
			rear.next = nuevoNodo;
			rear = nuevoNodo;
		}
		size++;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina y devuelve el elemento del frente de la cola (operación dequeue).
	 * Si la cola no está vacía, se guarda el elemento del nodo {@code front}.
	 * Luego, {@code front} se actualiza para que se refiera al siguiente nodo.
	 * Si después de la eliminación {@code front} se vuelve {@code null}, significa
	 * que la cola ahora está vacía, por lo que {@code rear} también se establece en
	 * {@code null}. El tamaño de la cola se decrementa y el elemento original
	 * del frente se devuelve. Si la cola está vacía, devuelve {@code null}.
	 *
	 * @return El elemento que estaba al frente de la cola, o {@code null} si la cola está vacía.
	 */

	@Override
	public E dequeue() {
		if( size != 0 ) {
			E aux = front.element;
			front = front.next;
			if ( front == null) {
				rear = null;
			}
			size--;
			return aux;
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Devuelve el número de elementos que contiene la cola.
	 *
	 * @return El número de elementos en la cola.
	 */

	@Override
	public int getSize() {
		return size;
	}
	/**
	 * Clase interna estática que representa un nodo en la cola enlazada.
	 * Cada nodo contiene un elemento de tipo E y una referencia al siguiente nodo en la cola.
	 */

	private static class Node<E>{
		E element;
		Node<E> next;
		/**
		 * Constructor: Crea un nuevo nodo con el elemento especificado.
		 *
		 * @param element El elemento que se almacenará en este nodo.
		 */
		public Node (E element) {
			this.element = element;
		}
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
}