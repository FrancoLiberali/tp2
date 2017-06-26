package model.consumibles;

import model.personajes.Personaje;
import model.personajes.elementos.ContadorDeTurnos;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public abstract class EstadoTemporal extends EstadoTransformacion{
	
	protected ContadorDeTurnos turnos;
	
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
	
	@Override
	public void actualizarEstado(Personaje personaje) {
		if (turnos.estaEnCero()){
			personaje.setEstado(anteriorEstado);
			return;
		}
		turnos.reducir();
		anteriorEstado.actualizarEstado(personaje);
	}
}
