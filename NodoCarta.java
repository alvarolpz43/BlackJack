// NodoCarta.java
public class NodoCarta {
    public Carta carta;
    public NodoCarta siguiente;

    public NodoCarta(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }
}
