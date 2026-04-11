/**
 * Clase que permite evaluar expresiones aritméticas simples en notación infija.
 * Utiliza una pila de enteros y una cola de tokens para el procesamiento.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion06.evaluador;

import org.mp.sesion05.colas.Queue;
import org.mp.sesion05.pilas.Stack;

public class Evaluador {

	private Stack<Integer> pila; // Pila de operandos
	private Queue<String> cola;  // Cola que puede contener tokens (no usada directamente en este código)

	/**
	 * Constructor del evaluador.
	 *
	 * @param pila Estructura de pila que se utilizará para los operandos
	 * @param cola Estructura de cola (no usada en esta implementación)
	 */
	public Evaluador(Stack<Integer> pila, Queue<String> cola) {
		this.pila = pila;
		this.cola = cola;
	}

	/**
	 * Elimina espacios de una expresión y separa operadores de operandos.
	 *
	 * @param expresion Cadena con la expresión a evaluar
	 * @return Arreglo de tokens separados
	 */
	public String[] eliminarBlancos(String expresion) {
		String aux = "";
		for (int i = 0; i < expresion.length(); i++) {
			if (esOperador(expresion.charAt(i) + "")) {
				aux += " ";
			}
			aux += expresion.charAt(i);
		}
		return aux.split("[ ]+"); // Divide por uno o más espacios
	}

	/**
	 * Procesa una operación aritmética usando dos operandos de la pila.
	 *
	 * @param op Operador (+, -, *, /)
	 * @param operandosPila Pila desde la que se toman los operandos
	 */
	public void procesarUnOperador(char op, Stack<Integer> operandosPila) {
		Integer segundoOperando = operandosPila.pop();
		Integer primerOperando = operandosPila.pop();

		switch (op) {
			case '+':
				operandosPila.push(primerOperando + segundoOperando);
				break;
			case '-':
				operandosPila.push(primerOperando - segundoOperando);
				break;
			case '*':
				operandosPila.push(primerOperando * segundoOperando);
				break;
			case '/':
				if (segundoOperando == 0) {
					throw new RuntimeException("No es posible una división por cero");
				}
				operandosPila.push(primerOperando / segundoOperando);
		}
	}

	/**
	 * Evalúa una expresión aritmética dada en formato infijo simple.
	 *
	 * @param expresion La expresión a evaluar
	 * @return Resultado entero de la evaluación
	 */
	public int evaluarExpresion(String expresion) {
		if (soloDigitos(expresion)) {
			return Integer.parseInt(expresion.replace(" ", ""));
		}
		String[] aux = eliminarBlancos(expresion);
		for (int i = 0; i < aux.length; i++) {
			if (esOperador(aux[i])) {
				procesarUnOperador(aux[i].charAt(0), pila);
			} else {
				pila.push(Integer.parseInt(aux[i]));
			}
		}
		return pila.pop();
	}

	/**
	 * Verifica si una expresión contiene solo dígitos y espacios.
	 *
	 * @param expresion La expresión a analizar
	 * @return true si contiene solo números y espacios; false en caso contrario
	 */
	private boolean soloDigitos(String expresion) {
		for (int i = 0; i < expresion.length(); i++) {
			if (!Character.isDigit(expresion.charAt(i)) && !Character.isWhitespace(expresion.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determina si un token es un operador aritmético válido.
	 *
	 * @param token El token a comprobar
	 * @return true si es uno de los operadores válidos (+, -, *, /)
	 */
	private boolean esOperador(String token) {
		if (token.length() != 1) return false;
		switch (token) {
			case "+":
			case "-":
			case "*":
			case "/":
				return true;
		}
		return false;
	}
}
