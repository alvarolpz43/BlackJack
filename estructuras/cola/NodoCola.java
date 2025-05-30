package estructuras.cola;
// NodoCola.java
public class NodoCola {
    public String jugador;
    public NodoCola siguiente;

    public NodoCola(String jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}
