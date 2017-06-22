package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOKU_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_GOHAN_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static model.algoBall.ConstantesDelJuego.REDUCCION_DE_ATAQUE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.FueraDeRangoException;
import model.exceptions.IntentandoAtacarAUnCompanieroException;
import model.personajes.Cell;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.Personaje;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class PersonajeAtaqueUnitTest {
	
	@Test
	public void getDistanciaDeAtaqueDevuleveLaDelEstadoDeTranformacionActual()
	{
		Personaje goku = new Goku();
		assertEquals(goku.getDistanciaDeAtaque(), DISTANCIA_GOKU_NORMAL);
	}
	
	
	
	@Test
	public void ataqueEntrePersonajesDeDistintasAgrupacionesBajaLaSaludIgualAlAtaqueSiElAtacanteEsMasFuerte()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - PODER_GOKU_NORMAL;
		
		goku.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
		
	}
	
	@Test
	public void ataqueEntrePersonajesDeDistintasAgrupacionesBajaLaSaludMenosUn20PorCientoSiElAtacanteEsMasDebil()
	{
		Personaje gohan = new Gohan();
		Personaje cell = new Cell();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(gohan, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = (int) (PUNTOS_VIDA_CELL - PODER_GOHAN_NORMAL + (PODER_GOHAN_NORMAL * (REDUCCION_DE_ATAQUE /100.0f)));
		
		gohan.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
		
	}
	
	@Test (expected = IntentandoAtacarAUnCompanieroException.class)
	public void ataqueEntrePersonajesDeLaMismaAgrupacionLanzaIntentandoAtacarAUnCompaniero()
	{
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(gohan, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion1.agregarPersonaje(gohan);
		
		goku.realizarAtaqueBasico(gohan);		
	}
	
	@Test(expected = FueraDeRangoException.class)
	public void atacarAUnaPosicionMasLejanaQueLaDistanciaDeAtaqueLanzaFueraDeRango()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
	
		Tablero tablero = new Tablero(10);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(5,5);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		goku.realizarAtaqueBasico(cell);
	}

}
