package blackjack;
/*Falta:
 * 	- Hacer que no se pueda apostar ms del saldo que se tiene, tipo apuesta negativa
 * 	- Hacer la vista de mano
 * 	- Hacer que tome la carta 
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
        
        
    }
    
    public int saldo(){
        return saldo;
    }
    
    public void restarSaldo(int valor){
        saldo = saldo - valor;
    }
    
    public void tomarCarta(Carta talcarta){
        
        verPuntaje();        
    }
    
    public int verPuntaje(){
        puntaje = mano.calcularPuntaje();        
        return puntaje;
    }
}
