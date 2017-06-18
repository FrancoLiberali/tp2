package tablero;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import algoBall.Posicionable;
import exceptions.FueraDelTableroException;

public class Tablero 
{
	private int dimension;
	private Casillero tableroDeCasilleros[][];
	private List<Posicionable> consumibles;
	
	public Tablero(int dimension)
	{
		this.dimension = dimension;
	    tableroDeCasilleros = new Casillero[dimension][dimension];
	    
	    for(int i = 0; i < dimension; i++)
            for(int j=0; j < dimension; j++)
                tableroDeCasilleros[i][j] = new Casillero();
	}
	
	public void setConsumibles(List<Posicionable> consumibles){
		this.consumibles = consumibles;
	}
	
	public void aparecerConsumible(){
		if (this.debeAparecerConsumibleEsteTurno()){
			int randomNum = ThreadLocalRandom.current().nextInt(0, consumibles.size() + 1);
			Posicionable consumible = consumibles.get(randomNum);
			int randomFila = ThreadLocalRandom.current().nextInt(0, dimension + 1);
			int randomColumna = ThreadLocalRandom.current().nextInt(0, dimension + 1);
			tableroDeCasilleros[randomFila][randomColumna].agregarConsumible(consumible);
		}
		
	}
	
	private boolean debeAparecerConsumibleEsteTurno(){
		int randomNum = ThreadLocalRandom.current().nextInt(0, 5 + 1);
		return (randomNum==0);//25% de posibilidad de que deba aparecer
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

	public int getDimension()
	{
		return dimension;
	}
	
	public void agregarPosicionable(Posicionable personaje, Posicion posicion)
	{
		(this.getCasillero(posicion)).ocupar(personaje);
		posicion.setTablero(this);
		personaje.setPosicion(posicion);
	}
	
	public void vaciarCasilleroEnPosicion (Posicion posicion){
		this.getCasillero(posicion).vaciar();
	}
	
}

