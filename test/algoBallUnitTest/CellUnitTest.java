package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_CELL_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Cell;
import model.personajes.Goku;
import model.personajes.Personaje;
import model.personajes.elementos.Ki;
import model.tablero.Posicion;
import model.tablero.Tablero;

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
		cell.aumentarKi(new Ki(5));
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
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
		cell.aumentarKi(new Ki(5));
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
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
		cell.aumentarKi(new Ki(5));
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
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
		cell.aumentarKi(new Ki(5));
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		cell.realizarAtaqueEspecial(goku);
		agrupacion2.reestablecer();//simulacion de paso de turno para poder atacar
		cell.realizarAtaqueEspecial(goku);
		agrupacion2.reestablecer();//simulacion de paso de turno para poder atacar
		cell.realizarAtaqueEspecial(goku);
		agrupacion2.reestablecer();//simulacion de paso de turno para poder atacar
		cell.realizarAtaqueEspecial(goku);
		cell.transformar();
		assertEquals(cell.getEstado().getNombre(), NOMBRE_CELL_PRIMERA_TRANSF);
	}
}
