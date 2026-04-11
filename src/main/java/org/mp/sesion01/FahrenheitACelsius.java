/*
 * @author Maria Camila Soto Zapata
 * @sinse 2025
 */
package org.mp.sesion01;

/**
 * La clase FahrenheitACelsius proporciona un metodo para convertir temperaturas de Fahrenheit a Celsius.
 *
 * Esta clase es util para realizar conversiones de temperatura entre las escalas Fahrenheit y Celsius.
 * Ademas, maneja la restriccion de que la temperatura no puede estar por debajo del cero absoluto (-459.67 °F).
 */
public class FahrenheitACelsius {

    /**
     * Convierte una temperatura de Fahrenheit a Celsius.
     *
     * Este metodo toma una temperatura en grados Fahrenheit como entrada y devuelve la temperatura
     * equivalente en grados Celsius.
     *
     * @param fahrenheit La temperatura en grados Fahrenheit a convertir.
     * @return La temperatura equivalente en grados Celsius.
     * @throws TemperaturaBajoCeroKelvinException Si la temperatura Fahrenheit está por debajo del cero absoluto.
     *
     * Ejemplo de uso:
     * FahrenheitACelsius conversor = new FahrenheitACelsius();
     * float celsius = conversor.convertir(68); // celsius será 20.0
     */
    public float convertir (float fahrenheit) throws TemperaturaBajoCeroKelvinException {
        // Verifica si la temperatura Fahrenheit esta por debajo del cero absoluto
        if (fahrenheit < -459.67f) {
            // Lanza una excepcion si la temperatura esta por debajo del cero absoluto
            throw new TemperaturaBajoCeroKelvinException("¡La temperatura no puede estar por debajo de 0 K!");
        }

        // Realiza la conversion de Fahrenheit a Celsius usando la formula: (ºF - 32) * 5/9
        float celsius = (fahrenheit - 32) * (5f / 9f);

        // Redondea el resultado a dos decimales
        celsius = Math.round(celsius * 100) / 100.0f;

        // Devuelve la temperatura en grados Celsius
        return celsius;
    }
}