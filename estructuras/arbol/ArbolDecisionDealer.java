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

        raiz.izquierda = new NodoDecision("pedir");     
        raiz.derecha = new NodoDecision("plantarse");   
    }

    public String decidir(int puntaje) {
        if (puntaje < 17) {
            return raiz.izquierda.accion;
        } else {
            return raiz.derecha.accion;
        }
    }
}
