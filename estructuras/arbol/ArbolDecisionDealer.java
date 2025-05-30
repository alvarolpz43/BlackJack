package estructuras.arbol;
// ArbolDecisionDealer.java
public class ArbolDecisionDealer {
    private NodoDecision raiz;

    public ArbolDecisionDealer() {
        construirArbol();
    }

    private void construirArbol() {
        // Árbol binario simple para decisiones básicas
        raiz = new NodoDecision("evaluar");

        raiz.izquierda = new NodoDecision("pedir");     // puntaje < 17
        raiz.derecha = new NodoDecision("plantarse");   // puntaje ≥ 17
    }

    public String decidir(int puntaje) {
        if (puntaje < 17) {
            return raiz.izquierda.accion;
        } else {
            return raiz.derecha.accion;
        }
    }
}
