package estructuras.arbol;
// NodoDecision.java
public class NodoDecision {
    public String accion; 
    public NodoDecision izquierda;
    public NodoDecision derecha;

    public NodoDecision(String accion) {
        this.accion = accion;
        this.izquierda = null;
        this.derecha = null;
    }
}
