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
	    
	    for(int i = 1; i < dimension; i++)
            for(int j=1; j < dimension; j++)
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
	
	/*public void movimientoUnitario(Personaje psje, int x, int y)
	{ 
		if (x>1 || y>1){
			throw new MovimientoUnitarioInvalido();
		}
		
		Posicion posicionInicial = psje.getPosicion();
		Posicion posicionFinal = new Posicion( posicionInicial.getFila() + x, posicionInicial.getColumna() + y);
		
		Casillero casilleroInicial = this.getCasillero(posicionInicial);
		Casillero casilleroFinal = this.getCasillero(posicionFinal);
		if(!casilleroFinal.estaVacio()){
			throw new MovimientoUnitarioInvalido();
		}
		
		
		this.agregarPersonaje(psje, posicionFinal);
		casilleroInicial.vaciar();
		psje.setPosicion(posicionFinal);
		}*/
	
	
}

