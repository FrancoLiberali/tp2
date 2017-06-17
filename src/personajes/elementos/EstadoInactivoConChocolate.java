package personajes.elementos;

import exceptions.PersonajeEnEstadoChocolate;
import exceptions.PersonajeInactivoNoPuedeAtacarException;
import personajes.Personaje;
import tablero.Posicion;

import static algoBall.ConstantesDelJuego.*;

import consumibles.Consumible;

public class EstadoInactivoConChocolate implements EstadoActividad 
{
	private EstadoActividad estadoSiguiente;
	private EstadoActividad estadoAnterior;
	private String nombre = CHOCOLATE;
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(TURNOS_ESTUNEO_MAJIN_BOO);
	
	public void aplicarKi(Personaje personaje, int cantidad) {}

	public void aplicarMovimiento(Personaje personaje, Posicion nuevaPosicion) {
		throw new PersonajeEnEstadoChocolate();
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
		this.estadoSiguiente = estadoTransformacionActual;
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
	public void transformar(Personaje personaje) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public void realizarAtaqueEspecial(Personaje atacante, Personaje victima) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public void actualizarEstado(Personaje personaje) {
		if (cantTurnos.estaEnCero()){
			personaje.setEstado(estadoAnterior);
			return;
		}
		cantTurnos.reducir();
	}

	@Override
	public void capturarConsumible(Personaje personaje, Consumible consumible) {
		throw new PersonajeEnEstadoChocolate();
	}

	@Override
	public EstadoActividad getEstadoSiguiente() {
		return this.estadoSiguiente;
	}

	@Override
	public EstadoActividad getEstadoAnterior() {
		return this.estadoAnterior;	
	}

	@Override
	public void reducirKi(Personaje personaje, int cantidad) {}


}