/**
 * Comparador que ordena cartas primero por número y luego por palo en el orden: O, C, E, B.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */

package org.mp.sesion07.comparator;

import java.util.Comparator;

public class NumeroPaloComparator implements Comparator<Carta> {
    
    /**
     * Compara dos cartas primero por su número, y si son iguales, por el orden del palo.
     *
     * @param c1 Primera carta a comparar
     * @param c2 Segunda carta a comparar
     * @return un número negativo, cero o positivo según si c1 es menor, igual o mayor que c2
     */
    @Override
    public int compare(Carta c1, Carta c2) {
        // Primero comparamos por número
        if (c1.getNumero() > c2.getNumero()) {
            return 1;
        } else if (c1.getNumero() < c2.getNumero()) {
            return -1;
        } else {
            // Si los números son iguales, comparamos por palo
            String[] ordenPalos = {"O", "C", "E", "B"};
            int indiceC1 = -1;
            int indiceC2 = -1;

            for (int i = 0; i < ordenPalos.length; i++) {
                if (c1.getPalo().equals(ordenPalos[i])) {
                    indiceC1 = i;
                }
                if (c2.getPalo().equals(ordenPalos[i])) {
                    indiceC2 = i;
                }
            }

            if (indiceC1 > indiceC2) {
                return 1;
            } else if (indiceC1 < indiceC2) {
                return -1;
            } else {
                return -1;
            }
        }
    }
}
