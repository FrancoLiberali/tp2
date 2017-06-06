package Tests;
import static org.junit.Assert.*;
import org.junit.Test;

import algo3.Posicion;
import algo3.Tablero;
import algo3.Personaje;
public class tableroTestUnitario {
	
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
	
	@Test
	public void agregarPersonajeACasillero()
	{
		Tablero tablero = new Tablero(4);
		Personaje x = new Personaje("x");
		Posicion pos = new Posicion(2,2);
		tablero.agregarPersonaje(x, pos);
		assertEquals(tablero.getPersonajeEn(pos).getNombre(), x.getNombre());
		
	}
	
	@Test
	public void moverPersonajeTableroVerificarPosicion()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x");
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(x, posicionInicial);
		tablero.movimientoUnitario(x, 1, 0);
		Posicion posicionFinal = new Posicion(3,2);
		assertEquals(tablero.getPersonajeEn(posicionFinal).getNombre(), x.getNombre());
		
	}
	
	@Test(expected = Exception.class)
	public void moverPersonajeALugarInvalido()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x");
		Personaje y = new Personaje("y");
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		tablero.movimientoUnitario(x, 1, 0);
		
	}
	
}
	
