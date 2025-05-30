package estructuras.pila;

import cartas.Carta;

/**
 * Implementa una estructura tipo Pila para manejar cartas.
 * Sigue el comportamiento LIFO (último en entrar, primero en salir).
 */

public class PilaCartas {
    private NodoPila tope;

    public PilaCartas() {
        this.tope = null;
    }

    public void apilar(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Carta desapilar() {
        if (estaVacia())
            return null;
        Carta carta = tope.carta;
        tope = tope.siguiente;
        return carta;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void mostrarHistorial() {
        NodoPila actual = tope;
        System.out.println("Historial de cartas jugadas:");
        while (actual != null) {
            System.out.println("  " + actual.carta);
            actual = actual.siguiente;
        }
    }
}
