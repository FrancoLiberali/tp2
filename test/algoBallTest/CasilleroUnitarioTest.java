package algoBallTest;

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
	public void crearCasilleroVacio(){
		Casillero c1 = new Casillero();
		assertTrue(c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoCasilleroNoVacio(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX);
		c1.setPersonaje(x);
		assertTrue(!c1.estaVacio());
	}
	
	@Test
	public void agregarPersonajeVerificoNombre(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX);
		c1.setPersonaje(x);
		assertEquals(c1.getPersonaje().getNombre(), x.getNombre());
	}
	
	@Test
	public void vaciarCasilleroDevuelvePersonajeDeseado(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX);
		c1.setPersonaje(x);
		Personaje deseado = c1.vaciar();
		assertEquals(x.getNombre(), deseado.getNombre());
	}
	
	public void vaciarCasilleroVerificarQueQuedeVacio(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX);
		c1.setPersonaje(x);
		c1.vaciar();
		assertTrue(c1.estaVacio());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void tratarDeAgregarDosPersonajesLevantaExcepcion(){
		Casillero c1 = new Casillero();
		Personaje x = new Personaje("x",estadoX);
		Personaje y = new Personaje("y",estadoX);
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