package funcionamientoPersonaje;

import funcionamientoTablero.Posicion;

public class EstadoActivo extends EstadoActividad
{

	@Override
	public void aplicarKi(Personaje personaje, int cantidad) {
		personaje.ejecutarAumentoDeKi(cantidad);
	}

	@Override
	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		personaje.ejecutarMovimiento(nuevaPosicion);
	}

	@Override
	public int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima) {
		return personaje.ejecutarAtaqueEspecial(posicionVictima);
	}

	@Override
	public void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima) {
		personaje.ejecutarAtaqueBasico(posicionVictima);
	}

	@Override
	public void aplicarTransformacion(Personaje personaje) {
		personaje.ejecutarTransformacion();
	}
	
}
