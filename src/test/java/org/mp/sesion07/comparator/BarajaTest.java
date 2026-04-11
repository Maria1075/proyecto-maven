package org.mp.sesion07.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;


public class BarajaTest {
	
	Carta carta;
	Baraja baraja;
	Carta[] cartasNP;


	@BeforeEach
	public void setUp() throws Exception {
		
		Carta[] cartas = new Carta[40];
		String[] palos = { "O", "C", "E", "B" };

		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
			for (int i = 10; i < 13; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
		}

		baraja = new Baraja("Española", cartas);

		cartasNP = new Carta[40];

		j=0;
		for (int i = 1; i < 8; i++) {
			for (int k = 0; k < palos.length; k++) {
				carta = new Carta(palos[k], i);
				cartasNP[j] = carta;
				j++;
			}
		}
		for (int i = 10; i < 13; i++) {
			for (int k = 0; k < palos.length; k++) {
				carta = new Carta(palos[k], i);
				cartasNP[j] = carta;
				j++;
			}
		}

	}

	@Test
	public void testOrdenarBarajaSort() {

		Carta[] cartas = baraja.getCartas();

		Arrays.sort(cartas);

		for (int i = 0; i < cartas.length - 1; i++) {
			//System.out.println(cartas[i]);
			assertEquals(-1, cartas[i].compareTo(cartas[i + 1]));
		}

	}

	@Test
	public void testOrdenarBarajaSortNumeroPaloComparator() {

		Carta[] cartas = baraja.getCartas();

		Arrays.sort(cartas, new NumeroPaloComparator());

		for (int i = 0; i < cartas.length ; i++) {
			//System.out.println(cartas[i]);
			assertTrue(cartas[i].equals(cartasNP[i]));
		}
	}

	@Test
	public void testOrdenarBarajaSortReverseOrder() {

		Carta[] cartas = baraja.getCartas();

		java.util.Arrays.sort(cartas, java.util.Collections.reverseOrder());

		for (int i = 0; i < cartas.length - 1; i++) {
			//System.out.println(cartas[i]);
			assertEquals(1, cartas[i].compareTo(cartas[i + 1]));
		}

	}

	@Test
	public void testOrdenarBarajaSortNumeroPaloComparatorReverseOrder() {

		Carta[] cartas = baraja.getCartas();

		Arrays.sort(cartas, Collections.reverseOrder(new NumeroPaloComparator()));

		for (int i = 0; i < cartas.length ; i++) {
			//System.out.println(cartas[i]);
			assertTrue(cartas[i].equals(cartasNP[cartas.length - 1 - i]));
		}

	}
	
	
}
