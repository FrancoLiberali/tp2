package algoBallUnitTest;

import static org.junit.Assert.assertEquals;
import static algoBall.ConstantesDelJuego.*;

import org.junit.Test;

import algoBall.Agrupacion;
import funcionamientoPersonaje.personajes.Cell;
import funcionamientoPersonaje.personajes.Goku;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class CellUnitTest {

	@Test
	public void cellRecienCreadoNoSePuedeTransformar()
	{
		Personaje cell = new Cell();
		cell.transformar();
		assertEquals(cell.getEstadoTransformacion().getNombre(), NOMBRE_TRANF_NORMAL);
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
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
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
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
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
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
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
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		cell.realizarAtaqueEspecial(goku);
		cell.realizarAtaqueEspecial(goku);
		cell.realizarAtaqueEspecial(goku);
		cell.realizarAtaqueEspecial(goku);
		cell.transformar();
		assertEquals(cell.getEstadoTransformacion().getNombre(), NOMBRE_CELL_PRIMERA_TRANSF);
	}
}
