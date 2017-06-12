package funcionamientoPersonaje;

import exceptions.PersonajeInactivoNoPuedeAtacarException;
import exceptions.PersonajeInactivoNoPuedeMoverseException;
import exceptions.PersonajeInactivoNoPuedeTransformarseException;
import funcionamientoTablero.Posicion;

import static algoBall.ConstantesDelJuego.TURNOS_ESTUNEO_MAJIN_BOO;

public class EstadoInactivoConChocolate extends EstadoActividad 
{
	
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(TURNOS_ESTUNEO_MAJIN_BOO);
	
	@Override
	public void aplicarKi(Personaje personaje, int cantidad) 
	{
		if(!this.cantTurnos.estaEnCero()){
			return;
		}
		personaje.setEstadoActividad(new EstadoActivo());
	}

	@Override
	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		if(!this.cantTurnos.estaEnCero()){
			throw new PersonajeInactivoNoPuedeMoverseException();
		}
	}

	@Override
	public int aplicarAtaqueEspecial(Personaje personaje, Posicion posicionVictima) {
		if(!this.cantTurnos.estaEnCero()){
			throw new PersonajeInactivoNoPuedeAtacarException();
		}
		return 0;
		
	}

	@Override
	public void aplicarAtaqueBasico(Personaje personaje, Posicion posicionVictima) {
		if(!this.cantTurnos.estaEnCero()){
			throw new PersonajeInactivoNoPuedeAtacarException();
		}
	}

	@Override
	public void aplicarTransformacion(Personaje personaje) {
		if(!this.cantTurnos.estaEnCero()){
			throw new PersonajeInactivoNoPuedeTransformarseException();
		}
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
