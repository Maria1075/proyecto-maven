package org.mp.sesion05.pilas;
/**
 * {@code EvaluadorRendimientoPilas} evalúa el rendimiento de las implementaciones
 * {@link ArrayStack}, {@link NodeStack} y {@link LinkedListStack} de la interfaz
 * {@link Stack} midiendo el tiempo de ejecución de las operaciones push y pop
 * para diferentes tamaños de pila.
 */
public class EvaluadorRendimientoPilas {
	/**
	 * Método principal que ejecuta las pruebas de rendimiento para las diferentes
	 * implementaciones de pilas. Mide el tiempo necesario para realizar una serie
	 * de operaciones push y pop para varios tamaños de pila.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		System.out.println("Prueba de tiempo constante de operaciones en pilas:");
		ArrayStack<Integer> as;
		NodeStack<Integer> ns;
		LinkedListStack<Integer> lls;
		long start;
		long end;
		
		System.out.println("ArrayStack:");
		System.out.printf("%-30s%-30s%-30s\n","Tamaño de operaciones", "Tiempo push (ns)", "Tiempo pop (ns)");
		for (int n = 10000; n <= 50000; n+=10000) {
			as = new ArrayStack<>();
			System.out.printf("%-30d", n);
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				as.push(i);
			}
			end = System.nanoTime();
			System.out.printf("%-30d",end-start);
			
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				as.pop();
			}
			end = System.nanoTime();
			System.out.printf("%-30d\n", end-start);
		}
		

		System.out.println("NodeStack:");
		System.out.printf("%-30s%-30s%-30s\n","Tamaño de operaciones", "Tiempo push (ns)", "Tiempo pop (ns)");
		for (int n = 10000; n <= 50000; n+=10000) {
			ns = new NodeStack<>();
			System.out.printf("%-30d", n);
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				ns.push(i);
			}
			end = System.nanoTime();
			System.out.printf("%-30d",end-start);
			
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				ns.pop();
			}
			end = System.nanoTime();
			System.out.printf("%-30d\n", end-start);
		}
		
		System.out.println("LinkedListStack:");
		System.out.printf("%-30s%-30s%-30s\n","Tamaño de operaciones", "Tiempo push (ns)", "Tiempo pop (ns)");
		for (int n = 10000; n <= 50000; n+=10000) {
			lls = new LinkedListStack<>();
			System.out.printf("%-30d", n);
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				lls.push(i);
			}
			end = System.nanoTime();
			System.out.printf("%-30d",end-start);
			
			start = System.nanoTime();
			for (int i = 0; i < n; i++) {
				lls.pop();
			}
			end = System.nanoTime();
			System.out.printf("%-30d\n", end-start);
		}
	}

}
