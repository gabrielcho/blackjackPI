package blackjack;
public class Carta {
    public final static
    int espadas = 0,
    corazones = 1,
    diamantes = 2,
    picas = 3;
    
    public final static
    int jack = 11,
    queen = 12,
    king = 13;
    
    private final int palo;
    private final int valor;
    
    public Carta(int val, int pal) {
        valor = val;
        palo = pal;
    }
    public int getPalo(){
        return palo;
    }
    public int getValor(){
        return valor;
    }
    public String paloCarta() {
        switch ( palo ) {
            case espadas: return "Espadas";
            case corazones: return "Corazones";
            case diamantes: return "Diamantes";
            case picas: return "Picas";
            default: return "??";
        }
    }
    public String valorCarta() {
        switch ( valor ) {
            case 1: return "As";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return "??";
        }
    }
    public String mostrarCarta() {
        return valorCarta() + " de " + paloCarta();
    }
}

