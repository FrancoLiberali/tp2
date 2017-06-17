package tablero;



import exceptions.FueraDelTableroException;
import personajes.Personaje;

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

	public int getDimension()
	{
		return dimension;
	}
	
	public void agregarPersonaje(Personaje personaje, Posicion pos)
	{
		(this.getCasillero(pos)).ocupar();
		pos.setTablero(this);
		personaje.setPosicion(pos);
	}
	
	public void vaciarCasilleroEnPosicion (Posicion posicion){
		this.getCasillero(posicion).vaciar();
	}
	
	
}

