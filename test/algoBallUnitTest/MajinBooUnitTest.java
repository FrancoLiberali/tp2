package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.KI_INICIAL;
import static model.algoBall.ConstantesDelJuego.KI_POR_TURNO;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.TAMANIO_TABLERO;
import static org.junit.Assert.*;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.*;
import model.personajes.Goku;
import model.personajes.MajinBoo;
import model.personajes.Personaje;
import model.personajes.elementos.*;
import model.tablero.*;

public class MajinBooUnitTest 
{
	@Test (expected = PersonajeEnEstadoChocolate.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuIntentarAtacarCongGokuLevantaExcepcion()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(new Ki(100));
		goku.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(majinBoo, posicionInicialX);
		tablero.agregarPosicionable(goku, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
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
		majinBoo.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(majinBoo, posicionInicialX);
		tablero.agregarPosicionable(goku, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		goku.aumentarKi(new Ki(100));
		
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
	}

	@Test (expected = PersonajeEnEstadoChocolate.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuLevantaExcepcion()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(new Ki(100));
		goku.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(majinBoo, posicionInicialX);
		tablero.agregarPosicionable(goku, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		goku.transformar();
	}
	
	@Test(expected = EstePersonajeNoSePuedeMoverException.class)
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteNoPuedeMoverse()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(new Ki(100));
		goku.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(majinBoo, posicionInicialX);
		tablero.agregarPosicionable(goku, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		agrupacion2.mover(goku, Direccion.derecha());
		
	}
	
	@Test
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteGanaKiLuegoTresTurnos()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(majinBoo, posicionInicialX);
		tablero.agregarPosicionable(goku, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		EstadoInactivoConChocolate estado = (EstadoInactivoConChocolate)goku.getEstado();
		ContadorDeTurnos turnos = estado.getContadorDeTurnos();
		assertEquals(turnos.getTurnosRestantes(), 3);
		//simulo el juego.
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 2);
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 1);
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertTrue(turnos.estaEnCero());
		/*Luego de tres turnos se va el efecto chocolate*/
		int kiEsperado = KI_POR_TURNO + KI_INICIAL; // == 5
		
		assertEquals(goku.getKiCantidad(), kiEsperado);
	}
	
	@Test
	public void aplicarAtaqueEspecialDeMajinBooAGokuEsteVuelveAlEstadoAnteriorEnTresTurnos()
	{
		Personaje majinBoo = new MajinBoo();
		Personaje goku = new Goku();
		majinBoo.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(majinBoo, posicionInicialX);
		tablero.agregarPosicionable(goku, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(majinBoo);
		agrupacion2.agregarPersonaje(goku);
		
		majinBoo.realizarAtaqueEspecial(goku);
		EstadoInactivoConChocolate estado = (EstadoInactivoConChocolate)goku.getEstado();
		ContadorDeTurnos turnos = estado.getContadorDeTurnos();
		assertEquals(turnos.getTurnosRestantes(), 3);
		//simulo el juego.
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 2);
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertEquals(turnos.getTurnosRestantes(), 1);
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
		goku.reestablecer();//fin turno goku
		assertTrue(turnos.estaEnCero());
		/*Luego de tres turnos se va el efecto chocolate*/
		
		
		assertEquals(goku.getEstado().getNombre(), NOMBRE_TRANF_NORMAL);
	}
}
