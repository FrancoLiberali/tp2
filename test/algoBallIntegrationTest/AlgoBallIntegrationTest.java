package algoBallIntegrationTest;

import static algoBall.ConstantesDelJuego.CELL_COL;
import static algoBall.ConstantesDelJuego.CELL_FIL;
import static algoBall.ConstantesDelJuego.GOKU_COL;
import static algoBall.ConstantesDelJuego.GOKU_FIL;
import static algoBall.ConstantesDelJuego.NOMBRE_ENEMIGOS;
import static algoBall.ConstantesDelJuego.NOMBRE_GUERREROS;
import static algoBall.ConstantesDelJuego.TAMANIO_TABLERO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.ConstantesDelJuego;
import algoBall.Equipo;
import algoBall.Jugador;
import personajes.Cell;
import personajes.Goku;
import personajes.Personaje;
import tablero.Posicion;
import tablero.Tablero;

public class AlgoBallIntegrationTest {
	
	@Test
	public void inicioJuegoYRealizarCambiosDeTurno(){
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		
		Jugador jugador1 = new Jugador("juan", NOMBRE_ENEMIGOS);
		Jugador jugador2 = new Jugador("pedro", NOMBRE_GUERREROS);
		
		jugador1.agregarPersonaje(goku);
		jugador2.agregarPersonaje(cell);
		
		Tablero tablero = new Tablero(TAMANIO_TABLERO);
	
		tablero.agregarPosicionable(goku, new Posicion(GOKU_FIL,GOKU_COL));
		tablero.agregarPosicionable(cell, new Posicion(CELL_FIL,CELL_COL));
		
		Equipo guerrerosZ = jugador1.getEquipo();
		Equipo enemigos = jugador2.getEquipo();
		
		assertEquals(guerrerosZ.getCantidadDeAtaquesRestantes(),1);
		assertEquals(goku.getPosicion().getColumna(),5);
		assertEquals(goku.getPosicion().getFila(),0);
		
		guerrerosZ.moverAbajo(goku);
		assertEquals(goku.getPosicion().getColumna(),5);
		assertEquals(goku.getPosicion().getFila(),1);
		assertEquals(guerrerosZ.getCantidadDeAtaquesRestantes(),1);
		
		guerrerosZ.moverDerecha(goku);
		assertEquals(goku.getPosicion().getColumna(),6);
		assertEquals(goku.getPosicion().getFila(),1);
		
		assertEquals(guerrerosZ.getCantidadDeAtaquesRestantes(),1);
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos
		guerrerosZ.moverAbajo(goku);		
		guerrerosZ.moverAbajo(goku);
		
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos
		guerrerosZ.moverAbajo(goku);		
		guerrerosZ.moverAbajo(goku);
		
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos
		guerrerosZ.moverAbajo(goku);		
		guerrerosZ.moverAbajo(goku);
		
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos
		guerrerosZ.moverAbajo(goku);		
		guerrerosZ.moverAbajo(goku);
		
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos
		guerrerosZ.moverAbajo(goku);		
		guerrerosZ.moverAbajo(goku);
		
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos
		guerrerosZ.moverAbajo(goku);		
		guerrerosZ.moverAbajo(goku);
		
		goku.realizarAtaqueBasico(cell);
		
		assertEquals(cell.getSalud(), ConstantesDelJuego.PUNTOS_VIDA_CELL - ConstantesDelJuego.PODER_GOKU_NORMAL);
		assertEquals(guerrerosZ.getCantidadDeAtaquesRestantes(),0);
		guerrerosZ.reestablecer();//simulacion finalizacion de turnos

		assertEquals(enemigos.getCantidadDeAtaquesRestantes(),1);
		enemigos.moverAbajo(cell);
		assertEquals(cell.getPosicion().getColumna(),5);
		assertEquals(cell.getPosicion().getFila(),14);
	}
}
