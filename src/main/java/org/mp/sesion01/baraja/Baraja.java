/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01.baraja;

/**
 * The Class Baraja.
 */
public abstract class Baraja {
	
	/** The cartas. */
	public Carta[] cartas;
	
	/** The indice. */
	protected int indice;
	
	/**
	 * Instantiates a new baraja.
	 */
	public Baraja() {
		crearBaraja();
		this.indice = 0;
	}
	
	/**
	 * Crear baraja.
	 */
	public abstract void crearBaraja();
	
	/**
	 * Barajar.
	 */
	public void barajar() {
		for (int i = 0; i < cartas.length * 20; i++) {
			int a = (int) (Math.random() * cartas.length);
			int b = (int) (Math.random() * cartas.length);
			Carta aux = cartas[a];
			cartas[a] = cartas[b];
			cartas[b] = aux;
		}
		this.indice = 0;
	}
	
	/**
	 * Ordenar.
	 */
	public void ordenar() {
		for (int i = 1; i < cartas.length; i++) {
			Carta aux = cartas[i];
			int j;
			for (j = i-1; j>=0 && aux.compareTo(cartas[j]) < 0; j--) {
				cartas[j+1] = cartas[j];
			}
			cartas[j+1] = aux;
		}
		this.indice = 0;
	}
	
	/**
	 * Mostrar.
	 */
	public void mostrar() {
		System.out.println("Baraja de "+cartas.length+" cartas:");
		for (int i = 0; i < cartas.length; i++) {
			System.out.println("["+(i+1)+"] "+cartas[i]);
		}
	}
	
	/**
	 * Repartir carta.
	 *
	 * @return the carta
	 */
	public Carta repartirCarta() {
		Carta c = this.cartas[indice];
		indice++;
		if(indice >= this.cartas.length) {
			indice = 0;
		}
		return c;
	}
	
	/**
	 * Cortar baraja.
	 */
	public void cortarBaraja() {
		int p = (int)(Math.random()* cartas.length);
		Carta[] aux = new Carta [cartas.length];
		int k = 0;
		for (int i = p+1; i < cartas.length; i++, k++) {
			aux[k] = cartas[i];
		}
		for (int i = 0; i <= p; i++, k++) {
			aux[k] = cartas[i];
		}
		this.cartas = aux;
	}
}


