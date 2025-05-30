package estructuras.hash;

// Importa la clase Jugador desde el paquete correspondiente
import estructuras.jugadores.Jugador;


public class NodoHashJugador {

    public String clave;

    // Objeto 
    public Jugador jugador;

   
    public NodoHashJugador siguiente;

  
    public NodoHashJugador(String clave, Jugador jugador) {
        this.clave = clave;          
        this.jugador = jugador;  
        this.siguiente = null;     
    }
}
