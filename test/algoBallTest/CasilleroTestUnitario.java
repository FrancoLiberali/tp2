package algoBallTest;

import static org.junit.Assert.*;
import org.junit.Test;

import algoBall.Casillero;
import algoBall.Personaje;

public class CasilleroTestUnitario{
	

	@Test
	public void crearCasilleroVacio(){
		Casillero c1 = new Casillero();
		assertTrue(c1.estaVacio());
	}
	
	@Test
	public void agregarPersonaje(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		c1.setPersonaje(x);
		assertEquals(c1.getPersonaje().getNombre(), x.getNombre());
		
	
	}
	
	@Test
	public void vaciar(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		c1.setPersonaje(x);
		c1.vaciar();
		assertTrue(c1.estaVacio());
		
	
	}
	
	@Test(expected = Exception.class)
	public void tratarDeAgregarDosPersonajes(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		Personaje y = new Personaje("y");
		c1.setPersonaje(x);
		c1.setPersonaje(y);
		
	
	}
}