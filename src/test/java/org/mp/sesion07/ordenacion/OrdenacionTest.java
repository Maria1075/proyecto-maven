package org.mp.sesion07.ordenacion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;

public class OrdenacionTest {

	@Test
	public void testIntegerArray() {
		Integer[] array = new Integer[10];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(200) - 100;
		}
		Integer[] original = array.clone(); // Crear una copia del array original
		// Prueba de ordenación por inserción
		Integer[] arrayCopy = array.clone();
		Ordenacion.ordenacionPorInsercion(arrayCopy);
		// Imprimir los arrays para depuración
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Ordenado: " + Arrays.toString(arrayCopy));
		assertTrue(isSorted(arrayCopy));
		// Prueba de mergesort
		arrayCopy = array.clone();
		Ordenacion.mergeSort(arrayCopy);
		// Imprimir los arrays para depuración
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Ordenado: " + Arrays.toString(arrayCopy));
		assertTrue(isSorted(arrayCopy));
		// Prueba de sort (Arrays.sort)
		arrayCopy = array.clone();
		Ordenacion.sort(arrayCopy);
		// Imprimir los arrays para depuración
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Ordenado: " + Arrays.toString(arrayCopy));
		assertTrue(isSorted(arrayCopy));
	}

	@Test
	public void testStringArray() {
		String[] array = new String[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = generateRandomString();
		}
		String[] original = array.clone(); // Crear una copia del array original
		// Prueba de ordenación por inserción
		String[] arrayCopy = array.clone();
		Ordenacion.ordenacionPorInsercion(arrayCopy);
		// Imprimir los arrays para depuración
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Ordenado: " + Arrays.toString(arrayCopy));
		assertTrue(isSorted(arrayCopy));
		// Prueba de merge sort
		arrayCopy = array.clone();
		Ordenacion.mergeSort(arrayCopy);
		// Imprimir los arrays para depuración
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Ordenado: " + Arrays.toString(arrayCopy));
		assertTrue(isSorted(arrayCopy));
		// Prueba de sort (Arrays.sort)
		arrayCopy = array.clone();
		Ordenacion.sort(arrayCopy);
		// Imprimir los arrays para depuración
		System.out.println("Original: " + Arrays.toString(original));
		System.out.println("Ordenado: " + Arrays.toString(arrayCopy));
		assertTrue(isSorted(arrayCopy));
	}

	// Método auxiliar para verificar si un array está ordenado en orden ascendente
	private <T extends Comparable<T>> boolean isSorted(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	private String generateRandomString() {
		int length = new Random().nextInt(2) + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append((char) (new Random().nextInt(26) + 'a'));
		}
		return sb.toString();
	}

}