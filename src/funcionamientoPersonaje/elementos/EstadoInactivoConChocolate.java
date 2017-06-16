package funcionamientoPersonaje.elementos;

import exceptions.PersonajeEnEstadoChocolate;
import exceptions.PersonajeInactivoNoPuedeAtacarException;
import personajes.Personaje;
import tablero.Posicion;

import static algoBall.ConstantesDelJuego.*;

public class EstadoInactivoConChocolate implements EstadoActividad 
{
	private String nombre = CHOCOLATE;
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(TURNOS_ESTUNEO_MAJIN_BOO);
	private EstadoActividad siguienteEstado;

	
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

	
	
	public void reducirTurnos()
	{
		this.cantTurnos.reducir();
	}
	
	public ContadorDeTurnos getContadorDeTurnos()
	{
		return cantTurnos;
	}

	public void setSiguienteEstado(EstadoActividad estadoTransformacionActual, int i) {
		this.siguienteEstado = estadoTransformacionActual;
	}

	@Override
	public int getVelocidad() {
		
		return 0;
	}

	@Override
	public int getPoderDePelea() {
		
		return 0;
	}

	@Override
	public int getDistanciaDeAtaque() {
		
		return 0;
	}


	@Override
	public void realizarAtaqueBasico(Personaje victima) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public void realizarAtaqueEspecial(Personaje victima, int porcentaje) {
		throw new PersonajeEnEstadoChocolate();
		
	}

	@Override
	public EstadoActividad transformar(Ki ki) {
		return this.siguienteEstado;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}


}
