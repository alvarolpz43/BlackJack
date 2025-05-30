package estructuras.jugadores;

import cartas.Carta;

public class Jugador {
    private String nombre;
    private Carta[] mano;
    private int cantidadCartas;
    private int puntaje;
    private boolean plantado;

    // Constructor del jugador

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new Carta[10];
        this.cantidadCartas = 0;
        this.puntaje = 0;
        this.plantado = false;
    }

    // Getters para acceder a los atributos del jugador

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public boolean estaPlantado() {
        return plantado;
    }

    public void plantarse() {
        this.plantado = true;
    }

    public void agregarCarta(Carta carta) {
        if (cantidadCartas < mano.length) {
            mano[cantidadCartas++] = carta;
            actualizarPuntaje();
        }
    }

    public void mostrarMano() {
        for (int i = 0; i < cantidadCartas; i++) {
            System.out.println("  " + mano[i]);
        }
    }

    private void actualizarPuntaje() {
        int total = 0;
        int ases = 0;
        // Suma todas las cartas y cuenta los ases
        for (int i = 0; i < cantidadCartas; i++) {
            int valor = mano[i].obtenerValorNumerico();
            total += valor;
            if (mano[i].getValor().equals("A"))
                ases++;
        }

        // Ajuste si hay Aces y se pasa de 21
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }

        this.puntaje = total;
    }
}
