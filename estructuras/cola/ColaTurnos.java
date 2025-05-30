package estructuras.cola;

// ColaTurnos.java
public class ColaTurnos {
    private NodoCola frente;
    private NodoCola fin;

    // Constructor
    public ColaTurnos() {
        this.frente = this.fin = null;
    }

    // Métodos
    // Agrega un jugador al final de la cola
    public void encolar(String jugador) {
        NodoCola nuevo = new NodoCola(jugador);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Quita y devuelve el jugador al frente de la cola
    public String desencolar() {
        if (frente == null)
            return null;
        String jugador = frente.jugador;
        frente = frente.siguiente;
        if (frente == null)
            fin = null;
        return jugador;
    }

    // Retorna true si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }
}
