// ColaTurnos.java
public class ColaTurnos {
    private NodoCola frente;
    private NodoCola fin;

    public ColaTurnos() {
        this.frente = this.fin = null;
    }

    public void encolar(String jugador) {
        NodoCola nuevo = new NodoCola(jugador);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public String desencolar() {
        if (frente == null) return null;
        String jugador = frente.jugador;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return jugador;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
