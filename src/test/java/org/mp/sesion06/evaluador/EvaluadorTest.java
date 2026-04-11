package org.mp.sesion06.evaluador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mp.sesion05.colas.LinkedListQueue;
import org.mp.sesion05.colas.Queue;
import org.mp.sesion05.pilas.ArrayStack;
import org.mp.sesion05.pilas.Stack;

public class EvaluadorTest {
	
	private Evaluador evaluador;

	@BeforeEach
	public void setUp() throws Exception {
		Stack<Integer> pila = new ArrayStack<>();
		Queue<String> cola = new LinkedListQueue<>();
		evaluador = new Evaluador(pila,cola);

	}

	@Test
	public void testEliminarBlancos()  {

		String[] sinBlancos1 = { "7", "8", "6", "5" };
		assertEquals(Arrays.toString(sinBlancos1), Arrays.toString(evaluador.eliminarBlancos("7 8 6 5")));

		String [] sinBlancos2 = {"7865"};
		assertEquals(Arrays.toString(sinBlancos2), Arrays.toString(evaluador.eliminarBlancos("7865")));

		String [] sinBlancos3 = {"9"};
		assertEquals(Arrays.toString(sinBlancos3), Arrays.toString(evaluador.eliminarBlancos("9")));

		String[] sinBlancos4 = { "10", "3", "+" };
		assertEquals(Arrays.toString(sinBlancos4), Arrays.toString(evaluador.eliminarBlancos("10  3  +")));

		String [] sinBlancos5 = {"3","10","-"};
		assertEquals(Arrays.toString(sinBlancos5), Arrays.toString(evaluador.eliminarBlancos("3  10   -")));

		String [] sinBlancos6 = {"10","3","*"};
		assertEquals(Arrays.toString(sinBlancos6), Arrays.toString(evaluador.eliminarBlancos("10  3  *")));

		String [] sinBlancos7 = {"10","3","/"};
		assertEquals(Arrays.toString(sinBlancos7), Arrays.toString(evaluador.eliminarBlancos("10  3  /")));

		String [] sinBlancos8 = {"5","1","2","+","4","*","+","3","-"};
		assertEquals(Arrays.toString(sinBlancos8), Arrays.toString(evaluador.eliminarBlancos("5  1 2+ 4*+  3-")));


}
	@Test
	public void testProcesarUnOperador()  {

		Stack<Integer> operandosPila = new ArrayStack<Integer>();
		char op = '+';
		operandosPila.push(7);
		operandosPila.push(12);

		evaluador.procesarUnOperador(op, operandosPila);
		assertEquals(19, (int)operandosPila.pop());


		operandosPila = new ArrayStack<Integer>();
		op = '-';
		operandosPila.push(7);
		operandosPila.push(12);

		evaluador.procesarUnOperador(op, operandosPila);
		assertEquals(-5, (int)operandosPila.pop());

		operandosPila = new ArrayStack<Integer>();
		op = '*';
		operandosPila.push(7);
		operandosPila.push(12);

		evaluador.procesarUnOperador(op, operandosPila);
		assertEquals(84, (int)operandosPila.pop());

		operandosPila = new ArrayStack<Integer>();
		op = '/';
		operandosPila.push(7);
		operandosPila.push(12);

		evaluador.procesarUnOperador(op, operandosPila);
		assertEquals(0, (int)operandosPila.pop());

		operandosPila = new ArrayStack<Integer>();
		op = '/';
		operandosPila.push(12);
		operandosPila.push(0);

		try {
			evaluador.procesarUnOperador(op, operandosPila);
			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "No es posible una división por cero");
		}


	}
	@Test
	public void testEvaluarExpresion()  {

		assertEquals(7865, evaluador.evaluarExpresion("7 8   6 5"));

		assertEquals(9, evaluador.evaluarExpresion("9"));

		assertEquals(13, evaluador.evaluarExpresion("10 3  +"));

		assertEquals(-7, evaluador.evaluarExpresion("3  10  -"));

		assertEquals(30, evaluador.evaluarExpresion("10  3  *"));

		assertEquals(3, evaluador.evaluarExpresion("10  3  /"));

		assertEquals(14, evaluador.evaluarExpresion("5  1 2+ 4*+  3-"));

}
}