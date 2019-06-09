package blackjack;
import java.util.*;
public class VistaConsola {
    private Scanner entrada;  
    private int apuesta;
    
    public VistaConsola(){
        entrada = new Scanner(System.in);
        apuesta = 0;
    }
    
    public void saludar(){
        System.out.println("Saludos, bienvenido a Blackjack virtual B-)");
    }
    
    public void pedirApuesta(){
        System.out.println("Por favor ingresa el valor de tu apuesta: ");
        apuesta = entrada.nextline();
    }
}
