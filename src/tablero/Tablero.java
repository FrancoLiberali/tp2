package tablero;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import algoBall.Posicionable;
import consumibles.Consumible;
import exceptions.FueraDelTableroException;

public class Tablero 
{
	private int dimension;
	private Casillero tableroDeCasilleros[][];
	private List<Posicionable> posiblesConsumibles;
	Hashtable<Posicion,Consumible> consumiblesActuales = new Hashtable<Posicion,Consumible>();
	
	public Tablero(int dimension)
	{
		this.dimension = dimension;
	    tableroDeCasilleros = new Casillero[dimension][dimension];
	    
	    for(int i = 0; i < dimension; i++)
            for(int j=0; j < dimension; j++)
                tableroDeCasilleros[i][j] = new Casillero();
	}
	
	public void setConsumibles(List<Posicionable> consumibles){
		this.posiblesConsumibles = consumibles;
	}
	
	public void aparecerConsumible(){
		if (this.debeAparecerConsumibleEsteTurno()){
			int randomNum = ThreadLocalRandom.current().nextInt(0, posiblesConsumibles.size());
			Posicionable consumible = posiblesConsumibles.get(randomNum);
			int randomFila = ThreadLocalRandom.current().nextInt(0, dimension);
			int randomColumna = ThreadLocalRandom.current().nextInt(0, dimension);
			if (tableroDeCasilleros[randomFila][randomColumna].estaVacio()){
				tableroDeCasilleros[randomFila][randomColumna].agregarConsumible(consumible);
				consumiblesActuales.put(new Posicion(randomFila,randomColumna),(Consumible)consumible);
			}
		}
		
	}
	
	private boolean debeAparecerConsumibleEsteTurno(){
		int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
		return (randomNum==0);//10% de posibilidad de que deba aparecer
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
	
	public Hashtable<Posicion,Consumible> getPosicionesYConsumibles(){
		Hashtable<Posicion,Consumible> consumibles= new Hashtable<Posicion,Consumible>();
		for(int i = 0; i < dimension; i++){
            for(int j=0; j < dimension; j++){
                Posicionable consumible = tableroDeCasilleros[i][j].getConsumible();
                if (consumible!=null){
                	consumibles.put(new Posicion(i,j), (Consumible) consumible);
                }
            }
		}
		return consumibles;
		
	}
	
}

