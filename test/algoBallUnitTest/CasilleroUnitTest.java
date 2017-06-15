package algoBallUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.CasilleroOcupadoException;
import exceptions.CasilleroVacioException;
import personajes.Goku;
import personajes.MajinBoo;
import personajes.Personaje;
import tablero.Casillero;

public class CasilleroUnitTest
{
	@Test
	public void CasilleroRecienCreadoEstaVacio(){
		Casillero c1 = new Casillero();
		assertTrue(c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoCasilleroNoVacio(){
		Casillero c1 = new Casillero();
		Personaje goku = new Goku();
		c1.setPersonaje(goku);
		assertTrue(!c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoQueSeAgrege(){
		Casillero c1 = new Casillero();
		Personaje goku = new Goku();
		c1.setPersonaje(goku);
		assertEquals(c1.getPersonaje(), goku);
	}
	
	@Test
	public void vaciarCasilleroDevuelvePersonajeDeseado(){
		Casillero c1 = new Casillero();
		Personaje goku = new Goku();
		c1.setPersonaje(goku);
		Personaje deseado = c1.vaciar();
		assertEquals(goku, deseado);
	}
	
	public void vaciarCasilleroVerificarQueQuedeVacio(){
		Casillero c1 = new Casillero();
		Personaje goku = new Goku();
		c1.setPersonaje(goku);
		c1.vaciar();
		assertTrue(c1.estaVacio());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void tratarDeAgregarDosPersonajesLevantaExcepcion(){
		Casillero c1 = new Casillero();
		Personaje goku = new Goku();
		Personaje majinBoo = new MajinBoo();
		c1.setPersonaje(goku);
		c1.setPersonaje(majinBoo);
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void pruebaObtenerPersonajeCasilleroVacioLevantaExcepcion(){
		Casillero c1 = new Casillero();
		c1.getPersonaje();
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void pruebaVaciarCasilleroVacioLevantaExcepcion(){
		Casillero c1 = new Casillero();
		c1.vaciar();
	}
}