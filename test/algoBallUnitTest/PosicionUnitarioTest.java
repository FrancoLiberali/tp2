package algoBallUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class PosicionUnitarioTest {

	@Test
	public void obtenerFilaColumna(){
		Posicion ps = new Posicion(1,2);
		assertEquals(ps.getFila(), 1);
		assertEquals(ps.getColumna(), 2);
		
	}
	
	@Test
	public void posicionQueEquidistaDosEstaDentroDelRango2()
	{
		Posicion ps = new Posicion(1,1);
		Posicion ps2 = new Posicion(3,2);
		assertTrue(ps.dentroDelRango(ps2,2));
		
	}
	
	@Test
	public void posicionQueEquidistaTresEstaFueraDelRango2()
	{
		Posicion ps = new Posicion(1,1);
		Posicion ps2 = new Posicion(4,2);
		assertFalse(ps.dentroDelRango(ps2,2));
		
	}

}
