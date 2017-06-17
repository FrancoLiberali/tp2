package consumibles;

import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD;
import static algoBall.ConstantesDelJuego.NUBE_VOLADORA_TURNOS;

import personajes.elementos.ContadorDeTurnos;
import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoTransformacion;

public class EstadoBuffVelocidad extends EstadoTransformacion {

	private EstadoTransformacion anterior; 
	private int multiplicadorVelocidad = NUBE_VOLADORA_MULTIPLICADOR_VELOCIDAD;
	private ContadorDeTurnos cantTurnos = new ContadorDeTurnos(NUBE_VOLADORA_TURNOS);
	
	public EstadoBuffVelocidad(EstadoActividad anterior) {
		this.distanciaDeAtaque = anterior.getDistanciaDeAtaque();
		this.poderDePelea = anterior.getPoderDePelea();
		this.velocidad = calcularVelocidad(anterior.getVelocidad());
	}

	private int calcularVelocidad(int velocidad)
	{
		return velocidad * multiplicadorVelocidad;
	}
	
	public void setEstadoAnterior(EstadoTransformacion estado)
	{
		this.anterior = estado;
	}

	public EstadoTransformacion getEstadoAnterior()
	{
		return this.anterior;
	}
	
	public void reducirTurno()
	{
		cantTurnos.reducir();
	}
}
