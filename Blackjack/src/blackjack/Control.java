package blackjack;
import java.util.*;
public class Control {
    //variables
    boolean continuar;
    
    public void iniciarJuego(){
        while( continuar == true ){ //Bucle infinito que comprueba si el jugador quiere _continuar_ para volver a ejecutarse
            
            //Empezamos colocando el esquema de la logica del juego
            
            // Saludar, pedir apuesta
            VistaConsola.saludar(); //saluda y pide la apuesta
            
            //Con la apuesta ya hecha, procedemos a la parte de reparticion
            
            Baraja.repartir(); //Reparte las cartas 2 al jugador, 2 al crupier
            
            //Una vez repartidas tenemos que mostrar las cartas
            
            VistaConsola.verMano(); //Muestra la mano de las cartas obtenidas por Jugador
            VistaConsola.verManoCrupier(); //Muestra la unica carta del crupier
            VistaConsola.verPuntajeJugador(); //Siempre es util ver nuestro puntaje ajajjjj sisas
            
            //Ahora tenemos que preguntarle al jugador si con esas cartas se planta o quiere pedir más
            
            // plantaoPide le pregunta al jugador si planta o pide carta allí mismo,
            if(VistaConsola.plantaoPide() == "s"){
                Jugador.tomarCarta()
            } 
            
            
        }
        
    }
    
    
}
