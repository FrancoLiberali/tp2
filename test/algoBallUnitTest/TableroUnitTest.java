package algoBallUnitTest;
import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.CasilleroVacioException;
import exceptions.FueraDelTableroException;
import personajes.Goku;
import personajes.Personaje;
import tablero.Posicion;
import tablero.Tablero;
import vistas.Aplicacion;

public class TableroUnitTest 
{	
	Aplicacion aplicacion = new Aplicacion();
	
	@Test
	public void crearTableroConDimension4VerificarDimension()
	{
		Tablero tablero = new Tablero(4);
		assertEquals(tablero.getDimension(), 4);
	}
	
	@Test
	public void crearTableroVerificarCasilleroVacio() 
	{
		Tablero tablero = new Tablero(8);
		Posicion pos = new Posicion(2,3);
		
		assertTrue(tablero.getCasillero(pos).estaVacio());
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void vaciarCasilleroEnPosicionDentroDelTableroLanzaCasilleroVacio() 
	{
		Tablero tablero = new Tablero(8);
		Posicion pos = new Posicion(2,3);
		
		tablero.vaciarCasilleroEnPosicion(pos);
	}
	
	@Test(expected = FueraDelTableroException.class)
	public void vaciarCasilleroEnPosicionFueraDelTableroLanzaFueraDelTablero() 
	{
		Tablero tablero = new Tablero(8);
		Posicion pos = new Posicion(9,3);
		
		tablero.vaciarCasilleroEnPosicion(pos);
	}
	
	@Test (expected = FueraDelTableroException.class)
	public void getCasilleroEnPosicionMayorQueLaDimensionLanzaFueraDelTablero() 
	{
		Tablero tablero = new Tablero(8);
		Posicion pos = new Posicion(8,3);
		
		tablero.getCasillero(pos);
	}
	
	@Test (expected = FueraDelTableroException.class)
	public void agregarPersonajeEnPosicionMayorQueLaDimensionLanzaFueraDelTablero() 
	{
		Tablero tablero = new Tablero(8);
		Posicion pos = new Posicion(8,3);
		Personaje goku = new Goku();
		tablero.agregarPosicionable(goku, pos);
	}
	
	@Test
	public void agregarPersonajeACasilleroDentroDelTableroCambiaPosicionDelPersonaje()
	{
		Tablero tablero = new Tablero(4);
		Personaje goku = new Goku();
		Posicion pos = new Posicion(2,2);
		tablero.agregarPosicionable(goku, pos);
		assertEquals(goku.getPosicion(), pos);
		
	}
	
	@Test
	public void vaciarCasillerooDentroDelTableroLeQuitaElPersonaje()
	{
		Tablero tablero = new Tablero(4);
		Personaje goku = new Goku();
		Posicion pos = new Posicion(2,2);
		tablero.agregarPosicionable(goku, pos);
		tablero.vaciarCasilleroEnPosicion(pos);
		assertTrue(tablero.getCasillero(pos).estaVacio());
	}
}
	
