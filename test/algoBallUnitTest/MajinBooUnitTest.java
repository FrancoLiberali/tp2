package algoBallUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algoBall.Agrupacion;
import funcionamientoPersonaje.*;
import funcionamientoTablero.*;
import exceptions.*;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.KI_POR_TURNO;

public class MajinBooUnitTest 
{
	@Test (expected = PersonajeInactivoNoPuedeAtacarException.class)
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
		
		majinBoo.realizarAtaqueEspecial(posicionInicialY);
		goku.realizarAtaqueBasico(posicionInicialX);
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
		
		majinBoo.realizarAtaqueEspecial(posicionInicialY);
		goku.aumentarKi(100);
		
		assertEquals(goku.getKi(), KI_INICIAL);
	}
	
	@Test (expected = PersonajeInactivoNoPuedeTransformarseException.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteNoPuedeTansformarseLanzaExcepcion()
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
		
		majinBoo.realizarAtaqueEspecial(posicionInicialY);
		goku.transformar();
	}
	
	@Test (expected = PersonajeInactivoNoPuedeMoverseException.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteNoPuedeMoverseLanzaExcepcion()
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
		
		majinBoo.realizarAtaqueEspecial(posicionInicialY);
		Posicion nuevaPosicion = new Posicion(4,4);
		goku.mover(nuevaPosicion);
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
		
		majinBoo.realizarAtaqueEspecial(posicionInicialY);
		EstadoInactivoConChocolate estado = (EstadoInactivoConChocolate)goku.getEstadoActividad();
		ContadorDeTurnos turnos = estado.getContadorDeTurnos();
		//simulo el juego.
		turnos.reducir();
		goku.aumentarKi(KI_POR_TURNO);
		turnos.reducir();
		goku.aumentarKi(KI_POR_TURNO);
		turnos.reducir();
		goku.aumentarKi(KI_POR_TURNO);
		assertTrue(turnos.estaEnCero());
		/*Luego de tres turnos se va el efecto chocolate*/
		goku.aumentarKi(KI_POR_TURNO);
		int kiEsperado = KI_POR_TURNO + KI_INICIAL; // == 5
		
		assertEquals(goku.getKi(), kiEsperado);
	}
	
}
