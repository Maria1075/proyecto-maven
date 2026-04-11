/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01.baraja;

/**
 * The Class Carta.
 */
public abstract class Carta implements Comparable<Carta>{

	/** The numero. */
	public int numero;
	
	/** The palo. */
	public String palo;
	
	/**
	 * Instantiates a new carta.
	 *
	 * @param numero the numero
	 * @param palo the palo
	 */
	public Carta(int numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public abstract String getNombre();
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return getNombre()+" de "+this.palo;
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Carta otra = (Carta) obj;
		return this.palo.equals(otra.palo) && this.numero == otra.numero;
	}
}
