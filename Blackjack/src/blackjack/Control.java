/* DEADLINE: 12 DE JUNIO
 * 
 * Dudas:
 * Como haremos para que jugador y Crupier tomen las cartas de una sola baraja?
 * Como haremos para representar la mano de crupier y jugador?
 * Podremos acabar esta mierda a tiempo??????????
 *  Como putas hacemos que jugador y crupier tomen cartas de la misma baraja? Siendo jugador y crupier dos objetos diferentes
 *  Momento de iluminacion, podemos hacer un metodo en jugador que tome tambien la primera carta de baraja, pero que no la guarde sino que la pase
 como retorno de la funcion para que Crupier la pueda agarrar (algo asi como jugador toma la carta y se la pasa al crupier s o r n e r a m e n t e)
 Aunque tiene mas sentido al reves
 * 
Subir a git por favor cada que se haga un cambio: Se hace en la consola
1. git add . //Si, con el punto
2. git commit -m "Ingresa descripcion de los cambios hechos"
3. git push origin master  
 */



package blackjack;
import java.util.*;
public class Control {
    //variables
    boolean continuar;
    VistaConsola consola;
    Jugador jugador;
    Crupier crupier;
    
    public Control(){ //Constructor de nuestra clase control que maneja CASI todo
        continuar = true;
        consola = new VistaConsola();
        jugador = new Jugador();
        crupier = new Crupier();
    }
    
    public void iniciarJuego(){
        while( continuar == true ){ //Bucle infinito que comprueba si el jugador quiere _continuar_ para volver a ejecutarse
            
            //Empezamos colocando el esquema de la logica del juego
            
            // Saludar, pedir apuesta
            consola.saludar(); //saluda y pide la apuesta
            jugador.saldo();
            jugador.restarSaldo(consola.pedirApuesta());  //se manda al metodo de restar balance la apuesta que se pide con consola.pedirApuesta
            //Con la apuesta ya hecha, procedemos a la parte de reparticion
            
            baraja.repartir(); //Reparte las cartas 2 al jugador, 2 al crupier
            
            //Una vez repartidas tenemos que mostrar las cartas
            
            jugador.verMano(); //Muestra la mano de las cartas obtenidas por Jugador
            crupier.verMano(); //Muestra la unica carta del crupier
            jugador.verPuntaje(); //Siempre es util ver nuestro puntaje ajajjjj sisas
            
            //Ahora tenemos que preguntarle al jugador si con esas cartas se planta o quiere pedir más
            
            // plantaoPide le pregunta al jugador si planta o pide carta allí mismo,
            if(VistaConsola.plantaoPide() == "s"){  //bucle que hace al jugador tomar carta y comprobar puntaje hasta que se pase o no quiera tomar mas
                jugador.tomarCarta();
                
            } 
             // EVamos a hacer que la comprobacion del puntaje determine directamente si gano o perdio??
            
        }
        
    }
    
    
}
