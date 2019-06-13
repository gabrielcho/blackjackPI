/* DEADLINE: 12 DE JUNIO 
 * 
 * Dudas:
 * Como haremos para que jugador y Crupier tomen las cartas de una sola baraja?
 * Como haremos para representar la mano de crupier y jugador?
 * Podremos acabar esta mierda a tiempo??????????
 *  Como putas hacemos que jugador y crupier tomen cartas de la misma baraja? Siendo jugador y crupier dos objetos diferentes
 YA:
 Hacemos una función de baraja que tire una carta y hacemos una función de jugador y otra de crupier para que tomen una carta arrojada por el metodo de la BAraja
 tipo   jugador.tomarCarta(baraja.tirarCarta);
 		crupier.tomarCarta(baraja.tirarCarta);+
 
 
 
 *  Momento de iluminacion, podemos hacer un metodo en jugador que tome tambien la primera carta de baraja, pero que no la guarde sino que la pase
 como retorno de la funcion para que Crupier la pueda agarrar (algo asi como jugador toma la carta y se la pasa al crupier s o r n e r a m e n t e)
 Aunque tiene mas sentido al reves
 * 
Subir a git por favor cada que se haga un cambio: Se hace en la consola
1. git add . //Si, con el punto
2. git commit -m "Ingresa descripcion de los cambios hechos"
3. git push origin master  
 */



package blackjack;


public class Control {
    //variables
	private boolean continuar; 
	private boolean fasedetoma, turnocrupier, siguejugando, apuestaincorrecta; //fasedetoma
	private int apuesta , premio;
	private VistaConsola consola;
	private Jugador jugador;
	private Crupier crupier;
	private Baraja baraja;
    
    public Control(){ //Constructor de nuestra clase control que maneja CASI todo
        continuar = true;
        fasedetoma = true;
        turnocrupier = true;
        apuestaincorrecta = true;
        apuesta = 0;
        premio = 0;
        consola = new VistaConsola();
        jugador = new Jugador();
        crupier = new Crupier();
        baraja = new Baraja();
    }
    
