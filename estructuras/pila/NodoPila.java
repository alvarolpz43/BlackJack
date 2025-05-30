package estructuras.pila;

import cartas.Carta;

/**
 * Representa un nodo dentro de una pila de cartas.
 * Cada nodo contiene una carta y un enlace al nodo siguiente (debajo en la
 * pila).
 */

public class NodoPila {
    public Carta carta;
    public NodoPila siguiente;

    public NodoPila(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }
}
