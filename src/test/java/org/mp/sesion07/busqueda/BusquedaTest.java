package org.mp.sesion07.busqueda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BusquedaTest {
    private Busqueda<Integer> busqueda;
    private Comparable[] datos; // Cambiar a Comparable[]

    @BeforeEach
    public void setUp() {
        busqueda = new Busqueda<>(10); // Crear una instancia con 10 elementos
        datos = busqueda.getDatos(); // Ahora es Comparable[]
    }

    @Test
    public void testNumElementos() {
        assertEquals(10, busqueda.getNumElementos());
    }

    @Test
    public void testGenerarDatosAleatorios() {
        assertNotNull(datos);
        assertEquals(10, datos.length);
    }

    @Test
    public void testOrdenDatos() {
        for (int i = 1; i < datos.length; i++) {
            assertTrue(datos[i - 1].compareTo(datos[i]) <= 0); // Verificar que los datos estén ordenados
        }
    }

    @Test
    public void testNumBuscadoEnDatos() {
        Integer numBuscado = busqueda.getNumBuscado();
        boolean encontrado = false;
        for (Comparable dato : datos) {
            if (dato.equals(numBuscado)) {
                encontrado = true;
                break;
            }
        }
        assertTrue(encontrado);
    }

    @Test
    public void testSetNumBuscado() {
        busqueda.setNumBuscado(50); // Cambiar el número buscado
        assertEquals(Integer.valueOf(50), busqueda.getNumBuscado());
    }
    @Test
    public void testToString() {
        StringBuilder expected = new StringBuilder();
        expected.append("Problema búsqueda con ").append(busqueda.getNumElementos()).append(" elementos\n");
        expected.append("Elemento buscado: ").append(busqueda.getNumBuscado()).append("\n");
        expected.append("[");
        for (int i = 0; i < datos.length; i++) {
            expected.append(datos[i]);
            if (i < datos.length - 1) {
                expected.append(", ");
            }
        }
        expected.append("]");
        assertEquals(expected.toString(), busqueda.toString());
    }
}
