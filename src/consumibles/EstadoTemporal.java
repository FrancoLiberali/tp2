package consumibles;

import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

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
}
