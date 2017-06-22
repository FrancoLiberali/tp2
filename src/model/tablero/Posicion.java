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
	
	public Posicion darIzquierda(){
		Posicion nueva_posicion = new Posicion(this.fila, this.columna-1);
		return nueva_posicion;
	}
	
	public Posicion darDerecha(){
		Posicion nueva_posicion = new Posicion(this.fila, this.columna+1);
		return nueva_posicion;
	}
	
	public Posicion darAbajo(){
		Posicion nueva_posicion = new Posicion(this.fila+1, this.columna);
		return nueva_posicion;
	}
	
	public Posicion darArriba(){
		Posicion nueva_posicion = new Posicion(this.fila-1, this.columna);
		return nueva_posicion;
	}
	
	public Posicion darArribaIzquierda(){
		return this.darArriba().darIzquierda();
	}
	
	public Posicion darArribaDerecha(){
		return this.darArriba().darDerecha();
	}
	
	public Posicion darAbajoDerecha(){
		return this.darAbajo().darDerecha();
	}
	
	public Posicion darAbajoIzquierda(){
		return this.darAbajo().darIzquierda();
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
