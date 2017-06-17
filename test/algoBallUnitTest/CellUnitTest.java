package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_CELL_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Equipo;
import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Cell;
import personajes.Goku;
import personajes.Personaje;
import tablero.Posicion;
import tablero.Tablero;

public class CellUnitTest {

	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void cellRecienCreadoNoSePuedeTransformar()
	{
		Personaje cell = new Cell();
		cell.transformar();	
	}
	
	@Test
	public void ataqueEspecialDeCellSacaLoMismoQueAtaqueBasico()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		cell.aumentarKi(5);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_GOKU - PODER_CELL_NORMAL;
		
		cell.realizarAtaqueEspecial(goku);
		assertEquals(goku.getSalud(), saludEsperada);
	}
	
	@Test
	public void ataqueEspecialDeCellRecuperaVidaSacada()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		cell.aumentarKi(5);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - PODER_GOKU_NORMAL + PODER_CELL_NORMAL;
		
		goku.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), PUNTOS_VIDA_CELL - PODER_GOKU_NORMAL);
		cell.realizarAtaqueEspecial(goku);
		assertEquals(cell.getSalud(), saludEsperada);
	}
	
	@Test
	public void laAbsorcionDeVidaNoPuedeSuperarLaVidaInicial()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		cell.aumentarKi(5);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL;
		
		cell.realizarAtaqueEspecial(goku);
		assertEquals(cell.getSalud(), saludEsperada);
	}
	
	
	@Test
	public void cellPuedeEvolucionarLuegoDeAbsorverLasVidasNecesarias()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		cell.aumentarKi(20);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		cell.realizarAtaqueEspecial(goku);
		cell.realizarAtaqueEspecial(goku);
		cell.realizarAtaqueEspecial(goku);
		cell.realizarAtaqueEspecial(goku);
		cell.transformar();
		assertEquals(cell.getEstado().getNombre(), NOMBRE_CELL_PRIMERA_TRANSF);
	}
}
