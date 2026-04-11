package org.mp.sesion07.busqueda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolucionesBusquedaTest {

    private Busqueda<Integer> busqueda;

    @BeforeEach
    void setUp() {
        busqueda = new Busqueda<>(10);
    }

    @Test
    void testBusquedaLineal() throws ElementoNoEncontradoException {
        int posicionEsperada = Arrays.binarySearch(busqueda.getDatos(), busqueda.getNumBuscado());
        int posicionEncontrada = SolucionesBusqueda.busquedaLineal(busqueda);
        assertEquals(posicionEsperada, posicionEncontrada);
    }

    @Test
    void testBusquedaBinariaIter() throws ElementoNoEncontradoException {
        int posicionEsperada = Arrays.binarySearch(busqueda.getDatos(), busqueda.getNumBuscado());
        int posicionEncontrada = SolucionesBusqueda.busquedaBinariaIter(busqueda);
        assertEquals(posicionEsperada, posicionEncontrada);
    }

    @Test
    void testBusquedaBinariaRec() throws ElementoNoEncontradoException {
        int posicionEsperada = Arrays.binarySearch(busqueda.getDatos(), busqueda.getNumBuscado());
        int posicionEncontrada = SolucionesBusqueda.busquedaBinariaRec(busqueda);
        assertEquals(posicionEsperada, posicionEncontrada);
    }

    @Test
    void testBusquedaArraysBinarySearch() {
        int posicionEsperada = Arrays.binarySearch(busqueda.getDatos(), busqueda.getNumBuscado());
        int posicionEncontrada = SolucionesBusqueda.busquedaArraysBinarySearch(busqueda);
        assertEquals(posicionEsperada, posicionEncontrada);
    }
    
    @Test
    void testBusquedaLineal_ElementoNoEncontrado() {
        busqueda.setNumBuscado(-1); // Establecer un número que no está en los datos
        try {
            SolucionesBusqueda.busquedaLineal(busqueda);
            fail("Se esperaba ElementoNoEncontradoException");
        } catch (ElementoNoEncontradoException e) {
            assertTrue(true); // La excepción era esperada
        }
    }
    
    @Test
    void testBusquedaBinariaIter_ElementoNoEncontrado() {
        busqueda.setNumBuscado(-1); // Establecer un número que no está en los datos
        try {
            SolucionesBusqueda.busquedaBinariaIter(busqueda);
            fail("Se esperaba ElementoNoEncontradoException");
        } catch (ElementoNoEncontradoException e) {
            assertTrue(true); // La excepción era esperada
        }
    }
    
    @Test
    void testBusquedaBinariaRec_ElementoNoEncontrado() {
        busqueda.setNumBuscado(-1); // Establecer un número que no está en los datos
        try {
            SolucionesBusqueda.busquedaBinariaRec(busqueda);
            fail("Se esperaba ElementoNoEncontradoException");
        } catch (ElementoNoEncontradoException e) {
            assertTrue(true); // La excepción era esperada
        }
    }
  

}