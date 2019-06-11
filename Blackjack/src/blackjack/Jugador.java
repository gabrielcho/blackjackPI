package blackjack;

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
