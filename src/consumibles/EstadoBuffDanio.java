package consumibles;

import static algoBall.ConstantesDelJuego.ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;

import personajes.elementos.EstadoActividad;
import personajes.elementos.EstadoTransformacion;;

public class EstadoBuffDanio extends EstadoTransformacion 
{
	private EstadoTransformacion anterior; 
	private int porcentajePlusDanio = ESFERA_DEL_DRAGON_PORCENTAJE_PLUS_DANIO;
	
	public EstadoBuffDanio(EstadoActividad anterior) {
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
		this.anterior = estado;
	}

	public EstadoTransformacion getEstadoAnterior()
	{
		return this.anterior;
	}
	
}
