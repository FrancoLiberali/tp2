package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class PosicionUnitarioTest {

	@Test
	public void obtenerFilaColumna(){
		Tablero tablero = new Tablero(8);
		Posicion ps = new Posicion(1,2, tablero);
		assertEquals(ps.getFila(), 1);
		assertEquals(ps.getColumna(), 2);
		
	}
	
	@Test
	public void distanciaConOtraPosicion()
	{
		Tablero tablero = new Tablero(8);
		Posicion ps = new Posicion(1,1, tablero);
		Posicion ps2 = new Posicion(3,2, tablero);
		assertEquals(ps.distanciaConPosicion(ps2), 2);
		
	}

}
