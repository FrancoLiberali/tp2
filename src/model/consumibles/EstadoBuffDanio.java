package model.consumibles;

import static model.algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
import static model.algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_TURNOS;

import model.personajes.elementos.ContadorDeTurnos;
import model.personajes.elementos.EstadoActividad;

public class EstadoBuffDanio extends EstadoTemporal 
{
	private int porcentajePlusDanio = ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
	
	public EstadoBuffDanio(EstadoActividad actual) {
		turnos = new ContadorDeTurnos(ESFERA_DEL_DRAGON_TURNOS);
		this.rutaImagen = actual.getImagen();
		this.nombre = actual.getNombre();
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
	
}
