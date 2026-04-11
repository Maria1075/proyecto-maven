package org.mp.sesion05.colas;
/**
 * {@code ArrayQueue<E>} es una implementación de la interfaz {@link Queue} que utiliza
 * un array dinámico para almacenar los elementos de la cola. Permite operaciones
 * de enqueue (añadir al final) y dequeue (eliminar del frente) con un posible
 * redimensionamiento del array para acomodar un número creciente de elementos.
 *
 * @param <E> El tipo de los elementos que contendrá esta cola.
 */
public class ArrayQueue <E> implements Queue <E>{

	private static final int INITIAL_CAPACITY = 16;
	private Object[] arrayQueue;
	private int front;
	private int rear;
	private int size;
	/**
	 * Constructor: Inicializa una nueva cola vacía con la capacidad inicial predeterminada (16 elementos).
	 * Los índices {@code front} y {@code rear} se establecen en -1, y el tamaño en 0.
	 */
	public ArrayQueue() {
		this.arrayQueue = new Object[INITIAL_CAPACITY];
		this.front = -1;
		this.rear = -1;
		this.size = 0;
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Añade un elemento al final de la cola (operación enqueue).
	 * Primero, verifica y expande la capacidad del array si es necesario.
	 * Luego, añade el elemento en la siguiente posición disponible al final,
	 * incrementa el tamaño y actualiza el índice {@code rear}. Si la cola estaba
	 * vacía antes de la inserción, también inicializa el índice {@code front} a 0.
	 *
	 * @param e El elemento que se va a añadir a la cola.
	 */
	@Override
	public void enqueue (E e) {
		expandCapacity();
		arrayQueue[rear+1] = e;
		size++;
		rear++;
		if(front ==-1) {
			front = 0;
		}
	}
	/**
	 * Expande la capacidad del array interno si es necesario.
	 * Si el array está lleno (tamaño igual a la capacidad), crea un nuevo array
	 * con el doble de la capacidad más 1 y copia los elementos del array antiguo al nuevo.
	 * Si el índice {@code rear} está en la última posición del array pero aún hay espacio
	 * al principio (debido a las operaciones de dequeue), crea un nuevo array del tamaño
	 * actual de la cola, copia los elementos desde {@code front} hasta {@code rear}
	 * al nuevo array comenzando desde el índice 0, y actualiza los índices {@code front}
	 * a 0 y {@code rear} al último índice del nuevo array.
	 */
	private void expandCapacity() {
		if (size == arrayQueue.length) { //Completo
			Object[]aux = new Object [size * 2 + 1];
			System.arraycopy(arrayQueue, 0, aux, 0, size);
			arrayQueue = aux;
		} else if( rear + 1 == arrayQueue.length){
			Object[] aux = new Object [size];
			System.arraycopy(arrayQueue, front, aux, 0, size);
			arrayQueue = aux;
			front = 0;
			rear = size-1;
		}
		
	}
	/**
	 * {@inheritDoc}
	 * <p>
	 * Elimina y devuelve el elemento del frente de la cola (operación dequeue).
	 * Obtiene el elemento en el índice {@code front}, incrementa el índice {@code front}
	 * para apuntar al siguiente elemento, y decrementa el tamaño de la cola.
	 *
	 * @return El elemento que estaba al frente de la cola.
	 */
	@Override
	public E dequeue() {
		E aux = (E) arrayQueue[front];
		front++;
		size--;
		return aux;
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