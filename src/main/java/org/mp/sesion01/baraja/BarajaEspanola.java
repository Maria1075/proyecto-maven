
/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01.baraja;

/**
 * The Class BarajaEspanola.
 */
public class BarajaEspanola extends Baraja{
	
	/** The Constant PALOS_VALIDOS. */
	private final static String[] PALOS_VALIDOS = {"Oros", "Copas", "Espadas", "Bastos"};

	/**
	 * Crear baraja.
	 */
	@Override
	public void crearBaraja() {
		this.cartas = new Carta[40];
		for (int i = 0; i < cartas.length; i++) {
			int numero = (i % 10 + 1);
			if(numero >= 8) {
				numero += 2;
			}
			int posicionPalo = i / 10;
			String palo = PALOS_VALIDOS[posicionPalo];
			Carta c = new CartaEspanola(numero, palo);
			this.cartas[i] = c;
		}
	}
}
