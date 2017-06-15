package algoBall;

import exceptions.FueraDeRangoException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.KiInsuficienteException;
import exceptions.PersonajeInactivoNoPuedeAtacarException;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

public class Turno {
	private Jugador jugador;
	private Turno turnoSiguiente;
	
	public Turno(Jugador jugador){
		this.jugador = jugador;
		this.reestablecer();
	}
	public Jugador getJugador(){
		return jugador;
	}
	
	public void reestablecer(){
		jugador.reestablecer();
	}
	
	public Turno getTurnoSiguiente(){
		return turnoSiguiente;
	}
	
	public void setTurnoSiguiente(Turno turnoSiguiente){
		this.turnoSiguiente = turnoSiguiente;
	}
	

	public Posicion obtenerPosicionDe(String nombrePersonaje){
		return this.jugador.obtenerPosicionDe(nombrePersonaje);
	}
	
	public int obtenerSaludDe(String nombrePersonaje){
		return this.jugador.obtenerSaludDe(nombrePersonaje);
	}
	public int getKiDe(String nombrePersonaje){
		return this.jugador.getKiDe(nombrePersonaje);
	}
	
	public int getCantidadDeAtaquesRestantes(){
		return this.jugador.getCantidadDeAtaquesRestantes();
	}
	public int getCantidadDeMovimientosRestantes() {
		return this.jugador.getCantidadDeMovimientosRestantes();
	}
	public Personaje getPersonaje(String nombre) {
		return this.jugador.getPersonaje(nombre);
	}
}


