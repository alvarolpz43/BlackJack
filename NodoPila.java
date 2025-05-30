// NodoPila.java
public class NodoPila {
    public Carta carta;
    public NodoPila siguiente;

    public NodoPila(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }
}
