package consumibles;

import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public abstract class EstadoTemporal extends EstadoTransformacion{
	
	@Override
	public boolean esTemporal(){
		return true;
	}
	
	public void setEstadoAnterior(EstadoTransformacion estado)
	{
		
		this.anteriorEstado = estado;
		
	}
	
	@Override
	public void capturarConsumible(Personaje personaje, Consumible consumible) {
		consumible.aplicarAPersonajeConTemporalAnterior(personaje);
	}
	
	@Override
	public void transformar(Personaje personaje, Ki ki){
		anteriorEstado.transformar(personaje, ki);
	}
}
