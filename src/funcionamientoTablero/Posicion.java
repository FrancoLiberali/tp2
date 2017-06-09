package funcionamientoTablero;

import funcionamientoPersonaje.Personaje;
import java.lang.*;

public class Posicion 
{
	private int fila;
	private int columna;
	private Tablero tablero;
	
	public Posicion(int fil, int col, Tablero tableroRepresentado)
	{
		fila = fil;
		columna = col;
		tablero = tableroRepresentado;
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
		Posicion nueva_posicion = new Posicion(this.fila-1, this.columna, this.tablero);
		return nueva_posicion;
	}
	
	public Posicion darDerecha(){
		Posicion nueva_posicion = new Posicion(this.fila+1, this.columna, this.tablero);
		return nueva_posicion;
	}
	
	public Posicion darAbajo(){
		Posicion nueva_posicion = new Posicion(this.fila, this.columna-1, this.tablero);
		return nueva_posicion;
	}
	
	public Posicion darArriba(){
		Posicion nueva_posicion = new Posicion(this.fila, this.columna+1, this.tablero);
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

	public int distanciaConPosicion(Posicion posicionOther) 
	{
		int filaOther = posicionOther.getFila();
		int columnaOther = posicionOther.getColumna();
		double distancia = Math.sqrt((Math.pow(this.fila - filaOther,2) +
				Math.pow(this.columna - columnaOther,2)));
		return (int) distancia;
		
	}

	public Personaje getPersonajeAAtacar(Posicion posicionVictima) {
		return this.tablero.getPersonajeEn(posicionVictima);
	}
}
