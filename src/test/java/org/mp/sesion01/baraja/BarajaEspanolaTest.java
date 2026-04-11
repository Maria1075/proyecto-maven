package org.mp.sesion01.baraja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarajaEspanolaTest {
	private BarajaEspanola baraja;

	@BeforeEach
	public void setUp() {
		baraja = new BarajaEspanola();
	}

	@Test
	public void testCrearBaraja() {
		assertEquals(40, baraja.cartas.length);

		// Verificar que hay 10 cartas de cada palo
		int oros = 0;
		int copas = 0;
		int espadas = 0;
		int bastos = 0;

		for (Carta carta : baraja.cartas) {
			switch (carta.palo) {
			case "Oros":
				oros++;
				break;
			case "Copas":
				copas++;
				break;
			case "Espadas":
				espadas++;
				break;
			case "Bastos":
				bastos++;
				break;
			}
		}

		assertEquals(10, oros);
		assertEquals(10, copas);
		assertEquals(10, espadas);
		assertEquals(10, bastos);
	}

	@Test
	public void testNoContiene8Y9() {
		for (Carta carta : baraja.cartas) {
			CartaEspanola cartaEsp = (CartaEspanola) carta;
			assertFalse(cartaEsp.numero == 8, "No debe contener el número 8");
			assertFalse(cartaEsp.numero == 9, "No debe contener el número 9");
		}
	}

	@Test
	public void testBarajar() {
		// Guardar el orden original
		Carta[] cartasOriginales = new Carta[40];
		System.arraycopy(baraja.cartas, 0, cartasOriginales, 0, 40);

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
		boolean[] encontradas = new boolean[40];
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
			CartaEspanola actual = (CartaEspanola) baraja.cartas[i];
			CartaEspanola anterior = (CartaEspanola) baraja.cartas[i - 1];
			assertTrue(actual.compareTo(anterior) >= 0, "Las cartas deben estar ordenadas");
		}
	}

	@Test
	public void testCortarBaraja() {
		// Guardar el orden original
		Carta[] cartasOriginales = new Carta[40];
		System.arraycopy(baraja.cartas, 0, cartasOriginales, 0, 40);

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
		boolean[] encontradas = new boolean[40];
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