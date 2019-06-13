package blackjack;
/* TODO:
 * 	- Hacer que no se pueda apostar más del saldo que se tiene, tipo apuesta negativa
 * 	- Hacer la vista de mano (D)
 * 	- Hacer que tome la carta  (D)
 *  - 
 * 
 * 
 * 
 * 
 */

public class Jugador {
    private int saldo, puntaje;
    private Mano mano;
    
    public Jugador(){
        mano = new Mano();
        saldo = 10000;
        
    }
    
    public void verMano(){
    	System.out.println("e");
    	for(int i=0; i < mano.contar() ; i++ ) {
    		System.out.println( mano.obtenerCarta(i).mostrarCarta());

    	}
    	
    	
    }
    
    public int saldo(){
        return saldo;
    }
    
    public void restarSaldo(int valor){
    	
        saldo = saldo - valor;
    }
    
    public void tomarCarta(Carta talcarta){
    	/*if( 21  < (talcarta.getValor()  + verPuntaje())   )
        mano.meterCarta(talcarta);
    	else*/ 
    	
    	mano.meterCarta(talcarta);
    	
    	verPuntaje();        
    }
    
    public int verPuntaje(){
        puntaje = mano.calcularPuntaje();        
        return puntaje;
    }
    
    public void limpiarJugador() {
    	
    	mano.limpiarMano();
    }
}
