package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.PORCENTAJE_AUMENTO_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Agrupacion;
import funcionamientoPersonaje.Cell;
import funcionamientoPersonaje.Goku;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class GokuUnitTest 
{
	@Test
	public void ataqueEspecialGoku()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.aumentarKi(20);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - (PODER_GOKU_NORMAL
				+ PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU * PODER_GOKU_NORMAL / 100 );
		
		goku.realizarAtaqueEspecial(posicionInicialY);
		assertEquals(cell.getSalud(), saludEsperada);
	}
	
	@Test
	public void ataqueGokuConMenosDe30PorcientoDeVida()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 0.7));
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - (PODER_GOKU_NORMAL
				+ PORCENTAJE_AUMENTO_DANIO_GOKU * PODER_GOKU_NORMAL / 100 );
		
		goku.realizarAtaqueBasico(posicionInicialY);
		assertEquals(cell.getSalud(), saludEsperada);
	}
}
