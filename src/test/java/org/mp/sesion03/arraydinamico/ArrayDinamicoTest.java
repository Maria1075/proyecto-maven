package org.mp.sesion03.arraydinamico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ArrayDinamicoTest {

    @Test
    public void testConstructor() {
        ArrayDinamico<Integer> array = new ArrayDinamico<>();
        assertNotNull(array);
        assertEquals(0, array.capacidad());
    }

    @Test
    public void testAgregarYObtenerElemento() {
        ArrayDinamico<Integer> array = new ArrayDinamico<>();
        array.agregar(10);
        array.agregar(20);
        assertEquals(10, (int) array.obtener(0));
        assertEquals(20, (int) array.obtener(1));
        try {
            array.eliminar(2);
            fail("Se esperaba una ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Se espera que lance esta excepción
        }
    }

    @Test
    public void testEliminarElemento() {
        ArrayDinamico<Integer> array = new ArrayDinamico<>();
        array.agregar(10);
        array.agregar(20);
        array.eliminar(0);
        assertEquals(20, (int) array.obtener(0));
        assertEquals(1, array.capacidad());
    }

    @Test
    public void testEstablecerElemento() {
        ArrayDinamico<String> array = new ArrayDinamico<>();
        array.agregar("Hola");
        array.agregar("Mundo");
        array.establecer(1, "Java");
        assertEquals("Java", array.obtener(1));
    }

    @Test
    public void testCrecimientoDinamico() {
        ArrayDinamico<Integer> array = new ArrayDinamico<>();
        for (int i = 0; i < 20; i++) {
            array.agregar(i);
        }
        assertEquals(20, array.capacidad());
    }

}
