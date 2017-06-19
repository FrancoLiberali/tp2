package consumibles;

import static algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
import static algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_TURNOS;

import personajes.Personaje;
import personajes.elementos.ContadorDeTurnos;
import personajes.elementos.EstadoActividad;

public class EstadoBuffDanio extends EstadoTemporal 
{
	private ContadorDeTurnos turnos = new ContadorDeTurnos(ESFERA_DEL_DRAGON_TURNOS);
	private int porcentajePlusDanio = ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
	
	public EstadoBuffDanio(EstadoActividad actual) {
		this.rutaImagen = actual.getImagen();
		if (actual.esTemporal()){
			EstadoTemporal actualTemporal = (EstadoTemporal) actual;
			this.siguienteEstado = actual;
			actualTemporal.setPoderDePelea(this.calcularDanio(actual.getPoderDePelea(), porcentajePlusDanio));
			this.anteriorEstado = actual.getEstadoAnterior();
			actualTemporal.setEstadoAnterior(this);
			this.distanciaDeAtaque = anteriorEstado.getDistanciaDeAtaque();
			this.velocidad = anteriorEstado.getVelocidad();
			this.setPoderDePelea(this.calcularDanio(anteriorEstado.getPoderDePelea(), porcentajePlusDanio));
		}
		else{
			this.siguienteEstado = actual.getEstadoSiguiente();
			this.anteriorEstado = actual.getEstadoAnterior();
			this.distanciaDeAtaque = actual.getDistanciaDeAtaque();
			this.velocidad = actual.getVelocidad();
			this.setPoderDePelea(this.calcularDanio(actual.getPoderDePelea(), porcentajePlusDanio));
		}
		
		
	}

	private int calcularDanio(int danio, int plusPorcentaje)
	{
		return danio + (danio*plusPorcentaje)/100;
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
