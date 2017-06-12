package funcionamientoPersonaje.elementos;

import exceptions.PersonajeInactivoNoPuedeAtacarException;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;

import static algoBall.ConstantesDelJuego.TURNOS_ESTUNEO_MAJIN_BOO;

public class EstadoInactivoConChocolate implements EstadoActividad 
{
	
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(TURNOS_ESTUNEO_MAJIN_BOO);
	
	public void aplicarKi(Personaje personaje, int cantidad) 
	{}

	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		/*mensaje al usuario*/
	}

	public int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima) {
		throw new PersonajeInactivoNoPuedeAtacarException();
		
	}

	public void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima) {
		throw new PersonajeInactivoNoPuedeAtacarException();
	}

	public void aplicarTransformacion(Personaje personaje) {
		/*mensaje al usuario*/
	}
	
	public void reducirTurnos()
	{
		this.cantTurnos.reducir();
	}
	
	public ContadorDeTurnos getContadorDeTurnos()
	{
		return cantTurnos;
	}


}
