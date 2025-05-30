// Carta.java
public class Carta {
    private String valor; // A, 2, ..., 10, J, Q, K
    private String palo;  // ♠, ♥, ♦, ♣

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    // Devuelve el valor numérico de la carta para el juego
    public int obtenerValorNumerico() {
        switch (valor) {
            case "A": return 11;
            case "K":
            case "Q":
            case "J": return 10;
            default: return Integer.parseInt(valor);
        }
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
