package funcionamientoPersonaje.elementos;

import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

public interface EstadoActividad
{
	public abstract void aplicarKi(Personaje personaje, int cantidad);
	public abstract void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion);
	//public abstract int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima);
	//public abstract void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima);
	public abstract void aplicarTransformacion(Personaje personaje);
	public abstract void reducirTurnos();
}
