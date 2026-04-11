package org.mp.sesion01.baraja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartaFrancesaTest {
	private CartaFrancesa cartaAs;
	private CartaFrancesa cartaRey;
	private CartaFrancesa cartaOtraAs;

	@BeforeEach
	public void setUp() {
		cartaAs = new CartaFrancesa(1, "Corazones");
		cartaRey = new CartaFrancesa(13, "Picas");
		cartaOtraAs = new CartaFrancesa(1, "Corazones");
	}

	@Test
	public void testConstructorValido() {
		assertEquals("1 de Corazones", cartaAs.toString());
		assertEquals("13 de Picas", cartaRey.toString());
	}

	@Test
	public void testNumeroDemasiadoBajo() {
		try {
			CartaFrancesa carta = new CartaFrancesa(0, "Corazones");
			fail("Debería haber lanzado IllegalArgumentException para número 0");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testNumeroDemasiadoAlto() {
		try {
			CartaFrancesa carta = new CartaFrancesa(14, "Corazones");
			fail("Debería haber lanzado IllegalArgumentException para número 14");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testPaloInvalido() {
		try {
			CartaFrancesa carta = new CartaFrancesa(1, "Oros");
			fail("Debería haber lanzado IllegalArgumentException para palo inválido");
		} catch (IllegalArgumentException e) {
			// Test exitoso
		}
	}

	@Test
	public void testCompareTo() {
		// Prueba comparación por número
		CartaFrancesa cartaDos = new CartaFrancesa(2, "Corazones");
		assertTrue(cartaAs.compareTo(cartaDos) < 0, "As debería ser menor que 2");
		assertTrue(cartaDos.compareTo(cartaAs) > 0, "2 debería ser mayor que As");

		// Prueba comparación de cartas iguales
		assertEquals(0, cartaAs.compareTo(cartaOtraAs), "Cartas iguales deberían retornar 0");

		// Prueba comparación por palo (mismo número)
		CartaFrancesa cartaAsTreboles = new CartaFrancesa(1, "Tréboles");
		assertTrue(cartaAsTreboles.compareTo(cartaAs) < 0, "Tréboles debería ser menor que Corazones");
	}

	@Test
	public void testEquals() {
		assertTrue(cartaAs.equals(cartaOtraAs), "Las mismas cartas deberían ser iguales");
		assertFalse(cartaAs.equals(cartaRey), "Cartas diferentes no deberían ser iguales");
		assertFalse(cartaAs.equals(null), "Comparación con null debería ser falsa");
		assertFalse(cartaAs.equals("No soy una carta"), "Comparación con otro tipo debería ser falsa");
	}
}