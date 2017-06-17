package funcionamientoPersonaje.elementos;

import exceptions.CasilleroOcupadoException;
import exceptions.FueraDelTableroException;
import personajes.Personaje;
import tablero.Posicion;

public class Movimiento {
	private  int movimientosRestantes = 1;
	private Personaje personajeQueSeMovio;
	
	public Movimiento(){
	}
	
	public void mover(Personaje personaje, Posicion nuevaPosicion){
		if (!this.sePuedeMover(personaje)){
			return;
		}
		if (movimientosRestantes == 0){
			return;
		}
		try {
			Posicion antiguaPosicion = personaje.getPosicion();
			nuevaPosicion.agregarEnTablero(personaje);
			antiguaPosicion.vaciarEnTablero();
			if (personajeQueSeMovio == null){
				movimientosRestantes = personaje.getVelocidad();
			}
			movimientosRestantes--;
			personajeQueSeMovio = personaje;
		}
		catch (CasilleroOcupadoException error){
			/*cancela movimiento (mas adelante agregar mensaje a usuario)*/
		}
		catch (FueraDelTableroException error){
			/*cancela movimiento (mas adelante agregar mensaje a usuario)*/
		}
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

