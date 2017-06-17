package algoBall;

import personajes.Personaje;
import tablero.Posicion;

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
	public Personaje getPersonaje(String nombre) {
		return this.jugador.getPersonaje(nombre);
	}
	
	
	public Equipo getEquipo(String nombre) {
		return this.jugador.getEquipo(nombre);
	}
	
	public Equipo getEquipo() {
		
		return this.jugador.getEquipo();
	}
}


