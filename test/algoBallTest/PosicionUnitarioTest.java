package algoBallTest;

import static org.junit.Assert.*;
import algoBall.Posicion;
import algoBall.Tablero;

import org.junit.Test;

public class PosicionUnitarioTest {

	@Test
	public void obtenerFilaColumna(){
		Tablero tablero = new Tablero(8);
		Posicion ps = new Posicion(1,2, tablero);
		assertEquals(ps.getFila(), 1);
		assertEquals(ps.getColumna(), 2);
		
	}
	
	

}
