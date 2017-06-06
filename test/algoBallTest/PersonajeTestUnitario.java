package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algoBall.Personaje;
import algoBall.Posicion;

public class PersonajeTestUnitario {

	@Test
	public void CrearPersonaje() {
		Personaje x = new Personaje("x");
		assertEquals(x.getNombre(),"x");
	}
	
	@Test
	public void verificarPosicion(){
		Personaje x = new Personaje("x");
		Posicion xy = new Posicion(1,1);
		x.setPosicion(xy);
		assertEquals(x.getPosicion().getFila(),1);
		assertEquals(x.getPosicion().getColumna(),1);
		
	}
	
	@Test
	public void verificarVelocidad(){
		Personaje x = new Personaje("x");
		x.setVelocidad(5);
		assertEquals(x.getVelocidad(), 5);
	}
	
	
}
