package consumibles;

import algoBall.Posicionable;
import personajes.Personaje;
import tablero.Posicion;

public abstract class Consumible implements Posicionable
{
	protected String nombre;
	protected Posicion posicion;
	
	public Posicion getPosicion()
	{
		return posicion;
	}
	
	public void setPosicion(Posicion posicion)
	{
		this.posicion = posicion;
	}
	
	public abstract void aplicarAPersonaje(Personaje personaje);
}
