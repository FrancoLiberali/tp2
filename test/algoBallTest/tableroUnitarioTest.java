package algoBallTest;
import static org.junit.Assert.*;
import org.junit.Test;

import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;
public class tableroUnitarioTest {
	
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
		Posicion pos = new Posicion(2,3, tablero);
		
		assertTrue(tablero.getCasillero(pos).estaVacio());
	}
	
	@Test
	public void agregarPersonajeACasillero()
	{
		Tablero tablero = new Tablero(4);
		Personaje x = new Personaje("x");
		Posicion pos = new Posicion(2,2, tablero);
		tablero.agregarPersonaje(x, pos);
		assertEquals(tablero.getPersonajeEn(pos).getNombre(), x.getNombre());
		
	}
	
}
	
