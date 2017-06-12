package funcionamientoPersonaje;

import funcionamientoTablero.Posicion;

public abstract class EstadoActividad implements Estado 
{
	public abstract void aplicarKi(Personaje personaje, int cantidad);
	public abstract void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion);
	public abstract int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima);
	public abstract void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima);
	public abstract void aplicarTransformacion(Personaje personaje);
}
