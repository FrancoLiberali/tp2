package algoBall;

import exceptions.FueraDeRangoException;
import exceptions.YaNoPuedeAtacarException;
import funcionamientoTablero.Posicion;

public class Turno {
	private Jugador jugador;
	private int cantidadDeAtaquesRestantes;
	private Turno turnoSiguiente;
	
	public Turno(Jugador jugador){
		this.jugador = jugador;
		this.cantidadDeAtaquesRestantes = 1;
	}
	public Jugador getJugador(){
		return jugador;
	}
	
	public int getCantidadDeAtaquesRestantes(){
		return cantidadDeAtaquesRestantes;
	}
	
	public void reestablecer(){
		cantidadDeAtaquesRestantes = 1;
		jugador.reestablecer();
	}
	
	public Turno getTurnoSiguiente(){
		return turnoSiguiente;
	}
	
	public void setTurnoSiguiente(Turno turnoSiguiente){
		this.turnoSiguiente = turnoSiguiente;
	}
	
	public void moverIzquierda(String nombrePersonaje){
		this.jugador.moverIzquierda(nombrePersonaje);
	}
	public void moverAbajo(String nombrePersonaje){
		this.jugador.moverAbajo(nombrePersonaje);
	}
	public void moverDerecha(String nombrePersonaje){
		this.jugador.moverDerecha(nombrePersonaje);
	}
	public void moverArriba(String nombrePersonaje){
		this.jugador.moverArriba(nombrePersonaje);
	}
	
	public void realizarAtaqueBasico(String nombrePersonaje, Posicion posicionVictima){
		if (cantidadDeAtaquesRestantes == 0){
			throw new YaNoPuedeAtacarException();
		}
		try{
			this.jugador.realizarAtaqueBasico( nombrePersonaje, posicionVictima);
			this.cantidadDeAtaquesRestantes = 0;
		}
		catch (FueraDeRangoException error){
			/*mensaje al usuario*/
		}
	}
	
	public Posicion obtenerPosicionDe(String nombrePersonaje){
		return this.jugador.obtenerPosicionDe(nombrePersonaje);
	}
	
	public int obtenerSaludDe(String nombrePersonaje){
		return this.jugador.obtenerSaludDe(nombrePersonaje);
	}
}
