//Tengo que aprender a manejar mejor este tema de array de objetos puesto que buena parte de esto me tocó emularlo de otro proyecto

package blackjack;

public class Baraja {
	 
	//En esta clase tendremos que tener muchos objetos de carta organizados en un array de 52 (el numero de cartas).
	//En el constructor tenemos que crear ya la baraja
	private static Carta[] baraja;
	// private Carta as; 
	private int robadas, creadas;
	
	public Baraja(){
		//as = new Carta(1,1);
		baraja = new Carta[52];
		for(int palo = 0; palo < 4; palo++){
			for(int valor = 1; valor < 14; valor++){
				baraja[creadas] = new Carta(valor,palo);
				creadas++;
				
			}
		}
		robadas = 0;
	}//
	
	public void barajarCartas(){ //Esta funcion desordena las cartas para aleatorizar la selección de la primera de la baraja
		for ( int i = 51; i > 0; i-- ) {
			int rand = (int)(Math.random()*(i+1));
			Carta temp = baraja[i];
			baraja[i] = baraja[rand];
			baraja[rand] = temp;
			}
			robadas = 0;
	}//
	
	public Carta soltarCarta(){ // Toma la ultima carta de la baraja y la arroja para que la reciba un jugador o crupier
		robadas++;
		return baraja[(creadas-robadas)-1];
	}//
    
	/*public Carta tirarAs() { 		//Metodo de prueba para probar el comportamiento del programa cuando hay un As
		return as;
	}*/
}
