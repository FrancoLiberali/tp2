package consumibles;

import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD;
import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_TURNOS;

import personajes.Personaje;
import personajes.elementos.ContadorDeTurnos;
import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoTransformacion;

public class EstadoBuffVelocidad extends EstadoTransformacion {

	private int multiplicadorVelocidad = NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD;
	private ContadorDeTurnos turnos = new ContadorDeTurnos(NUBE_VOLADORA_TURNOS);
	
	public EstadoBuffVelocidad(EstadoActividad actual) {
		this.anteriorEstado = actual.getEstadoAnterior();
		this.siguienteEstado = actual.getEstadoSiguiente();
		this.distanciaDeAtaque = actual.getDistanciaDeAtaque();
		this.poderDePelea = actual.getPoderDePelea();
		this.velocidad = calcularVelocidad(actual.getVelocidad());
	}

	private int calcularVelocidad(int velocidad)
	{
		return velocidad * multiplicadorVelocidad;
	}
	
	public void setEstadoAnterior(EstadoTransformacion estado)
	{
		this.anteriorEstado = estado;
	}

	public EstadoActividad getEstadoAnterior()
	{
		return this.anteriorEstado;
	}
	
	@Override
	public void actualizarEstado(Personaje personaje) {
		if (turnos.estaEnCero()){
			personaje.setEstado(anteriorEstado);
			return;
		}
		turnos.reducir();
	}
}
