

package estructuras.hash;
// NodoHashJugador.java

import estructuras.jugadores.Jugador;;;

public class NodoHashJugador {
    public String clave;
    public Jugador jugador;
    public NodoHashJugador siguiente;

    public NodoHashJugador(String clave, Jugador jugador) {
        this.clave = clave;
        this.jugador = jugador;
        this.siguiente = null;
    }
}
