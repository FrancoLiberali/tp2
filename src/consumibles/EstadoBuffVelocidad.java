package consumibles;

import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD;
import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_TURNOS;

import personajes.Personaje;
import personajes.elementos.ContadorDeTurnos;
import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoTransformacion;

public class EstadoBuffVelocidad extends EstadoTemporal{

	private int multiplicadorVelocidad = NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD;
	private ContadorDeTurnos turnos = new ContadorDeTurnos(NUBE_VOLADORA_TURNOS);
	
	public EstadoBuffVelocidad(EstadoActividad actual) {
		if (actual.esTemporal()){
			EstadoTemporal actualTemporal = (EstadoTemporal) actual;
			this.siguienteEstado = actual;
			actualTemporal.setVelocidad(calcularVelocidad(actual.getVelocidad()));
			this.anteriorEstado = actual.getEstadoAnterior();
			actualTemporal.setEstadoAnterior(this);
			this.distanciaDeAtaque = anteriorEstado.getDistanciaDeAtaque();
			this.poderDePelea = anteriorEstado.getPoderDePelea();
			this.velocidad = calcularVelocidad(anteriorEstado.getVelocidad());
		}
		else{
			this.siguienteEstado = actual.getEstadoSiguiente();
			this.anteriorEstado = actual.getEstadoAnterior();
			this.distanciaDeAtaque = actual.getDistanciaDeAtaque();
			this.poderDePelea = actual.getPoderDePelea();
			this.velocidad = calcularVelocidad(actual.getVelocidad());
		}
	}

	private int calcularVelocidad(int velocidad)
	{
		return velocidad * multiplicadorVelocidad;
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
