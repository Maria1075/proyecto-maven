package org.mp.sesion04.list;

import java.util.Random;

import org.mp.sesion04.list.arraylist.ArrayList;
import org.mp.sesion04.list.linkedlist.LinkedList;
import org.mp.sesion04.list.List;
/**
 * {@code EvaluadorRendimientoListas}: Evalúa el rendimiento de las implementaciones
 * {@link ArrayList} y {@link LinkedList} de la interfaz {@link List} para diversas
 * operaciones, midiendo el tiempo promedio de ejecución.
 */
public class EvaluadorRendimientoListas {
    private static final int[] TAMANIOS_LISTA = {10000, 20000, 40000};
    private static final int NUMERO_OPERACIONES = 100;
    /**
     * Método principal que inicia la evaluación de rendimiento de las listas.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        evaluarRendimiento();
    }
    /**
     * Realiza la evaluación de rendimiento para {@link ArrayList} y {@link LinkedList}
     * para diferentes tamaños de lista y varias operaciones. Imprime los resultados
     * del tiempo promedio de ejecución para cada operación y tamaño de lista.
     */
    private static void evaluarRendimiento() {
        System.out.println("Evaluación de Rendimiento de ArrayList y LinkedList");
        System.out.println("org.mp.sesion04.list.arraylist.ArrayList");
        System.out.println("org.mp.sesion04.list.arraylist.LinkedList");       
        System.out.println("===================================================");

        for (int tamanio : TAMANIOS_LISTA) {
            System.out.println("\nTamaño de la lista: " + tamanio);
            System.out.println("Operación\t\tArrayList (ns)\tLinkedList (ns)");

            double[] tiemposPromedioArrayList = new double[6];
            double[] tiemposPromedioLinkedList = new double[6];

            for (int i = 0; i < NUMERO_OPERACIONES; i++) {
                long[] tiemposArrayList = realizarOperaciones(new ArrayList<>(), tamanio);
                long[] tiemposLinkedList = realizarOperaciones(new LinkedList<>(), tamanio);

                for (int j = 0; j < tiemposArrayList.length; j++) {
                    tiemposPromedioArrayList[j] += tiemposArrayList[j];
                    tiemposPromedioLinkedList[j] += tiemposLinkedList[j];
                }
            }

            for (int j = 0; j < tiemposPromedioArrayList.length; j++) {
                tiemposPromedioArrayList[j] /= NUMERO_OPERACIONES;
                tiemposPromedioLinkedList[j] /= NUMERO_OPERACIONES;
                imprimirResultados(getNombreOperacion(j), tiemposPromedioArrayList[j], tiemposPromedioLinkedList[j]);
            }
        }
    }
    /**
     * Devuelve el nombre legible de una operación basándose en su índice.
     * @param indice El índice de la operación.
     * @return El nombre de la operación.
     */
    private static String getNombreOperacion(int indice) {
        switch (indice) {
            case 0:
                return "Agregar al principio";
            case 1:
                return "Agregar al final";
            case 2:
                return "Acceder aleatorio";
            case 3:
                return "Eliminar del principio";
            case 4:
                return "Eliminar del final";
            case 5:
                return "Eliminar aleatorio";
            default:
                return "";
        }
    }
    /**
     * Realiza una serie de operaciones (agregar al principio, al final, acceder aleatorio,
     * eliminar del principio, del final y aleatorio) en una lista dada y mide el tiempo
     * total de ejecución para cada tipo de operación.
     *
     * @param lista La lista en la que se realizarán las operaciones.
     * @param tamanio El tamaño inicial con el que se llenará la lista.
     * @return Un array de longs donde cada elemento representa el tiempo total (en nanosegundos)
     * para un tipo de operación específica.
     */
    private static long[] realizarOperaciones(List<Integer> lista, int tamanio) {
        long[] tiempos = new long[6];
        Random random = new Random();

        // Llenar la lista con valores aleatorios
        for (int i = 0; i < tamanio; i++) {
            lista.add(random.nextInt());
        }

        for (int i = 0; i < NUMERO_OPERACIONES; i++) {
            tiempos[0] += agregarAlPrincipio(lista);
            tiempos[1] += agregarAlFinal(lista);
            tiempos[2] += accederAleatorio(lista, random);
            tiempos[3] += eliminarDelPrincipio(lista);
            tiempos[4] += eliminarDelFinal(lista);
            tiempos[5] += eliminarAleatorio(lista, random);
        }

        return tiempos;
    }
    /**
     * Mide el tiempo que tarda en agregar un elemento al principio de la lista.
     * @param lista La lista en la que se realizará la operación.
     * @return El tiempo transcurrido en nanosegundos.
     */
    private static long agregarAlPrincipio(List<Integer> lista) {
        long tiempoInicio = System.nanoTime();
        lista.add(0, 0);
        return System.nanoTime() - tiempoInicio;
    }
    /**
     * Mide el tiempo que tarda en agregar un elemento al final de la lista.
     * @param lista La lista en la que se realizará la operación.
     * @return El tiempo transcurrido en nanosegundos.
     */
    private static long agregarAlFinal(List<Integer> lista) {
    	long tiempoInicio = System.nanoTime();
        lista.add(lista.size(), 0);
        return System.nanoTime() - tiempoInicio;
    }
    /**
     * Mide el tiempo que tarda en acceder a un elemento en una posición aleatoria de la lista.
     * @param lista La lista en la que se realizará la operación.
     * @param random Generador de números aleatorios para seleccionar la posición.
     * @return El tiempo transcurrido en nanosegundos.
     */
    private static long accederAleatorio(List<Integer> lista, Random random) {
    	int pos = random.nextInt(0, lista.size());
    	long tiempoInicio = System.nanoTime();
        lista.get(pos);
        return System.nanoTime() - tiempoInicio;
    }
    /**
     * Mide el tiempo que tarda en eliminar el primer elemento de la lista.
     * @param lista La lista en la que se realizará la operación.
     * @return El tiempo transcurrido en nanosegundos.
     */
    private static long eliminarDelPrincipio(List<Integer> lista) {
    	long tiempoInicio = System.nanoTime();
        lista.remove(0);
        return System.nanoTime() - tiempoInicio;
    }
    /**
     * Mide el tiempo que tarda en eliminar el último elemento de la lista.
     * @param lista La lista en la que se realizará la operación.
     * @return El tiempo transcurrido en nanosegundos.
     */
    private static long eliminarDelFinal(List<Integer> lista) {
    	long tiempoInicio = System.nanoTime();
        lista.remove(lista.size()-1);
        return System.nanoTime() - tiempoInicio;
    }
    /**
     * Mide el tiempo que tarda en eliminar un elemento en una posición aleatoria de la lista.
     * @param lista La lista en la que se realizará la operación.
     * @param random Generador de números aleatorios para seleccionar la posición.
     * @return El tiempo transcurrido en nanosegundos.
     */
    private static long eliminarAleatorio(List<Integer> lista, Random random) {
    	int pos = random.nextInt(0, lista.size());
    	long tiempoInicio = System.nanoTime();
        lista.remove(pos);
        return System.nanoTime() - tiempoInicio;
    }
    /**
     * Imprime los resultados de rendimiento para una operación específica, mostrando
     * el tiempo promedio de ejecución para {@link ArrayList} y {@link LinkedList}.
     *
     * @param operacion El nombre de la operación evaluada.
     * @param tiempoPromedioArrayList El tiempo promedio de ejecución para {@link ArrayList} (en nanosegundos).
     * @param tiempoPromedioLinkedList El tiempo promedio de ejecución para {@link LinkedList} (en nanosegundos).
     */
    private static void imprimirResultados(String operacion, double tiempoPromedioArrayList, double tiempoPromedioLinkedList) {
        System.out.printf("%-22s\t%,15.0f\t%,15.0f%n", operacion, tiempoPromedioArrayList, tiempoPromedioLinkedList);
    }
}
