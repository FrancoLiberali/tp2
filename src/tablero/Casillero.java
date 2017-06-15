package tablero;

import exceptions.CasilleroOcupadoException;
import exceptions.CasilleroVacioException;
import personajes.Personaje;

public class Casillero {

	private Personaje personaje;
	//private Consumible consumible;
	
	
	public Casillero()
	{
		this.personaje = null;
	}
	
	public boolean estaVacio()
	{
		return (this.personaje == null);
	}
	
	public void setPersonaje(Personaje psje)
	{
		if(!this.estaVacio()){
			 throw new CasilleroOcupadoException();
		}
		
		this.personaje = psje;
	}
	
	public Personaje vaciar()
	{
		if(this.estaVacio()){
			throw new CasilleroVacioException();
		}
		
		Personaje psje = this.personaje;
		this.personaje = null;
		return psje;
	}
	
	public Personaje getPersonaje()
	{
		if(this.estaVacio()){
			throw new CasilleroVacioException();
		}
		return this.personaje;
	}

}
