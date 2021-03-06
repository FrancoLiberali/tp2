package model.consumibles;

import model.algoBall.Posicionable;
import model.personajes.Personaje;
import model.tablero.Posicion;

public abstract class Consumible implements Posicionable
{
	protected String nombre;
	protected Posicion posicion;
	protected String rutaImagen;
	
	public Posicion getPosicion()
	{
		return posicion;
	}
	
	public void setPosicion(Posicion posicion)
	{
		this.posicion = posicion;
	}
	
	public String getImagen(){
		return rutaImagen;
	}
	
	public abstract void aplicarAPersonaje(Personaje personaje);
	
	public abstract void aplicarAPersonajeConTemporalAnterior(Personaje personaje);
}
