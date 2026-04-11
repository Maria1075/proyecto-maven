/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01.baraja;

/**
 * The Class CartaFrancesa.
 */
public class CartaFrancesa extends Carta{

	/** The palos validos. */
	private final String[] PALOS_VALIDOS = {"Tréboles", "Diamantes", "Corazones", "Picas"};
	
	/**
	 * Instantiates a new carta francesa.
	 *
	 * @param numero the numero
	 * @param palo the palo
	 */
	public CartaFrancesa(int numero, String palo) {
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
			throw new IllegalArgumentException("Palo inválido para la baraja francesa: "+palo);
		}
		
	}

	/**
	 * Validar numero.
	 *
	 * @param numero the numero
	 */
	private void validarNumero(int numero) {
		if(numero < 1 || numero > 13) {
			throw new IllegalArgumentException("Número inválido para la baraja francesa: "+numero);
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
		case "Picas": mivalor += 13;
		case "Corazones" : mivalor += 13;
		case "Diamantes": mivalor += 13;
		}
		int otravalor = otra.numero;
		switch (otra.palo) {
		case "Picas": otravalor += 13;
		case "Corazones" : otravalor += 13;
		case "Diamantes": otravalor += 13;
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
		return this.numero+"";
	}
}