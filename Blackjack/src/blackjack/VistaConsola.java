package blackjack;
import java.util.Scanner;
public class VistaConsola {
    private Scanner entradaApuesta;  
    private Scanner entradaDecision;
    private Scanner entradaSigueono;
    private int apuesta;
    private String decision;
    private String son;
    private boolean sigue;
    
    
    public VistaConsola(){
        entradaApuesta = new Scanner(System.in);
        entradaDecision = new Scanner(System.in);
        entradaSigueono = new Scanner(System.in);
        sigue = false;
        apuesta = 0;
    }
    
    public void saludar(){
        System.out.println("Saludos, bienvenido a Blackjack virtual B-)");
    }
    
    public int pedirApuesta(){
        System.out.println("Por favor ingresa el valor de tu apuesta: ");
        apuesta = entradaApuesta.nextInt();
        return apuesta;
    }
    
    public String plantaoPide(){
        System.out.println("�Plantas (p) o pides (P)?");
        decision = entradaDecision.nextLine();
        return decision;
    }
    
    public boolean volveraJugar(){
    	System.out.println("Quieres volver a jugar? s/n");
        son = entradaSigueono.nextLine();
        if (son.equals("s")) {
            sigue = true;
        }else {
            sigue = false;
        }
        return sigue;
    }
    
    public void mostrarSaldo(int saldote) {
    	String saldojugador= "Su saldo es: " + saldote;
    	System.out.println(saldojugador);
    	
    	
    }
    
    public void noPlantoNiPidio() {
    	System.out.println("Ingresa una opci�n correcta!");
    }
    
    public void mostrarPuntaje(int puntaje) {
    	System.out.println("Tu puntaje es:" + puntaje);
    }
    
    public int getApuesta() {
    	return apuesta;
    }
    
    public void separadorMelo() {
    	System.out.println("==================================================="); 
    }
}