    public void iniciarJuego(){
        while( continuar == true ){ //Bucle infinito que comprueba si el jugador quiere _continuar_ para volver a ejecutarse
        	if(jugador.saldo() <= 0) {
        		System.out.println("No puedes jugar si no tienes dinero para apostar... F Game over");
        		break;
        	}
        		
            //Empezamos colocando el esquema de la logica del juego
        	reiniciarTodaLaMonda();
        	
            // Saludar, pedir apuesta
            consola.saludar(); //saluda y pide la apuesta
            consola.separadorMelo();
            consola.mostrarSaldo(jugador.saldo());
            while(apuestaincorrecta == true) {
            	consola.pedirApuesta();
            	if(consola.getApuesta() > jugador.saldo()) {
            		System.out.println("No puedes apostar m�s de lo que tienes!");
            		continue;
            	}
            	else { 
            		apuestaincorrecta = false;
            	}
            }
            jugador.restarSaldo(consola.getApuesta());
            apuesta = consola.getApuesta();//se manda al metodo de restar balance la apuesta que se pide con consola.pedirApuesta
            //  Con la apuesta ya hecha, procedemos a la parte de reparticion
            
            jugador.tomarCarta(baraja.soltarCarta()); //Reparte las cartas 2 al jugador, 2 al crupier
            jugador.tomarCarta(baraja.soltarCarta());
            
            crupier.tomarCarta(baraja.soltarCarta());
            crupier.tomarCarta(baraja.soltarCarta());
          
            //Una vez repartidas tenemos que mostrar las cartas
            consola.separadorMelo();
            jugador.verMano(); //Muestra la mano de las cartas obtenidas por Jugador
            consola.mostrarPuntaje(jugador.verPuntaje()); //Siempre es util ver nuestro puntaje ajajjjj sisas

            crupier.verMano(true); //Muestra la unica carta del crupier
            
            //Ahora tenemos que preguntarle al jugador si con esas cartas se planta o quiere pedir más
            
            // plantaoPide le pregunta al jugador si planta o pide carta allí mismo,
            
          
            /////////////////////////////////////////// DRAW PHASE //////////////////////////////////////////////////////////////////////////////////
            
            
            String pop; //Este string guarda la P o la p ingresada por el jugador para luego comparar y hacer efectiva la decisi�n
            while(fasedetoma == true){
            	consola.separadorMelo();
            	pop = consola.plantaoPide();
            	consola.separadorMelo();
                if(pop.equals("P")){  //bucle que hace al jugador tomar carta y comprobar puntaje hasta que se pase o no quiera tomar mas
                    System.out.println("Tomas una carta...");
                    consola.separadorMelo();
                    jugador.tomarCarta(baraja.soltarCarta());
                	consola.separadorMelo();
                	jugador.verMano();
                	consola.separadorMelo();
                    
                    
                    if(jugador.verPuntaje() > 21)
                    {   
                    	System.out.println("PERDISTE SISAS, puntaje: " + jugador.verPuntaje() );
                    	fasedetoma = false;
                        volveraJugar();
                        siguejugando = false;
                        continue;
                    }
                    
                    System.out.println("Tu puntaje con esta mano es:  " + jugador.verPuntaje());
                }
                else if(pop.equals("p")){
                    fasedetoma = false;
                    jugador.verPuntaje();
                }
                else if( !(pop.equals("P")) && !(pop.equals("p"))) {
                	consola.noPlantoNiPidio();
                }                   
            }
            
            ///////////////////////////////////////////////// CRUPIER PHASE ///////////////////////////////////////////////////////////
            if(siguejugando == true)
            	while(turnocrupier == true) {
            		System.out.println("Puntaje del crupier:  " + crupier.verPuntaje());
            		consola.separadorMelo();
            		crupier.tomarCarta(baraja.soltarCarta());
            		crupier.verMano(false);
            		System.out.println("Puntaje del crupier: con esta baraja  " + crupier.verPuntaje());
            		if(crupier.verPuntaje() > 21) {
            			consola.separadorMelo();
            			System.out.println("El crupier se paso de 21!!!");             	
            			consola.separadorMelo();
            			jugadorGana();
            			turnocrupier = false;
            			siguejugando = false;
            			break;
            		}
            	
            	else if(crupier.verPuntaje() >= 17) {
            		turnocrupier = false; 
            		consola.separadorMelo();
            		System.out.println("El crupier se planta...");
            		turnocrupier = false; 
            		consola.separadorMelo();
            		continue;
            	}
            	
            	else if(crupier.verPuntaje() <= 16) {
            		consola.separadorMelo();
            		System.out.println("El crupier toma una nueva carta");
            		consola.separadorMelo();
            		continue;
            		
            	}
             	
            }
          
            
            /////////////////////////////////////////////// EVAL PHASE ////////////////////////////////////////////////////////

            if(siguejugando == true) {
            	if(jugador.verPuntaje() > crupier.verPuntaje()) {
            		System.out.println("Tu puntaje: " + jugador.verPuntaje() + "\nPuntaje del crupier: " + crupier.verPuntaje() );
            		jugadorGana();
            	}
            	else if(jugador.verPuntaje() < crupier.verPuntaje()) {
            		System.out.println("Tu puntaje: " + jugador.verPuntaje() + "\nPuntaje del crupier: " + crupier.verPuntaje() );
            		jugadorPierde();
            	}
            	else if(jugador.verPuntaje() == crupier.verPuntaje()) {
            			if(jugador.asLookup())
            				jugadorGana();
            			else empate();
            	}
            }
            
            
            
            
             //Vamos a hacer que la comprobacion del puntaje determine directamente si gano o perdio??
        } //termina bucle
        consola.separadorMelo();
        System.out.println("Gracias por Jugar!!");
    }
    
    public void volveraJugar(){
        if(consola.volveraJugar() == true)
        { 
        	System.out.println("elegiste seguir jugando");
        }
        
        
    	
    else {
    	continuar = false;
    	System.out.println("elegiste dejar de  jugar");
    }

    
    }
    
    public void jugadorGana() {
        premio = apuesta * 2;

    	System.out.println("Ganaste!!! Felicitaciones, la recompensa (" + premio +  ") se ha anadido a tu saldo: " );
    	jugador.recibirPremio(premio);
    	System.out.println("Nuevo saldo: " + jugador.saldo());
    	volveraJugar();

    }

    public void jugadorPierde() {
    	System.out.println("Perdiste :( la casa gana");
    	System.out.println("Nuevo saldo: " + jugador.saldo());
    	volveraJugar();

    }
    
    public void empate() {
    	System.out.println("Empataste, no pierdes tu dinerillo \nTu balance: " + jugador.saldo());
    	volveraJugar();
    }
    
    public void reiniciarTodaLaMonda() {
    	jugador.limpiarJugador();
    	crupier.limpiarCrupier();
    	baraja.barajarCartas();
        continuar = true;
        fasedetoma = true;
        turnocrupier = true;
        siguejugando = true;
        apuestaincorrecta = true;
    }

}