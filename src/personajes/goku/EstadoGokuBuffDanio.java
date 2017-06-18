package personajes.goku;

import static algoBall.ConstantesDelJuego.PORCENTAJE_AUMENTO_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;

import personajes.Personaje;
import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoTransformacion;

public class EstadoGokuBuffDanio extends EstadoTransformacion {

	private int porcentajePlusDanio = PORCENTAJE_AUMENTO_DANIO_GOKU;
		
	public EstadoGokuBuffDanio(EstadoActividad anterior) {
		this.anteriorEstado = anterior;
		this.siguienteEstado = anterior.getEstadoSiguiente();
		this.distanciaDeAtaque = anterior.getDistanciaDeAtaque();
		this.velocidad = anterior.getVelocidad();
		this.setPoderDePelea(this.calcularDanio(anterior.getPoderDePelea(), porcentajePlusDanio));
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
	public void actualizarEstado(Personaje goku)
	{
		if(goku.getPorcentajeSalud() > PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU){
			goku.setEstado(this.anteriorEstado);
		}
	}
		
}
