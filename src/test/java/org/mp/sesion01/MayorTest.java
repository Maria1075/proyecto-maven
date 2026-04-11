package org.mp.sesion01;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MayorTest {

    @Test
    @Order(1) 
    public void testElEnteroMayorConArrayPositivo() {
        int[] array = { 3, 7, 1, 9, 4 };
        int resultado = Mayor.elEnteroMayor(array);
        assertEquals(9, resultado);
    }

    @Test
    @Order(2) 
    public void testElEnteroMayorConArrayNegativo() {
        int[] array = { -5, -2, -8, -1, -3 };
        int resultado = Mayor.elEnteroMayor(array);
        assertEquals(-1, resultado);
    }

    @Test
    @Order(4) 
    public void testElEnteroMayorConArrayConRepetidos() {
        int[] array = { 2, 8, 5, 2, 8, 1, 5 };
        int resultado = Mayor.elEnteroMayor(array);
        assertEquals(8, resultado);
    }
    
    @Test
    @Order(5) 
    public void testElEnteroMayorConArrayConUnSoloElemento() {
        int[] array = { 42 };
        int resultado = Mayor.elEnteroMayor(array);
        assertEquals(42, resultado);
    }

       
    @Test
	@Order(6)
	public void testElEnteroMayorConArrayVacio() {
		try {
			Mayor.elEnteroMayor(new int[] {});
			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "Array vacio");
			
		}
	}
}
