/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01.baraja;

/**
 * The Class CartaEspanola.
 */
public class CartaEspanola extends Carta{

	/** The palos validos. */
	private final String[] PALOS_VALIDOS = {"Oros", "Copas", "Espadas", "Bastos"};
	
	/**
	 * Instantiates a new carta espanola.
	 *
	 * @param numero the numero
	 * @param palo the palo
	 */
	public CartaEspanola(int numero, String palo) {
		super(numero, palo);
		validarNumero(numero);
		validarPalo(palo);
	}

	/**
	 * Validar palo.
	 *
	 * @param palo the palo
	 */
	private void validarPalo(String palo) {
		boolean correcto = false;
		for (int i = 0; i < PALOS_VALIDOS.length; i++) {
			if(PALOS_VALIDOS[i].equals(palo)) {
				correcto = true;
				break;
			}
		}
		if(!correcto) {
			throw new IllegalArgumentException("Palo inválido para la baraja espanola: "+palo);
		}
		
	}

	/**
	 * Validar numero.
	 *
	 * @param numero the numero
	 */
	private void validarNumero(int numero) {
		if((numero >= 1 && numero <= 7) || (numero >= 10 && numero <= 12)) {
			//Correcto
		}else {
			throw new IllegalArgumentException("Número inválido para la baraja espanola: "+numero);
		}
	}

	/**
	 * Compare to.
	 *
	 * @param otra the otra
	 * @return the int
	 */
	@Override
	public int compareTo(Carta otra) {
		int mivalor = this.numero;
		switch (this.palo) {
		case "Bastos": mivalor += 12;
		case "Espadas" : mivalor += 12;
		case "Copas": mivalor += 12;
		}
		int otravalor = otra.numero;
		switch (otra.palo) {
		case "Bastos": otravalor += 12;
		case "Espadas" : otravalor += 12;
		case "Copas": otravalor += 12;
		}
		return Integer.compare(mivalor, otravalor); // -1, 0, 1
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	@Override
	public String getNombre() {
		switch (this.numero) {
		case 1: return "As";
		case 10: return "Sota";
		case 11: return "Caballo";
		case 12: return "Rey";
		default: return this.numero+"";
		}
	}
}