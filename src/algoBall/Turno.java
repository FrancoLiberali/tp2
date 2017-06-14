package algoBall;

import exceptions.FueraDeRangoException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.KiInsuficienteException;
import exceptions.PersonajeInactivoNoPuedeAtacarException;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoTablero.Posicion;

public class Turno {
	private Jugador jugador;
	private int cantidadDeAtaquesRestantes;
	private Turno turnoSiguiente;
	
	public Turno(Jugador jugador){
		this.jugador = jugador;
		this.cantidadDeAtaquesRestantes = 1;
		this.reestablecer();
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
	
	/*public void realizarAtaqueBasico(String nombrePersonaje, Posicion posicionVictima){
		if (cantidadDeAtaquesRestantes == 0){
			//mensaje al usuario
			return;
		}
		try{
			this.jugador.realizarAtaqueBasico( nombrePersonaje, posicionVictima);
			this.cantidadDeAtaquesRestantes = 0;
		}
		catch (FueraDeRangoException error){
			//mensaje al usuario
		}
		catch (IntentandoAtacarAUnCompanieroException error){
			//mensaje al usuario
		}
		catch (PersonajeInactivoNoPuedeAtacarException error){
			//mensaje al usuario
		}
	}
	
	public void realizarAtaqueEspecial(String nombrePersonaje, Posicion posicionVictima){
		if (cantidadDeAtaquesRestantes == 0){
			//mensaje al usuario
			return;
		}
		try{
			this.jugador.realizarAtaqueEspecial( nombrePersonaje, posicionVictima);
			this.cantidadDeAtaquesRestantes = 0;
		}
		catch (FueraDeRangoException error){
			//mensaje al usuario
		}
		catch (IntentandoAtacarAUnCompanieroException error){
			//mensaje al usuario
		}
		catch (KiInsuficienteException error){
			//mensaje al usuario
		}
		catch (PersonajeInactivoNoPuedeAtacarException error){
			//mensaje al usuario
		}
	}
	*/
	public Posicion obtenerPosicionDe(String nombrePersonaje){
		return this.jugador.obtenerPosicionDe(nombrePersonaje);
	}
	
	public int obtenerSaludDe(String nombrePersonaje){
		return this.jugador.obtenerSaludDe(nombrePersonaje);
	}
	public int getKiDe(String nombrePersonaje){
		return this.jugador.getKiDe(nombrePersonaje);
	}
	
}


