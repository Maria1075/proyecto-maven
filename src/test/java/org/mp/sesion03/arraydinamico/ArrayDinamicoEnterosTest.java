package org.mp.sesion03.arraydinamico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ArrayDinamicoEnterosTest {

	@Test
	public void testConstructor() {
		ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
		assertNotNull(array);
		assertEquals(0, array.capacidad());
	}

	@Test
	public void testAgregarYObtenerElemento() {
		ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
		array.agregar(10);
		array.agregar(20);
		assertEquals(10, array.obtener(0));
		assertEquals(20, array.obtener(1));
	}

	public void testEliminarElemento() {
		ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
		array.agregar(10);
		array.agregar(20);
		array.eliminar(0);
		assertEquals(20, array.obtener(0));
		assertEquals(1, array.capacidad());
		try {
			array.eliminar(2);
			fail("Se esperaba que se lanzara una ArrayIndexOutOfBoundsException");
		} catch (ArrayIndexOutOfBoundsException e) {
			// pasa Test 
		}
	}

	@Test
	public void testEstablecerElemento() {
		ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
		array.agregar(10);
		array.agregar(20);
		array.establecer(1, 30);
		assertEquals(30, array.obtener(1));
	}

	@Test
	public void testCrecimientoDinamico() {
		ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
		for (int i = 0; i < 20; i++) {
			array.agregar(i);
		}
		assertEquals(20, array.capacidad());
	}

}
