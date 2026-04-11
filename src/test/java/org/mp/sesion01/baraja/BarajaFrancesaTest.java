package org.mp.sesion01.baraja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarajaFrancesaTest {
	private BarajaFrancesa baraja;

	@BeforeEach
	public void setUp() {
		baraja = new BarajaFrancesa();
	}

	@Test
	public void testCrearBaraja() {
		assertEquals(52, baraja.cartas.length);

		// Verificar que hay 13 cartas de cada palo
		int treboles = 0;
		int diamantes = 0;
		int corazones = 0;
		int picas = 0;

		for (Carta carta : baraja.cartas) {
			switch (carta.palo) {
			case "Tréboles":
				treboles++;
				break;
			case "Diamantes":
				diamantes++;
				break;
			case "Corazones":
				corazones++;
				break;
			case "Picas":
				picas++;
				break;
			}
		}

		assertEquals(13, treboles);
		assertEquals(13, diamantes);
		assertEquals(13, corazones);
		assertEquals(13, picas);
	}

	@Test
	public void testBarajar() {
		// Guardar el orden original
		Carta[] cartasOriginales = new Carta[52];
		System.arraycopy(baraja.cartas, 0, cartasOriginales, 0, 52);

		baraja.barajar();

		// Verificar que las cartas están en diferente orden
		boolean diferenteOrden = false;
		for (int i = 0; i < baraja.cartas.length; i++) {
			if (!baraja.cartas[i].equals(cartasOriginales[i])) {
				diferenteOrden = true;
				break;
			}
		}

		assertTrue(diferenteOrden, "La baraja debería estar en diferente orden después de barajar");

		// Verificar que están todas las cartas (sin duplicados ni pérdidas)
		boolean[] encontradas = new boolean[52];
		for (Carta cartaOriginal : cartasOriginales) {
			boolean encontrada = false;
			for (int i = 0; i < baraja.cartas.length; i++) {
				if (!encontradas[i] && cartaOriginal.equals(baraja.cartas[i])) {
					encontradas[i] = true;
					encontrada = true;
					break;
				}
			}
			assertTrue(encontrada, "Todas las cartas originales deben estar presentes");
		}
	}

	@Test
	public void testOrdenar() {
		baraja.barajar();
		baraja.ordenar();

		// Verificar que están ordenadas por palo y número
		for (int i = 1; i < baraja.cartas.length; i++) {
			CartaFrancesa actual = (CartaFrancesa) baraja.cartas[i];
			CartaFrancesa anterior = (CartaFrancesa) baraja.cartas[i - 1];
			assertTrue(actual.compareTo(anterior) >= 0, "Las cartas deben estar ordenadas");
		}
	}

	@Test
	public void testCortarBaraja() {
		// Guardar el orden original
		Carta[] cartasOriginales = new Carta[52];
		System.arraycopy(baraja.cartas, 0, cartasOriginales, 0, 52);

		baraja.cortarBaraja();

		// Verificar que el orden ha cambiado
		boolean diferenteOrden = false;
		for (int i = 0; i < baraja.cartas.length; i++) {
			if (!baraja.cartas[i].equals(cartasOriginales[i])) {
				diferenteOrden = true;
				break;
			}
		}

		assertTrue(diferenteOrden, "La baraja debería estar en diferente orden después de cortar");

		// Verificar que están todas las cartas
		boolean[] encontradas = new boolean[52];
		for (Carta cartaOriginal : cartasOriginales) {
			boolean encontrada = false;
			for (int i = 0; i < baraja.cartas.length; i++) {
				if (!encontradas[i] && cartaOriginal.equals(baraja.cartas[i])) {
					encontradas[i] = true;
					encontrada = true;
					break;
				}
			}
			assertTrue(encontrada, "Todas las cartas originales deben estar presentes");
		}
	}
}
