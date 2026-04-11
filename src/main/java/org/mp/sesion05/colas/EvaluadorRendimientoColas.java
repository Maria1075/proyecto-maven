package org.mp.sesion05.colas;
/**
 * {@code EvaluadorRendimientoColas} evalúa el rendimiento de las implementaciones
 * {@link ArrayQueue}, {@link NodeQueue} y {@link LinkedListQueue} de la interfaz
 * {@link Queue} midiendo el tiempo de ejecución de las operaciones enqueue y dequeue
 * para diferentes tamaños de cola.
 */
public class EvaluadorRendimientoColas {
	/**
	 * Método principal que ejecuta las pruebas de rendimiento para las diferentes
	 * implementaciones de colas. Mide el tiempo necesario para realizar una serie
	 * de operaciones enqueue y dequeue para varios tamaños de cola.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		System.out.println("Prueba de tiempo constante de operaciones en colas:");
		ArrayQueue<Integer> as;
		NodeQueue<Integer> ns;
		LinkedListQueue<Integer> lls;
		long start;
		long end;
		
		System.out.println("ArrayQueue:");
		System.out.printf("%-30s%-30s%-30s\n","Tamaño de operaciones", "Tiempo enqueue (ns)", "Tiempo dequeue (ns)");
		for (int n = 10000; n <= 50000; n+=10000) {
			as = new ArrayQueue<>();
			System.out.printf("%-30d", n);
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				as.enqueue(i);
			}
			end = System.nanoTime();
			System.out.printf("%-30d",end-start);
			
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				as.dequeue();
			}
			end = System.nanoTime();
			System.out.printf("%-30d\n", end-start);
		}
		

		System.out.println("NodeQueue:");
		System.out.printf("%-30s%-30s%-30s\n","Tamaño de operaciones", "Tiempo enqueue (ns)", "Tiempo dequeue (ns)");
		for (int n = 10000; n <= 50000; n+=10000) {
			ns = new NodeQueue<>();
			System.out.printf("%-30d", n);
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				ns.enqueue(i);
			}
			end = System.nanoTime();
			System.out.printf("%-30d",end-start);
			
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				ns.dequeue();
			}
			end = System.nanoTime();
			System.out.printf("%-30d\n", end-start);
		}
		
		System.out.println("LinkedListQueue:");
		System.out.printf("%-30s%-30s%-30s\n","Tamaño de operaciones", "Tiempo enqueue (ns)", "Tiempo dequeue (ns)");
		for (int n = 10000; n <= 50000; n+=10000) {
			lls = new LinkedListQueue<>();
			System.out.printf("%-30d", n);
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				lls.enqueue(i);
			}
			end = System.nanoTime();
			System.out.printf("%-30d",end-start);
			
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				lls.dequeue();
			}
			end = System.nanoTime();
			System.out.printf("%-30d\n", end-start);
		}
	}

}
