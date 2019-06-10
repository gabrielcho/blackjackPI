package blackjack;
import java.util.*;
public class VistaConsola {
    private Scanner entradaApuesta;  
    private int apuesta;
    private String decision;
    private Scanner entradaDecision;
    public VistaConsola(){
        entradaApuesta = new Scanner(System.in);
        entradaDecision = new Scanner(System.in);
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
        System.out.println("¿Plantas (p) o pides (P)?");
        decision = entradaDecision.nextLine();
        return decision;
    }
}
