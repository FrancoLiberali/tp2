package tablero;

import exceptions.CasilleroVacioException;

public class EstadoVacio implements EstadoCasillero{
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
}
