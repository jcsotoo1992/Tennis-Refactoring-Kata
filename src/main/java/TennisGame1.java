
public class TennisGame1 implements TennisGame {
    private Jugador jugador1, jugador2;

    public TennisGame1(String nombreJugador1, String nombreJugador2) {
    	this.jugador1 = new Jugador(nombreJugador1);
    	this.jugador2 = new Jugador(nombreJugador1);
    }

    public void ganoPunto(String nombreJugador) {
        if (nombreJugador.equals("jugador1"))
            jugador1.aumentarPuntaje();
        else
            jugador2.aumentarPuntaje();
    }
    
    public String getPuntaje() {
        
        if (jugador1.getPuntaje() == jugador2.getPuntaje())
            return getPuntajeIguales(jugador1.getPuntaje());
        else if (jugador1.getPuntaje() > 3 || jugador2.getPuntaje() > 3)
            return getPuntajeMayorA3(jugador1.getPuntaje() - jugador2.getPuntaje());
        else
        	return getPuntajeMenorA3();    
    }
    
    private String getPuntajeIguales(int puntaje) {
    	switch (puntaje)
        {
            case 0: return "Amor-Todos";
            case 1: return "Quince-Todos";
            case 2: return "Treinta-Todos";
        }
    	return "Deuce";
    }
    
    private String getPuntajeMayorA3(int diferenciaPuntajes) {
        if (diferenciaPuntajes==1) 
        	return "Ventaja jugador1";
        else if (diferenciaPuntajes == -1) 
        	return "Ventaja jugador2";
        else if (diferenciaPuntajes >= 2) 
        	return "Gana jugador1";
        else 
        	return "Gana jugador2";
    }
    
    private String getPuntajeMenorA3() {
    	int tempPuntaje = 0;
    	String puntaje = "";
    	for (int i=1; i<3; i++)
        {
            if (i==1) 
            	tempPuntaje = jugador1.getPuntaje();
            else 
            { 
            	puntaje+="-"; 
            	tempPuntaje = jugador2.getPuntaje();
            }
            switch(tempPuntaje)
            {
                case 0:
                    puntaje+="Amor";
                    break;
                case 1:
                    puntaje+="Quince";
                    break;
                case 2:
                    puntaje+="Treinta";
                    break;
                case 3:
                    puntaje+="Cuarenta";
                    break;
            }
        }
    	return puntaje;
    }
}
