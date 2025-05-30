// Baraja.java
import java.util.Random;

public class Baraja {
    private NodoCarta inicio;

    public Baraja() {
        inicializarBaraja();
        mezclar();
    }

    // Crea las 52 cartas de la baraja
    private void inicializarBaraja() {
        String[] palos = { "Corazones", "Picas", "Diamantes", "Tréboles" };
        String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

        for (String palo : palos) {
            for (String valor : valores) {
                insertarFinal(new Carta(valor, palo));
            }
        }
    }

    // Inserta una carta al final de la lista enlazada
    private void insertarFinal(Carta carta) {
        NodoCarta nuevo = new NodoCarta(carta);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoCarta actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // Baraja las cartas de forma aleatoria
    private void mezclar() {
        Carta[] cartas = new Carta[52];
        NodoCarta actual = inicio;
        int i = 0;
        while (actual != null) {
            cartas[i++] = actual.carta;
            actual = actual.siguiente;
        }

        Random random = new Random();
        for (int j = 0; j < cartas.length; j++) {
            int randIndex = random.nextInt(cartas.length);
            Carta temp = cartas[j];
            cartas[j] = cartas[randIndex];
            cartas[randIndex] = temp;
        }

        inicio = null;
        for (Carta carta : cartas) {
            insertarFinal(carta);
        }
    }

    // Extrae la primera carta de la baraja
    public Carta robarCarta() {
        if (inicio == null) return null;

        Carta cartaRobada = inicio.carta;
        inicio = inicio.siguiente;
        return cartaRobada;
    }

    public boolean estaVacia() {
        return inicio == null;
    }
}
