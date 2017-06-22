package model.personajes.elementos;

import model.exceptions.EstePersonajeNoSePuedeMoverException;
import model.exceptions.NoQuedanMovimientosException;
import model.personajes.Personaje;
import model.tablero.Posicion;

public class Movimiento {
	private  int movimientosRestantes = 1;
	private Personaje personajeQueSeMovio;
	
	public Movimiento(){
	}
	
	public void mover(Personaje personaje, Posicion nuevaPosicion){
		if (!this.sePuedeMover(personaje)){
			throw new EstePersonajeNoSePuedeMoverException();
		}
		if (movimientosRestantes == 0){
			throw new NoQuedanMovimientosException();
		}
		Posicion antiguaPosicion = personaje.getPosicion();
		nuevaPosicion.agregarEnTablero(personaje);
		antiguaPosicion.vaciarEnTablero();
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
	
	public void moverIzquierda(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darIzquierda());
	}
	
	public void moverDerecha(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darDerecha());
	}
	
	public void moverArriba(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darArriba());
	}
	
	public void moverAbajo(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darAbajo());
	}
	
	public void moverArribaIzquierda(Personaje personaje)
	{	
		this.mover(personaje, personaje.getPosicion().darArribaIzquierda());
	}
	
	public void moverArribaDerecha(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darArribaDerecha());
	}
	
	public void moverAbajoDerecha(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darAbajoDerecha());
	}
	
	public void moverAbajoIzquierda(Personaje personaje)
	{
		this.mover(personaje, personaje.getPosicion().darAbajoIzquierda());
	}
}	

