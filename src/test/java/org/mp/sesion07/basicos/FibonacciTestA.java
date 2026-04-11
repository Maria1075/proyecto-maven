package org.mp.sesion07.basicos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class FibonacciTestA {

    @Test
    public void testFibonacci() {
        assertEquals(0, Fibonacci.fibonacciRec(0));
        assertEquals(1, Fibonacci.fibonacciRec(1));
        assertEquals(1, Fibonacci.fibonacciRec(2));
        assertEquals(2, Fibonacci.fibonacciRec(3));
        assertEquals(8, Fibonacci.fibonacciRec(6));
        assertEquals(Fibonacci.fibonacciIter(0), Fibonacci.fibonacciRec(0));
        assertEquals(Fibonacci.fibonacciIter(1), Fibonacci.fibonacciRec(1));
        assertEquals(Fibonacci.fibonacciIter(2), Fibonacci.fibonacciRec(2));
        assertEquals(Fibonacci.fibonacciIter(3), Fibonacci.fibonacciRec(3));
        assertEquals(Fibonacci.fibonacciIter(4), Fibonacci.fibonacciRec(4));
        assertEquals(Fibonacci.fibonacciIter(5), Fibonacci.fibonacciRec(5));
        assertEquals(Fibonacci.fibonacciIter(12), Fibonacci.fibonacciRec(12));
    }
    
    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testFibonacciTimeout() {
        // Prueba que toma más de 10 segundos para números grandes
        long result = Fibonacci.fibonacciRec(45);
        assertEquals(1134903170, result);
    }
}

