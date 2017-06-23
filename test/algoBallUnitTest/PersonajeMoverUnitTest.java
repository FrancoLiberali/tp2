package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.TAMANIO_TABLERO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.CasilleroOcupadoException;
import model.exceptions.EstePersonajeNoSePuedeMoverException;
import model.exceptions.FueraDelTableroException;
import model.exceptions.NoQuedanMovimientosException;
import model.personajes.Cell;
import model.personajes.Goku;
import model.personajes.MajinBoo;
import model.personajes.Personaje;
import model.personajes.Piccolo;
import model.personajes.elementos.Direccion;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class PersonajeMoverUnitTest {
	
	@Test
	public void moverPersonajeVerificarPosicion()
	{
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Equipo guerrerosZ = new Equipo("GuerrerosZ");
		Personaje goku = new Goku();
		goku.setEquipo(guerrerosZ);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPosicionable(goku, posicionInicial);
		guerrerosZ.mover(goku, Direccion.derecha());
		Posicion posicionFinal = new Posicion(2,3);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	@Test(expected = NoQuedanMovimientosException.class)
	public void MoverPersonajeMasVecesQueSuVelocidadActualLanzaNoQuedanMovimientos(){
		Personaje piccolo = new Piccolo();
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Equipo guerrerosZ = new Equipo("Guerreros Z");
		piccolo.setEquipo(guerrerosZ);
		
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPosicionable(piccolo, posicionInicial);
		guerrerosZ.mover(piccolo, Direccion.derecha());
		guerrerosZ.mover(piccolo, Direccion.derecha());
		/* se alcanza limite de movimientos*/
		guerrerosZ.mover(piccolo, Direccion.derecha());
	}
	
	@Test (expected = EstePersonajeNoSePuedeMoverException.class)
	public void noSePuedeMoverPersonajeLuegoDeMoverAOtroEnEsteTurno(){
		Personaje majinBoo = new MajinBoo();
		Personaje cell = new Cell();
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Equipo enemigos = new Equipo("enemigos");
		majinBoo.setEquipo(enemigos);
		Posicion posicionInicialM = new Posicion(2,2);
		Posicion posicionInicialC = new Posicion(3,2);
		tablero.agregarPosicionable(majinBoo, posicionInicialM);
		tablero.agregarPosicionable(cell, posicionInicialC);
		enemigos.mover(majinBoo, Direccion.derecha());
		enemigos.mover(cell, Direccion.derecha());
	}
	
	@Test (expected = CasilleroOcupadoException.class)
	public void moverPersonajeNoFuncionaSiHayOtroPersonajeEnElLugarAlQueNosQueremosMover()
	{
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Equipo guerrerosZ = new Equipo("GuerrerosZ");
		Personaje goku = new Goku();
		goku.setEquipo(guerrerosZ);
		Personaje piccolo = new Piccolo();
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(piccolo, posicionInicialY);
		
		guerrerosZ.mover(goku, Direccion.abajo());
		
	}
	
	@Test(expected = FueraDelTableroException.class)
	public void moverPersonajeNoFuncionaSiElLugarAlQueNosQueremosMoverSeEncuentraFueraDelTablero()
	{
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Personaje piccolo = new Piccolo();
		Equipo guerrerosZ = new Equipo("GuerrerosZ");
		piccolo.setEquipo(guerrerosZ);
		
		Posicion posicionInicialX = new Posicion(14,2);
		
		tablero.agregarPosicionable(piccolo, posicionInicialX);
		
		guerrerosZ.mover(piccolo, Direccion.abajo());
		
	}

}
