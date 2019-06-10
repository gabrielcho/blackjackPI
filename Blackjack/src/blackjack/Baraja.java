//Tengo que aprender a manejar mejor este tema de array de objetos puesto que buena parte de esto me tocó emularlo de otro proyecto

package blackjack;
import java.util.*;
public class Baraja {
	 
	//En esta clase tendremos que tener muchos objetos de carta organizados en un array de 52 (el numero de cartas).
	//En el constructor tenemos que crear ya la baraja
	Carta carta = new Carta();
	private static Carta[] baraja;
	private int robadas;
	public Baraja(){
		baraja[creadas] = new Carta[]
		for(int valor = 1; valor < 15; i++){
			for(int palo = 0; palo < 5; palo++){
				baraja[creadas] = new Carta(valor,palo)
				creadas++
			}
		}
		robadas = 0;
	}//
	
	public void barajarCartas(){ //Esta función desordena las cartas para aleatorizar la selección de la primera de la baraja
		for ( int i = 51; i > 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			Carta temp = baraja[i];
			baraja[i] = baraja[rand];
			baraja[rand] = temp;
			}
			robadas = 0;
	}//
	
	public Carta soltarCarta(){ // Toma la ultima carta de la baraja y la arroja para que la reciba un jugador o crupier
		return Baraja[creadas-robadas]
		robadas++;

	}//
    
}
