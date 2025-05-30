package estructuras.hash;

import estructuras.jugadores.Jugador;

public class TablaHashJugadores {
    private NodoHashJugador[] tabla; // Array para almacenar listas enlazadas
    private int capacidad; // Tamaño de la tabla hash

    public TablaHashJugadores(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new NodoHashJugador[capacidad]; // Inicializa la tabla con la capacidad dada
    }

    // Función hash simple basada en suma de caracteres
    private int hash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash += clave.charAt(i);
        }
        return hash % capacidad; // Retorna índice válido dentro de la tabla
    }

    // Inserta un jugador usando su clave
    public void insertar(String clave, Jugador jugador) {
        int indice = hash(clave);
        NodoHashJugador nuevo = new NodoHashJugador(clave, jugador);

        if (tabla[indice] == null) {
            tabla[indice] = nuevo; // Inserta si la posición está vacía
        } else {
            NodoHashJugador actual = tabla[indice];
            while (actual.siguiente != null) {
                if (actual.clave.equals(clave)) {
                    actual.jugador = jugador; // Actualiza si la clave ya existe
                    return;
                }
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo; // Agrega al final de la lista enlazada
        }
    }

    // Obtiene un jugador por su clave
    public Jugador obtener(String clave) {
        int indice = hash(clave);
        NodoHashJugador actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.jugador; // Devuelve el jugador encontrado
            }
            actual = actual.siguiente;
        }

        return null; // No se encontró la clave
    }
}
