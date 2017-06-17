package consumibles;

import static algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
import static algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_TURNOS;

import personajes.Personaje;
import personajes.elementos.ContadorDeTurnos;
import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoTransformacion;

public class EstadoBuffDanio extends EstadoTransformacion 
{
	private ContadorDeTurnos turnos = new ContadorDeTurnos(ESFERA_DEL_DRAGON_TURNOS);
	private int porcentajePlusDanio = ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
	
	public EstadoBuffDanio(EstadoActividad actual) {
		this.anteriorEstado = actual.getEstadoAnterior();
		this.siguienteEstado = actual.getEstadoSiguiente();
		this.distanciaDeAtaque = actual.getDistanciaDeAtaque();
		this.velocidad = actual.getVelocidad();
		this.setPoderDePelea(this.calcularDanio(actual.getPoderDePelea(), porcentajePlusDanio));
	}

	private int calcularDanio(int danio, int plusPorcentaje)
	{
		return danio + (danio*plusPorcentaje)/100;
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
