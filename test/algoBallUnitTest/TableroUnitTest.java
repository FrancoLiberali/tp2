package algoBallUnitTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.exceptions.CasilleroVacioException;
import model.exceptions.FueraDelTableroException;
import model.personajes.Goku;
import model.personajes.Personaje;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class TableroUnitTest 
{	
	Tablero tablero = Tablero.createInstance(8);
	@Test
	public void crearTableroConDimension4VerificarDimension()
	{
		assertEquals(tablero.getDimension(), 8);
	}
	
	@Test
	public void crearTableroVerificarCasilleroVacio() 
	{
		Posicion pos = new Posicion(2,3);
		
		assertTrue(tablero.getCasillero(pos).estaVacio());
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void vaciarCasilleroEnPosicionDentroDelTableroLanzaCasilleroVacio() 
	{
		Posicion pos = new Posicion(2,3);
		
		tablero.vaciarCasilleroEnPosicion(pos);
	}
	
	@Test(expected = FueraDelTableroException.class)
	public void vaciarCasilleroEnPosicionFueraDelTableroLanzaFueraDelTablero() 
	{
		Posicion pos = new Posicion(9,3);
		
		tablero.vaciarCasilleroEnPosicion(pos);
	}
	
	@Test (expected = FueraDelTableroException.class)
	public void getCasilleroEnPosicionMayorQueLaDimensionLanzaFueraDelTablero() 
	{
		Posicion pos = new Posicion(8,3);
		
		tablero.getCasillero(pos);
	}
	
	@Test (expected = FueraDelTableroException.class)
	public void agregarPersonajeEnPosicionMayorQueLaDimensionLanzaFueraDelTablero() 
	{
		Posicion pos = new Posicion(8,3);
		Personaje goku = new Goku();
		tablero.agregarPosicionable(goku, pos);
	}
	
	@Test
	public void agregarPersonajeACasilleroDentroDelTableroCambiaPosicionDelPersonaje()
	{
		Personaje goku = new Goku();
		Posicion pos = new Posicion(2,2);
		tablero.agregarPosicionable(goku, pos);
		assertEquals(goku.getPosicion(), pos);
		
	}
	
	@Test
	public void vaciarCasillerooDentroDelTableroLeQuitaElPersonaje()
	{
		Personaje goku = new Goku();
		Posicion pos = new Posicion(2,2);
		tablero.agregarPosicionable(goku, pos);
		tablero.vaciarCasilleroEnPosicion(pos);
		assertTrue(tablero.getCasillero(pos).estaVacio());
	}
}
	
