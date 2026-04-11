package org.mp.sesion07.comparator;

/**
 * Clase que representa una carta de la baraja española.
 * Implementa la interfaz Comparable para permitir ordenación por número y palo.
 *
 * Autor: Maria Camila Soto Zapata
 * Año: 2025
 */
public class Carta implements Comparable<Carta> {

    private String palo;
    private int numero;

    /**
     * Constructor de la clase Carta.
     *
     * @param palo   Palo de la carta (O: Oros, C: Copas, E: Espadas, B: Bastos)
     * @param numero Número de la carta (del 1 al 12, excluyendo 8 y 9)
     */
    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    /**
     * Devuelve una representación en texto de la carta.
     *
     * @return Cadena con el formato: Carta [palo=..., numero=...]
     */
    public String toString() {
        String salida = "Carta [palo=" + this.palo + ", numero=" + this.numero + "]";
        return salida;
    }

    /**
     * Devuelve el palo de la carta.
     *
     * @return Palo de la carta
     */
    public String getPalo() {
        return palo;
    }

    /**
     * Devuelve el número de la carta.
     *
     * @return Número de la carta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Compara esta carta con otra según su número y, si son iguales, por orden de palo.
     *
     * @param c2 Carta con la que se desea comparar
     * @return 1 si es mayor, -1 si es menor, 0 si son iguales
     */
    @Override
    public int compareTo(Carta c2) {
        if (getNumero() > c2.getNumero())
            return 1;
        else if (getNumero() < c2.getNumero())
            return -1;
        else {
            String[] ordenPalos = {"O", "C", "E", "B"};
            int indiceC1 = 0, indiceC2 = 0;

            for (int i = 0; i < ordenPalos.length; i++) {
                if (getPalo().equals(ordenPalos[i]))
                    indiceC1 = i;
                if (c2.getPalo().equals(ordenPalos[i]))
                    indiceC2 = i;
            }

            if (indiceC1 > indiceC2)
                return 1;
            else if (indiceC1 < indiceC2)
                return -1;
            else
                return 0;
        }
    }

    /**
     * Comprueba si una carta es igual a otra (mismo número y palo).
     *
     * @param otraCarta Objeto a comparar
     * @return true si son iguales, false si no
     */
    public boolean equals(Object otraCarta) {
        if (this == otraCarta)
            return true;
        if (otraCarta == null || getClass() != otraCarta.getClass())
            return false;
        Carta carta = (Carta) otraCarta;
        return numero == carta.numero && palo.equals(carta.palo);
    }
}
