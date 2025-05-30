// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bienvenida
        System.out.println("Bienvenido a Blackjack versión consola");
        System.out.print("Ingrese su nombre: ");
        String nombreJugador = scanner.nextLine();

        // Inicialización de estructuras
        Baraja baraja = new Baraja();
        PilaCartas historial = new PilaCartas();
        ColaTurnos turnos = new ColaTurnos();
        ArbolDecisionDealer arbolDealer = new ArbolDecisionDealer();
        TablaHashJugadores jugadores = new TablaHashJugadores(10);

        // Crear jugador humano y dealer
        Jugador jugador = new Jugador(nombreJugador);
        Jugador dealer = new Jugador("Dealer");

        jugadores.insertar(nombreJugador, jugador);
        jugadores.insertar("Dealer", dealer);

        turnos.encolar(nombreJugador);
        turnos.encolar("Dealer");

        // Repartir 2 cartas a cada jugador
        for (int i = 0; i < 2; i++) {
            jugador.agregarCarta(baraja.robarCarta());
            dealer.agregarCarta(baraja.robarCarta());
        }

        // Comienza el juego por turnos
        while (!turnos.estaVacia()) {
            String turnoActual = turnos.desencolar();
            Jugador actual = jugadores.obtener(turnoActual);

            System.out.println("\nTurno de: " + actual.getNombre());
            System.out.println(actual.getNombre() + " tiene:");
            actual.mostrarMano();
            System.out.println("Puntaje: " + actual.getPuntaje());

            // Lógica del Jugador
            if (!actual.getNombre().equals("Dealer")) {
                while (!actual.estaPlantado() && actual.getPuntaje() < 21) {
                    System.out.print("¿Desea otra carta? (s/n): ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        Carta nueva = baraja.robarCarta();
                        historial.apilar(nueva);
                        actual.agregarCarta(nueva);

                        System.out.println(actual.getNombre() + " tiene:");
                        actual.mostrarMano();
                        System.out.println("Puntaje: " + actual.getPuntaje());

                        if (actual.getPuntaje() > 21) {
                            System.out.println("¡Te pasaste de 21!");
                            actual.plantarse();
                        }
                    } else {
                        actual.plantarse();
                    }
                }
            }
            // Lógica del Dealer
            else {
                while (!actual.estaPlantado()) {
                    String decision = arbolDealer.decidir(actual.getPuntaje());
                    if (decision.equals("pedir")) {
                        System.out.println("El dealer toma una carta...");
                        Carta nueva = baraja.robarCarta();
                        historial.apilar(nueva);
                        actual.agregarCarta(nueva);
                    } else {
                        System.out.println("El dealer se planta.");
                        actual.plantarse();
                    }
                }
                System.out.println("Dealer tiene:");
                actual.mostrarMano();
                System.out.println("Puntaje: " + actual.getPuntaje());
            }
        }

        // Mostrar resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println(jugador.getNombre() + " tiene:");
        jugador.mostrarMano();
        System.out.println("Puntaje: " + jugador.getPuntaje());

        System.out.println("\nDealer tiene:");
        dealer.mostrarMano();
        System.out.println("Puntaje: " + dealer.getPuntaje());

        if (jugador.getPuntaje() > 21) {
            System.out.println("\nEl dealer gana.");
        } else if (dealer.getPuntaje() > 21 || jugador.getPuntaje() > dealer.getPuntaje()) {
            System.out.println("\n" + jugador.getNombre() + " gana! 🎉");
        } else if (dealer.getPuntaje() == jugador.getPuntaje()) {
            System.out.println("\nEmpate.");
        } else {
            System.out.println("\nEl dealer gana.");
        }

        // Mostrar historial de cartas jugadas
        System.out.println();
        historial.mostrarHistorial();
    }
}
