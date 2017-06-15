package algoBall;

import static algoBall.ConstantesDelJuego.*;

import java.util.ArrayList;

import exceptions.PersonajeInexistenteException;
import funcionamientoPersonaje.elementos.*;
import funcionamientoPersonaje.personajes.Cell;
import funcionamientoPersonaje.personajes.Freezer;
import funcionamientoPersonaje.personajes.Gohan;
import funcionamientoPersonaje.personajes.Goku;
import funcionamientoPersonaje.personajes.MajinBoo;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoPersonaje.personajes.Piccolo;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class AlgoBall 
{
	private Turno turnoActual;
	private Tablero tablero;
	private ArrayList<Personaje> listaPerosnajes;
	
	public AlgoBall(String nombre1, String nombre2)
	{
		this.tablero = new Tablero(8);
		Jugador jugador1 = new Jugador(nombre1, "enemigosDeLaTierra");
		Jugador jugador2 = new Jugador(nombre2, "guerrerosZ");
		iniciarPersonajes(jugador1, jugador2);
		this.turnoActual = iniciarTurnos(jugador1, jugador2);
	}
	
	public Turno iniciarTurnos(Jugador jugador1, Jugador jugador2){
		Turno turnoJugador1 = new Turno(jugador1);
		Turno turnoJugador2 = new Turno(jugador2);
		turnoJugador1.setTurnoSiguiente(turnoJugador2);
		turnoJugador2.setTurnoSiguiente(turnoJugador1);
		return turnoJugador1;
	}
		
	public void finalizarTurno(){
		turnoActual.reestablecer();
		turnoActual = turnoActual.getTurnoSiguiente();
	}
	
	public Turno turnoSiguiente(){
		return turnoActual.getTurnoSiguiente();
	}
	
	
	public void terminarJuego(){
		@SuppressWarnings("unused")
		Jugador jugadorGanador = this.turnoActual.getJugador();
		/*mensaje final*/
	}
	
	public Posicion obtenerPosicionDe(String nombrePersonaje){
		try{
			return this.turnoActual.obtenerPosicionDe(nombrePersonaje);
		}
		catch (PersonajeInexistenteException error){
			return this.turnoSiguiente().obtenerPosicionDe(nombrePersonaje);
		}
	}
	
	public void iniciarPersonajes(Jugador jugador1, Jugador jugador2)
	{
		
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Personaje piccolo = new Piccolo();
		Personaje majinBoo = new MajinBoo();
		Personaje cell = new Cell();
		Personaje freezer = new Freezer();
		
		this.listaPerosnajes.add(goku);
		this.listaPerosnajes.add(gohan);
		this.listaPerosnajes.add(piccolo);
		this.listaPerosnajes.add(majinBoo);
		this.listaPerosnajes.add(cell);
		this.listaPerosnajes.add(freezer);
		
		jugador1.agregarPersonaje(goku);
		jugador1.agregarPersonaje(gohan);
		jugador1.agregarPersonaje(piccolo);
		jugador2.agregarPersonaje(majinBoo);
		jugador2.agregarPersonaje(cell);
		jugador2.agregarPersonaje(freezer);
	
		tablero.agregarPersonaje(goku, new Posicion(GOKU_FIL,GOKU_COL));
		tablero.agregarPersonaje(gohan, new Posicion(GOHAN_FIL,GOHAN_COL));
		tablero.agregarPersonaje(piccolo, new Posicion(PICCOLO_FIL,PICCOLO_COL));
		tablero.agregarPersonaje(majinBoo,  new Posicion(MAJIN_BOO_FIL,MAJIN_BOO_COL));
		tablero.agregarPersonaje(cell, new Posicion(CELL_FIL,CELL_FIL));
		tablero.agregarPersonaje(freezer, new Posicion(FREEZER_FIL,FREEZER_COL));
	}

	public int getCantidadDeAtaquesRestantes()
	{
		 return this.turnoActual.getCantidadDeAtaquesRestantes();
			
	}
	
	
	
	public int getCantidadDeMovimientosRestantes() {
		return this.turnoActual.getCantidadDeMovimientosRestantes();
	}

	public Personaje getPersonaje(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}