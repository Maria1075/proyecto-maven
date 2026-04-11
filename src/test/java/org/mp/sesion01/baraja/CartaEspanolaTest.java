package org.mp.sesion01.baraja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartaEspanolaTest {
	private CartaEspanola cartaAs;
	private CartaEspanola cartaRey;
	private CartaEspanola cartaOtraAs;
	private CartaEspanola cartaAsCopas;

	@BeforeEach
	public void setUp() {
		cartaAs = new CartaEspanola(1, "Oros");
		cartaRey = new CartaEspanola(12, "Bastos");
		cartaOtraAs = new CartaEspanola(1, "Oros");
		cartaAsCopas = new CartaEspanola(1, "Copas");
	}

	@Test
	public void testConstructorValido() {
		assertEquals(cartaAs.toString(), "As de Oros");
		assertEquals(cartaRey.toString(), "Rey de Bastos");
	}

	@Test
	public void testCompareTo() {
		// Prueba comparación por palo primero
		assertTrue(cartaAs.compareTo(cartaAsCopas) < 0, "Oros debería ser menor que Copas");

		// Prueba comparación por número (mismo palo)
		CartaEspanola cartaDosOros = new CartaEspanola(2, "Oros");
		assertTrue(cartaAs.compareTo(cartaDosOros) < 0, "As debería ser menor que 2");

		cartaOtraAs = new CartaEspanola(1, "Oros");
		// Prueba comparación de cartas iguales
		assertEquals(0, cartaAs.compareTo(cartaOtraAs), "Cartas iguales deberían retornar 0");
	}

	@Test
	public void testNumeroDemasiadoBajo() {
		try {
			CartaEspanola carta = new CartaEspanola(0, "Oros");
			fail("Debería haber lanzado IllegalArgumentException para número 0");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testNumeroDemasiadoAlto() {
		try {
			CartaEspanola carta = new CartaEspanola(13, "Oros");
			fail("Debería haber lanzado IllegalArgumentException para número 13");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testNumeroOcho() {
		try {
			CartaEspanola carta = new CartaEspanola(8, "Oros");
			fail("Debería haber lanzado IllegalArgumentException para número 8");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testNumeroNueve() {
		try {
			CartaEspanola carta = new CartaEspanola(9, "Oros");
			fail("Debería haber lanzado IllegalArgumentException para número 9");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testPaloInvalido() {
		try {
			CartaEspanola carta = new CartaEspanola(1, "Corazones");
			fail("Debería haber lanzado IllegalArgumentException para palo inválido");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testNombresFiguras() {
		CartaEspanola sota = new CartaEspanola(10, "Oros");
		CartaEspanola caballo = new CartaEspanola(11, "Oros");
		CartaEspanola rey = new CartaEspanola(12, "Oros");

		assertEquals("Sota de Oros", sota.toString());
		assertEquals("Caballo de Oros", caballo.toString());
		assertEquals("Rey de Oros", rey.toString());
	}

	@Test
	public void testEquals() {
		assertTrue(cartaAs.equals(cartaOtraAs), "Las mismas cartas deberían ser iguales");
		assertFalse(cartaAs.equals(cartaRey), "Cartas diferentes no deberían ser iguales");
		assertFalse(cartaAs.equals(null), "Comparación con null debería ser falsa");
		assertFalse(cartaAs.equals("No soy una carta"), "Comparación con otro tipo debería ser falsa");
	}
}
