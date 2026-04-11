package org.mp.sesion03.arraydinamico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ArrayDinamicoObjectsTest {

    @Test
    public void testConstructor() {
        ArrayDinamicoObjects array = new ArrayDinamicoObjects();
        assertNotNull(array);
        assertEquals(0, array.capacidad());
    }

    @Test
    public void testAgregarYObtenerElemento() {
        ArrayDinamicoObjects array = new ArrayDinamicoObjects();
        array.agregar("Hola");
        array.agregar("Mundo");
        assertEquals("Hola", array.obtener(0));
        assertEquals("Mundo", array.obtener(1));
    }

    
    @Test
    public void testEliminarElemento() {
        ArrayDinamicoObjects array = new ArrayDinamicoObjects();
        array.agregar("Hola");
        array.agregar("Mundo");
        array.eliminar(0);
        assertEquals("Mundo", array.obtener(0));
        assertEquals(1, array.capacidad());
        try {
            array.eliminar(2);
            fail("Se esperaba una ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Se espera que lance esta excepción
        }
    }

    @Test
    public void testEstablecerElemento() {
        ArrayDinamicoObjects array = new ArrayDinamicoObjects();
        array.agregar("Hola");
        array.agregar("Mundo");
        array.establecer(1, "Java");
        assertEquals("Java", array.obtener(1));
    }

    @Test
    public void testCrecimientoDinamico() {
        ArrayDinamicoObjects array = new ArrayDinamicoObjects();
        for (int i = 0; i < 20; i++) {
            array.agregar("Elemento" + i);
        }
        assertEquals(20, array.capacidad());
    }

}
