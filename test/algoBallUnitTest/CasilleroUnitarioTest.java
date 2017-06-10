package algoBallUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.CasilleroOcupadoException;
import exceptions.CasilleroVacioException;
import funcionamientoPersonaje.EstadoTransformacion;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Casillero;

public class CasilleroUnitarioTest{
	private EstadoTransformacion estadoX = new EstadoTransformacion("normalx",40,2,4);

	@Test
	public void CasilleroRecienCreadoEstaVacio(){
		Casillero c1 = new Casillero();
		assertTrue(c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoCasilleroNoVacio(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX,2);
		c1.setPersonaje(x);
		assertTrue(!c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoQueSeAgrege(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX,2);
		c1.setPersonaje(x);
		assertEquals(c1.getPersonaje(), x);
	}
	
	@Test
	public void vaciarCasilleroDevuelvePersonajeDeseado(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX,2);
		c1.setPersonaje(x);
		Personaje deseado = c1.vaciar();
		assertEquals(x, deseado);
	}
	
	public void vaciarCasilleroVerificarQueQuedeVacio(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX,2);
		c1.setPersonaje(x);
		c1.vaciar();
		assertTrue(c1.estaVacio());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void tratarDeAgregarDosPersonajesLevantaExcepcion(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX,2);
		Personaje y = new Personaje("y",estadoX,2);
		c1.setPersonaje(x);
		c1.setPersonaje(y);
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