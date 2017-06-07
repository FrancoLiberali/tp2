package algoBallTest;

import static org.junit.Assert.*;
import org.junit.Test;

import algoBall.Casillero;
import algoBall.CasilleroOcupadoException;
import algoBall.CasilleroVacioException;
import algoBall.Personaje;

public class CasilleroUnitarioTest{
	

	@Test
	public void crearCasilleroVacio(){
		Casillero c1 = new Casillero();
		assertTrue(c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoCasilleroNoVacio(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		c1.setPersonaje(x);
		assertTrue(!c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoNombre(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		c1.setPersonaje(x);
		assertEquals(c1.getPersonaje().getNombre(), x.getNombre());
	}
	
	@Test
	public void vaciarCasilleroDevuelvePersonajeDeseado(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		c1.setPersonaje(x);
		Personaje deseado = c1.vaciar();
		assertEquals(x.getNombre(), deseado.getNombre());
	}
	
	public void vaciarCasilleroVerificarQueQuedeVacio(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		c1.vaciar();
		assertTrue(c1.estaVacio());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void tratarDeAgregarDosPersonajesLevantaExcepcion(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x");
		Personaje y = new Personaje("y");
		c1.setPersonaje(x);
		c1.setPersonaje(y);
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void pruebaObtenerPersonajeCasilleroVacioLevantaExcepcion(){
		Casillero c1 = new Casillero();
		Personaje psje = c1.getPersonaje();
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void pruebaVaciarCasilleroVacioLevantaExcepcion(){
		Casillero c1 = new Casillero();
		c1.vaciar();
	}
}