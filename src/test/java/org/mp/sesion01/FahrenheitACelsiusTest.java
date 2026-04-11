package org.mp.sesion01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FahrenheitACelsiusTest {
    FahrenheitACelsius fahrenheitACelsius;

    @Test
    public void testConvertirTemperaturaAmbiente() throws TemperaturaBajoCeroKelvinException {
        fahrenheitACelsius = new FahrenheitACelsius();
        float celsius;
        float fahrenheit = 68;
        float celsiusEsperado = 20;
        
        celsius = fahrenheitACelsius.convertir(fahrenheit);
        assertEquals(celsiusEsperado, celsius);
    }

    @Test
    public void testConvertirPuntoCongelacion() throws TemperaturaBajoCeroKelvinException {
        fahrenheitACelsius = new FahrenheitACelsius();
        float celsius;
        float fahrenheit = 32;
        float celsiusEsperado = 0;
        
        celsius = fahrenheitACelsius.convertir(fahrenheit);
        assertEquals(celsiusEsperado, celsius);
    }

    @Test
    public void testConvertirPuntoEbullicion() throws TemperaturaBajoCeroKelvinException {
        fahrenheitACelsius = new FahrenheitACelsius();
        float celsius;
        float fahrenheit = 212;
        float celsiusEsperado = 100;
        
        celsius = fahrenheitACelsius.convertir(fahrenheit);
        assertEquals(celsiusEsperado, celsius);
    }

    @Test
    public void testConvertirTemperaturaNegativa() throws TemperaturaBajoCeroKelvinException {
        fahrenheitACelsius = new FahrenheitACelsius();
        float celsius;
        float fahrenheit = -40;
        float celsiusEsperado = -40;
        
        celsius = fahrenheitACelsius.convertir(fahrenheit);
        assertEquals(celsiusEsperado, celsius);
    }

    @Test
    public void testConvertirCeroAbsoluto() throws TemperaturaBajoCeroKelvinException {
        fahrenheitACelsius = new FahrenheitACelsius();
        float celsius;
        float fahrenheit = -459.67f;
        float celsiusEsperado = -273.15f;
        
        celsius = fahrenheitACelsius.convertir(fahrenheit);
        assertEquals(celsiusEsperado, celsius);
    }

    @Test
    public void testConvertirTemperaturaAlta() throws TemperaturaBajoCeroKelvinException {
        fahrenheitACelsius = new FahrenheitACelsius();
        float celsius;
        float fahrenheit = 1000;
        float celsiusEsperado = 537.78f;
        
        celsius = fahrenheitACelsius.convertir(fahrenheit);
        assertEquals(celsiusEsperado, celsius);
    }

    @Test
    public void testConvertirBajoCeroAbsoluto() {
        fahrenheitACelsius = new FahrenheitACelsius();
        float fahrenheit = -500;
        
        try {
            fahrenheitACelsius.convertir(fahrenheit);
            fail("Se esperaba una excepción TemperaturaBajoCeroKelvinException");
        } catch (TemperaturaBajoCeroKelvinException excepcion) {
            assertEquals("¡La temperatura no puede estar por debajo de 0 K!", excepcion.getMessage());
        }
    }
}