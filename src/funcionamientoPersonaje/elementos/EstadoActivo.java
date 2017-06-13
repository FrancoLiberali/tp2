package funcionamientoPersonaje.elementos;

import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

public class EstadoActivo implements EstadoActividad
{

	public void aplicarKi(Personaje personaje, int cantidad) {
		personaje.ejecutarAumentoDeKi(cantidad);
	}

	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		personaje.ejecutarMovimiento(nuevaPosicion);
	}
/*
	public int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima) {
		return personaje.ejecutarAtaqueEspecial(posicionVictima);
	}

	public void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima) {
		personaje.ejecutarAtaqueBasico(posicionVictima);
	}
*/
	public void aplicarTransformacion(Personaje personaje) {
		personaje.ejecutarTransformacion();
	}
	
	public void reducirTurnos(){
	}
	
}
