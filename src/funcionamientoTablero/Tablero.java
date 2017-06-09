package funcionamientoTablero;

import exceptions.FueraDelTableroException;
import funcionamientoPersonaje.Personaje;

public class Tablero 
{
	private int dimension;
	private Casillero tableroDeCasilleros[][];
	
	public Tablero(int dimension)
	{
		this.dimension = dimension;
	    tableroDeCasilleros = new Casillero[dimension][dimension];
	    
	    for(int i = 0; i < dimension; i++)
            for(int j=0; j < dimension; j++)
                tableroDeCasilleros[i][j] = new Casillero();

	    
	}
	
	public Casillero getCasillero(Posicion pos)
	{
		try{
			return (this.tableroDeCasilleros[pos.getFila()][pos.getColumna()]);
		}
		catch (IndexOutOfBoundsException error){
			throw new FueraDelTableroException();
		}
	}
	
	public Personaje getPersonajeEn(Posicion pos)
	{
		return ((this.getCasillero(pos)).getPersonaje());
	}
	

	public int getDimension()
	{
		return dimension;
	}

	public void agregarPersonaje(Personaje psje, Posicion pos)
	{
		(this.getCasillero(pos)).setPersonaje(psje);
		psje.setPosicion(pos);
	}

	public int cantPersonajes() {
		// TODO Auto-generated method stub
		return 1;
	}
	public void vaciarCasilleroEnPosicion (Posicion posicion){
		Casillero casilleroEnPos = this.getCasillero(posicion);
		casilleroEnPos.vaciar();
	}
	
	
}

