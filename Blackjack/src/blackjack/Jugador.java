package blackjack;
import java.util.Scanner;
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
    private Scanner aspregunta;
    
    public Jugador(){
        mano = new Mano();
        saldo = 10000;
        aspregunta = new Scanner(System.in);
        
    }
    
    public void verMano(){
    	
    	
    	System.out.println("Tus cartas: ");
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
    	int asvalor;
    	mano.meterCarta(talcarta);
    	if(talcarta.getValor() == 1) {
    		System.out.println("Sacaste As!! ¿Quieres que sea (1) u (11)?????    1 / 11 ");
    		asvalor = aspregunta.nextInt(); 
    		mano.obtenerCarta(mano.contar()-1).setValor(asvalor);
    	}
    		
    	
    	
    	
    	verPuntaje();        
    }
    
    public int verPuntaje(){
        puntaje = mano.calcularPuntaje();        
        return puntaje;
    }
    
    public void limpiarJugador() {
    	
    	mano.limpiarMano();
    }
    
    public void recibirPremio(int premio) {
    	saldo = saldo + premio;
    }
    
    public boolean asLookup(){
    	boolean encontrado = false;
    	for (int i = 0 ; i < mano.contar(); i++) {
    		if( ( mano.obtenerCarta(i).getValor() ) == 1)
    			encontrado = true;
    	
    	}
    	return encontrado;
    }
}
