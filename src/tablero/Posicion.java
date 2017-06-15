package tablero;

import personajes.Personaje;

public class Posicion 
{
	private int fila;
	private int columna;
	private Tablero tablero;
	
	public Posicion(int fil, int col)
	{
		fila = fil;
		columna = col;
	}
	
	public void setTablero(Tablero tablero){
		this.tablero = tablero;
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
		nueva_posicion.setTablero(tablero);
		return nueva_posicion;
	}
	
	public Posicion darDerecha(){
		Posicion nueva_posicion = new Posicion(this.fila, this.columna+1);
		nueva_posicion.setTablero(tablero);
		return nueva_posicion;
	}
	
	public Posicion darAbajo(){
		Posicion nueva_posicion = new Posicion(this.fila+1, this.columna);
		nueva_posicion.setTablero(tablero);
		return nueva_posicion;
	}
	
	public Posicion darArriba(){
		Posicion nueva_posicion = new Posicion(this.fila-1, this.columna);
		nueva_posicion.setTablero(tablero);
		return nueva_posicion;
	}
	
	public void vaciarTableroEnPos(){
		this.tablero.vaciarCasilleroEnPosicion(this);
	}
	
	public void ponerEnTablero(Personaje personaje){
		this.tablero.agregarPersonaje(personaje, this);
	}
	
	public boolean esIgualA(Posicion otraPosicion){
		return (this.fila == otraPosicion.getFila() && this.columna==otraPosicion.getColumna());
	}
	
	public boolean dentroDelRango(Posicion otraPosicion, int rango){
		int difFilas = Math.abs(this.fila - otraPosicion.getFila());
		int difColumnas = Math.abs(this.columna - otraPosicion.getColumna());
		return (difFilas <= rango && difColumnas <= rango);
	}

	public Personaje getPersonaje() {
		return this.tablero.getPersonajeEn(this);
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
