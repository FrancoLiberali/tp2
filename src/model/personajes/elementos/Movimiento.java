package model.personajes.elementos;

import model.exceptions.EstePersonajeNoSePuedeMoverException;
import model.exceptions.NoQuedanMovimientosException;
import model.personajes.Personaje;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class Movimiento {
	private  int movimientosRestantes = 1;
	private Personaje personajeQueSeMovio;
	private Tablero tablero;
	
	public Movimiento(){
		tablero = Tablero.getInstance();
	}
	
	public void mover(Personaje personaje, Direccion direccion){
		if (!this.sePuedeMover(personaje)){
			throw new EstePersonajeNoSePuedeMoverException();
		}
		if (movimientosRestantes == 0){
			throw new NoQuedanMovimientosException();
		}
		Posicion nuevaPosicion = direccion.proximaPosicion(personaje.getPosicion());
		nuevaPosicion.setCasillero(tablero.getCasillero(nuevaPosicion));
		personaje.mover(nuevaPosicion);
		if (personajeQueSeMovio == null){
			movimientosRestantes = personaje.getVelocidad();
		}
		movimientosRestantes--;
		personajeQueSeMovio = personaje;
	}
	
	public boolean sePuedeMover(Personaje personaje){
		return ((personajeQueSeMovio == null || personaje == personajeQueSeMovio) && !(personaje.estaConvertidoAChocolate()));
	}
	
	public void actualizarMovimientosRestantes(Personaje personaje, int velocidadAnterior, int velocidadActual){
		if (personaje == personajeQueSeMovio){
			int movimientosRealizados = velocidadAnterior - movimientosRestantes;
			movimientosRestantes = (velocidadActual - movimientosRealizados);
		}
	}
}	

