package algoBallUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.SeAcabaronTurnosDelEstadoException;
import funcionamientoPersonaje.elementos.ContadorDeTurnos;


public class ContadorDeTurnosUnitTest 
{
	@Test
	public void crearContadorConDosTurnosVerificarTurnosRestantesEsDos(){
		ContadorDeTurnos cont = new ContadorDeTurnos(2);
		assertEquals(cont.getTurnosRestantes(), 2);
	}
	
	@Test
	public void crearContadorConDosTurnosVerificarTurnosRealizadosEsCero(){
		ContadorDeTurnos cont = new ContadorDeTurnos(2);
		assertEquals(cont.getTrunosRealizados(), 0);
	}
	
	@Test
	public void restarTurnoVerificarTurnoRestantes(){
		ContadorDeTurnos cont = new ContadorDeTurnos(2);
		cont.reducir();
		assertEquals(cont.getTurnosRestantes(), 1);
	}
	
	@Test (expected = SeAcabaronTurnosDelEstadoException.class)
	public void reducirTurnosHastaCeroLanzaSeAcabaronTurnosDelEstado(){
		ContadorDeTurnos cont = new ContadorDeTurnos(2);
		cont.reducir();
		cont.reducir();
	}
	
	@Test
	public void crearContadorConDosTurnosVerificarTurnosRestantesNoEsCero(){
		ContadorDeTurnos cont = new ContadorDeTurnos(2);
		assertTrue(!cont.estaEnCero());
	}
	
	@Test
	public void reestablecerTurnosVerificarCantTurnosRestantesEsElInicial(){
		int turnosIniciales = 10;
		ContadorDeTurnos cont = new ContadorDeTurnos(turnosIniciales);
		cont.reducir();
		cont.reducir();
		cont.reestablecer();
		assertEquals(cont.getTurnosRestantes(), turnosIniciales);
	}
	
}