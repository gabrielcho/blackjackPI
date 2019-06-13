/* TODO: 
 *		
 *		
 * 		
 * 		
 * 		
 * 		
 * 		
 * 		
 * 		
 */


package blackjack;
import java.util.Vector;

public class Mano {
    private Vector<Carta> mano;
    
    public Mano(){
    mano = new Vector<Carta>();
    }
    

    public void meterCarta(Carta c){
        if (c != null)
        mano.addElement(c);
        }
    
    
    //Cuenta las cartas que tiene en la mano
    public int contar(){ 
        return mano.size();
    }
    
    
    //Dice la carta que tiene en la posición pos
    public Carta obtenerCarta(int pos){
        if (pos >= 0 && pos < mano.size())
        return (Carta)mano.elementAt(pos);
        
        else
        return null;
    }
    
    public int calcularPuntaje(){
        int valor;
        boolean as;
        int cartas;
        valor = 0;
        as = false;
        cartas = contar();
        for (int i = 0; i < cartas; i++ ) {
            Carta carta;
            int valorCarta;
            carta = obtenerCarta(i);
            valorCarta = carta.getValor();
            if (valorCarta > 10) {
                valorCarta = 10;
            }
            if (valorCarta == 1){
                as = true;
            }
            valor = valor + valorCarta;
            
        }
        if (as == true && valor + 10 <= 21 )
        valor = valor + 10;
        return valor;
    }

    
    public void limpiarMano(){ //para empezar otra ronda con todo limpio
        mano.clear();
    }
    
 
}
