package algoBallTest;

import static org.junit.Assert.*;
import algoBall.Posicion;
import org.junit.Test;

public class PosicionUnitarioTest {

	@Test
	public void obtenerFilaColumna(){
		Posicion ps = new Posicion(1,2);
		assertEquals(ps.getFila(), 1);
		assertEquals(ps.getColumna(), 2);
		
	}
	
	

}
