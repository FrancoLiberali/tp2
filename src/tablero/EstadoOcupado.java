package tablero;

import algoBall.Posicionable;
import exceptions.CasilleroOcupadoException;

public class EstadoOcupado implements EstadoCasillero{
	public EstadoOcupado()
	{}
	public boolean estaVacio()
	{
		return false;
	}
	public EstadoCasillero ocupar()
	{ 
		throw new CasilleroOcupadoException();
	};
	
	public EstadoCasillero vaciar()
	{	
		return new EstadoVacio();
	}
	
	public void agregarConsumible(Posicionable consumible){}
	
	public void aplicarConsumible(Posicionable personaje){}
	
	public Posicionable getConsumible(){
		return null;
	}
}
