package model.tablero;

import model.personajes.Personaje;

public class Posicion 
{
	private int fila;
	private int columna;
	private Casillero casillero;
	
	public Posicion(int fil, int col)
	{
		fila = fil;
		columna = col;
	}
	
	public void setCasillero(Casillero casillero){
		this.casillero = casillero;
	}
	
	public int getFila()
	{
		return fila;
	}
	
	public int getColumna()
	{
		return columna;
	}
	
	public void vaciar(){
		this.casillero.vaciar();
	}
	
	public void ocupar(Personaje personaje){
		this.casillero.ocupar(personaje);
	}

	public boolean dentroDelRango(Posicion otraPosicion, int rango){
		int difFilas = Math.abs(this.fila - otraPosicion.getFila());
		int difColumnas = Math.abs(this.columna - otraPosicion.getColumna());
		return (difFilas <= rango && difColumnas <= rango);
	}
	
	@Override
	public boolean equals(Object otraPosicion) 
	{
		if (this == otraPosicion){
				return true;
		}
		if (!(otraPosicion instanceof Posicion)){
				return false;
		}
		Posicion otraPos = (Posicion)otraPosicion;
		return otraPos.fila == fila && otraPos.columna == columna;
	}

	@Override
	public int hashCode() 
	{
	    int resultado = fila;
	    resultado = 31 * resultado + columna;
	    return resultado;
	}
	
}
