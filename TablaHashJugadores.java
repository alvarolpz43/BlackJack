// TablaHashJugadores.java

public class TablaHashJugadores {
    private NodoHashJugador[] tabla;
    private int capacidad;

    public TablaHashJugadores(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new NodoHashJugador[capacidad];
    }

    private int hash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash += clave.charAt(i);
        }
        return hash % capacidad;
    }

    public void insertar(String clave, Jugador jugador) {
        int indice = hash(clave);
        NodoHashJugador nuevo = new NodoHashJugador(clave, jugador);

        if (tabla[indice] == null) {
            tabla[indice] = nuevo;
        } else {
            NodoHashJugador actual = tabla[indice];
            while (actual.siguiente != null) {
                if (actual.clave.equals(clave)) {
                    actual.jugador = jugador;
                    return;
                }
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public Jugador obtener(String clave) {
        int indice = hash(clave);
        NodoHashJugador actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.jugador;
            }
            actual = actual.siguiente;
        }

        return null;
    }
}
