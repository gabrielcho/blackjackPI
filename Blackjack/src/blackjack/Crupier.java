package blackjack;

public class Crupier {
    private Mano mano;
    private int puntaje;
    
    
    public Crupier(){
        mano = new Mano();
        puntaje = 0;
    }
    
    public void verMano(boolean turnocrupier){
    	System.out.println("Cartas del crupier: ");
    	for(int i=0; i < mano.contar() ; i++ ) {
    		if((i == 0) &&  (turnocrupier == true)) {
    			System.out.println("XXXXXXXXXXXXX carta oculta XXXXXXXXXXXXXX");
    			continue; }
    		System.out.println( mano.obtenerCarta(i).mostrarCarta());
       
    	}
    }	
    	
    public int verPuntaje() { // Tiene que ver su puntaje y comprobar si pasa de 21 
    	
    	puntaje = mano.calcularPuntaje();
    	return puntaje;
    	
    	
    }
    
    public void tomarCarta(Carta talcarta){
    	mano.meterCarta(talcarta);
        verPuntaje();        
    }
    
    public void empezarTurno() {
    	
    }
    
    public void limpiarCrupier() {
    	mano.limpiarMano();
    	puntaje = 0;
    }
    
}
