package algoBallUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algoBall.Agrupacion;
import funcionamientoPersonaje.elementos.*;
import funcionamientoPersonaje.personajes.Goku;
import funcionamientoPersonaje.personajes.MajinBoo;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.*;
import exceptions.*;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.KI_POR_TURNO;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;

public class MajinBooUnitTest 
{
	@Test (expected = PersonajeEnEstadoChocolate.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuIntentarAtacarCongGokuLevantaExcepcion()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(100);
		goku.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(majinBoo, posicionInicialX);
		tablero.agregarPersonaje(goku, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		goku.realizarAtaqueBasico(majinBoo);
	}
	
	@Test 
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteNoPuedeGanarKi()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(majinBoo, posicionInicialX);
		tablero.agregarPersonaje(goku, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		goku.aumentarKi(100);
		
		assertEquals(goku.getKi(), KI_INICIAL);
	}
	
	@Test
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteNoPuedeTansformarse()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(100);
		goku.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(majinBoo, posicionInicialX);
		tablero.agregarPersonaje(goku, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		goku.transformar();
		assertEquals(goku.getEstadoActividad().getNombre(), NOMBRE_TRANF_NORMAL);
	}
	
	@Test (expected = PersonajeEnEstadoChocolate.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteNoPuedeMoverse()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(100);
		goku.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(majinBoo, posicionInicialX);
		tablero.agregarPersonaje(goku, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		goku.moverDerecha();
		
	}
	
	@Test
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteGanaKiLuegoTresTurnos()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(majinBoo, posicionInicialX);
		tablero.agregarPersonaje(goku, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		EstadoInactivoConChocolate estado = (EstadoInactivoConChocolate)goku.getEstadoActividad();
		ContadorDeTurnos turnos = estado.getContadorDeTurnos();
		assertEquals(turnos.getTurnosRestantes(), 3);
		//simulo el juego.
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 2);
		assertEquals(goku.getKi(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 1);
		assertEquals(goku.getKi(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertTrue(turnos.estaEnCero());
		/*Luego de tres turnos se va el efecto chocolate*/
		int kiEsperado = KI_POR_TURNO + KI_INICIAL; // == 5
		
		assertEquals(goku.getKi(), kiEsperado);
	}
	
	@Test
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteVuelveAlEstadoAnteriorEnTresTurnos()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(majinBoo, posicionInicialX);
		tablero.agregarPersonaje(goku, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		EstadoInactivoConChocolate estado = (EstadoInactivoConChocolate)goku.getEstadoActividad();
		ContadorDeTurnos turnos = estado.getContadorDeTurnos();
		assertEquals(turnos.getTurnosRestantes(), 3);
		//simulo el juego.
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 2);
		assertEquals(goku.getKi(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 1);
		assertEquals(goku.getKi(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertTrue(turnos.estaEnCero());
		/*Luego de tres turnos se va el efecto chocolate*/
		
		
		assertEquals(goku.getEstadoActividad().getNombre(), NOMBRE_TRANF_NORMAL);
	}
}
