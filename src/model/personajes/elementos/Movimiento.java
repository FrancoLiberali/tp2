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
	private Personaje personajeIntentandoMover;
	
	public Movimiento(){
		tablero = Tablero.getInstance();
	}
	
	private void mover(Posicion nuevaPosicion){
		if (!this.sePuedeMover(personajeIntentandoMover)){
			throw new EstePersonajeNoSePuedeMoverException();
		}
		if (movimientosRestantes == 0){
			throw new NoQuedanMovimientosException();
		}
		
		nuevaPosicion.setCasillero(tablero.getCasillero(nuevaPosicion));
		personajeIntentandoMover.mover(nuevaPosicion);
		if (personajeQueSeMovio == null){
			movimientosRestantes = personajeIntentandoMover.getVelocidad();
		}
		movimientosRestantes--;
		personajeQueSeMovio = personajeIntentandoMover;
		
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
	
	public void moverIzquierda(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darIzquierda());
	}
	
	public void moverDerecha(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darDerecha());
	}
	
	public void moverArriba(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darArriba());
	}
	
	public void moverAbajo(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darAbajo());
	}
	
	public void moverArribaIzquierda(Personaje personaje)
	{	
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darArribaIzquierda());
	}
	
	public void moverArribaDerecha(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darArribaDerecha());
	}
	
	public void moverAbajoDerecha(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darAbajoDerecha());
	}
	
	public void moverAbajoIzquierda(Personaje personaje)
	{
		personajeIntentandoMover = personaje;
		this.mover(personaje.getPosicion().darAbajoIzquierda());
	}
}	

