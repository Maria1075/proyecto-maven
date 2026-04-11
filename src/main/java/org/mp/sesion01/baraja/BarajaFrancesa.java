/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01.baraja;

/**
 * The Class BarajaFrancesa.
 */
public class BarajaFrancesa extends Baraja{
	
	/** The Constant PALOS_VALIDOS. */
	private final static String[] PALOS_VALIDOS = {"Tréboles", "Diamantes", "Corazones", "Picas"};

	/**
	 * Crear baraja.
	 */
	@Override
	public void crearBaraja() {
		this.cartas = new Carta[52];
		for (int i = 0; i < cartas.length; i++) {
			int numero = i % 13 + 1;
			int posicionPalo = i / 13;
			String palo = PALOS_VALIDOS[posicionPalo];
			Carta c = new CartaFrancesa(numero, palo);
			this.cartas[i] = c;
		}
	}
}