package algoBallUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Agrupacion;
import algoBall.moverAbajo;
import algoBall.moverArriba;
import algoBall.moverDerecha;
import algoBall.moverIzquierda;


import funcionamientoPersonaje.PersonajeDePrueba;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class MovimientoTest {
	
	
	@Test
	public void moverPersonajeIzquierdaUnCasillero(){
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverIzquierda movIzq = new moverIzquierda();
		movIzq.mover(equipo, "estadoDePrueba");
		Posicion posicionFinal = new Posicion(2,1);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	@Test
	public void moverPersonajeIzquierdaMuchosCasillero(){
		Tablero tablero = new Tablero(12);
		Posicion posicionInicial = new Posicion(2,11);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverIzquierda movIzq = new moverIzquierda();
		int numDePasos= 10;
		for (int i=0;i<numDePasos;i++){
			movIzq.mover(equipo, "estadoDePrueba");
		}
		System.out.println(goku.getPosicion().getColumna());
		Posicion posicionFinal = new Posicion(2,1);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	
	@Test
	public void moverPersonajeDerechaUnCasillero(){
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverDerecha movDer = new moverDerecha();
		movDer.mover(equipo, "estadoDePrueba");
		Posicion posicionFinal = new Posicion(2,3);
		assertEquals(goku.getPosicion(), posicionFinal);
	
	}
	
	@Test
	public void moverPersonajeDerechaMuchosCasillero(){
		Tablero tablero = new Tablero(12);
		Posicion posicionInicial = new Posicion(2,1);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverDerecha movDer = new moverDerecha();
		int numDePasos= 10;
		for (int i=0;i<numDePasos;i++){
			movDer.mover(equipo, "estadoDePrueba");
		}
		System.out.println(goku.getPosicion().getColumna());
		Posicion posicionFinal = new Posicion(2,11);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	@Test
	public void moverPersonajeArribaUnCasillero(){
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverArriba movArriba = new moverArriba();
		movArriba.mover(equipo, "estadoDePrueba");
		Posicion posicionFinal = new Posicion(1,2);
		assertEquals(goku.getPosicion(), posicionFinal);
	
	}
	
	@Test
	public void moverPersonajeArribaMuchosCasillero(){
		Tablero tablero = new Tablero(12);
		Posicion posicionInicial = new Posicion(11,2);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverArriba movArriba = new moverArriba();
		int numDePasos= 10;
		for (int i=0;i<numDePasos;i++){
			movArriba.mover(equipo, "estadoDePrueba");
		}
		System.out.println(goku.getPosicion().getColumna());
		Posicion posicionFinal = new Posicion(1,2);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	@Test
	public void moverPersonajeAbajoUnCasillero(){
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverAbajo movAbajo = new moverAbajo();
		movAbajo.mover(equipo, "estadoDePrueba");
		Posicion posicionFinal = new Posicion(3,2);
		assertEquals(goku.getPosicion(), posicionFinal);
	
	}
	
	@Test
	public void moverPersonajeAbajoMuchosCasillero(){
		Tablero tablero = new Tablero(12);
		Posicion posicionInicial = new Posicion(1,2);
		Agrupacion equipo = new Agrupacion("equipo1");
		PersonajeDePrueba goku = new PersonajeDePrueba();
		tablero.agregarPersonaje(goku, posicionInicial);
		equipo.agregarPersonaje(goku);
		moverAbajo movAbajo = new moverAbajo();
		int numDePasos= 10;
		for (int i=0;i<numDePasos;i++){
			movAbajo.mover(equipo, "estadoDePrueba");
		}
		System.out.println(goku.getPosicion().getColumna());
		Posicion posicionFinal = new Posicion(11,2);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	
}