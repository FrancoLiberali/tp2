package tablero;

import algoBall.Posicionable;
import consumibles.Consumible;
import exceptions.CasilleroVacioException;
import personajes.Personaje;

public class EstadoVacio implements EstadoCasillero{
	private Posicionable consumible = null;
	
	public EstadoVacio()
	{}
	public boolean estaVacio()
	{
		return true;
	}
	public EstadoCasillero ocupar()
	{ 
		return new EstadoOcupado();
	};
	
	public EstadoCasillero vaciar()
	{	
		throw new CasilleroVacioException();
	}
	
	public void agregarConsumible(Posicionable consumible){
		this.consumible = consumible;
	}
	
	public void aplicarConsumible(Posicionable personaje){
		if (consumible != null){
			Personaje personajep = (Personaje)personaje;
			personajep.agarrarConsumible((Consumible)consumible);
			consumible = null;
		}
	}
	
	public Posicionable getConsumible(){
		return consumible;
	}
}
