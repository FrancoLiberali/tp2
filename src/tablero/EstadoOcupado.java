package tablero;

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
}
