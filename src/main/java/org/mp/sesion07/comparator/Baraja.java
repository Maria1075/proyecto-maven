/**
 * Clase que representa una baraja de cartas. Permite listar, ordenar, barajar y buscar cartas.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.comparator;

import java.util.Random;

public class Baraja {

	private String nombreBaraja;   // Nombre de la baraja (ej. "Baraja Española")
	private Carta[] cartas;        // Array de cartas que componen la baraja

	/**
	 * Constructor de la clase Baraja.
	 *
	 * @param nombreBaraja Nombre asignado a la baraja
	 * @param cartas Arreglo de cartas que componen la baraja
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		super();
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}

	/** @return Nombre de la baraja */
	public String getNombreBaraja() {
		return nombreBaraja;
	}

	/** @param nombreBaraja Nuevo nombre para la baraja */
	public void setNombreBaraja(String nombreBaraja) {
		this.nombreBaraja = nombreBaraja;
	}

	/** @return Arreglo de cartas de la baraja */
	public Carta[] getCartas() {
		return cartas;
	}

	/** @param cartas Nuevo arreglo de cartas */
	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	/**
	 * Muestra por consola todas las cartas de la baraja en orden actual.
	 */
	public void listadoBaraja() {
		for (int i = 0; i < cartas.length; i++) {
			System.out.println(cartas[i].getPalo() + " " + cartas[i].getNumero());
		}
	}

	/**
	 * Busca una carta específica dentro de la baraja.
	 *
	 * @param carta Carta a buscar
	 * @return La carta si se encuentra, null en caso contrario
	 */
	public Carta buscarCarta(Carta carta) {
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i].equals(carta)) {
				return cartas[i];
			}
		}
		return null;
	}

	/**
	 * Ordena la baraja usando orden natural (según compareTo de Carta).
	 * Implementa ordenación por inserción.
	 */
	public void ordenarBaraja() {
		for (int p = 1; p < cartas.length; p++) {
			int j = p;
			Carta tmp = cartas[p];
			for (; j > 0 && tmp.compareTo(cartas[j - 1]) < 0; j--) {
				cartas[j] = cartas[j - 1];
			}
			cartas[j] = tmp;
		}
	}

	/**
	 * Baraja aleatoriamente las cartas realizando múltiples intercambios al azar.
	 */
	public void barajar() {
		Random rand = new Random();
		for (int i = 0; i < 160; i++) {
			int x = rand.nextInt(40); // índice aleatorio 1
			int y = rand.nextInt(40); // índice aleatorio 2

			Carta swap = cartas[x];
			cartas[x] = cartas[y];
			cartas[y] = swap;
		}
	}

	/**
	 * Representación textual de la baraja (pendiente de implementación personalizada).
	 */
	@Override
	public String toString() {
		// Implementación personalizada sugerida
		return super.toString(); // Actualmente devuelve el toString() de Object
	}
}
