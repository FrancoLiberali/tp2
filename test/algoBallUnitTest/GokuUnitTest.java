package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.PORCENTAJE_AUMENTO_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Equipo;
import personajes.Cell;
import personajes.Goku;
import personajes.Personaje;
import tablero.Posicion;
import tablero.Tablero;

public class GokuUnitTest 
{
	@Test
	public void ataqueEspecialGokuConVidaMayorA30PorCientoNoAplicaBonus()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.aumentarKi(20);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - (PODER_GOKU_NORMAL
				+ PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU * PODER_GOKU_NORMAL / 100 );//470
		
		goku.realizarAtaqueEspecial(cell);
		assertEquals(cell.getSalud(), saludEsperada);
	}
	
	@Test
	public void ataqueBasicoGokuConVidaMayorA30PorCientoNoAplicaBonus()
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
		
		int saludEsperada = PUNTOS_VIDA_CELL - (PODER_GOKU_NORMAL);
		
		goku.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
	}
	
	@Test
	public void ataqueBasicoGokuConMenosDe30PorcientoDeVidaAplicaBonus()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 71 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - (PODER_GOKU_NORMAL
				+ PORCENTAJE_AUMENTO_DANIO_GOKU * PODER_GOKU_NORMAL / 100 );
		
		goku.actualizarEstado();
		goku.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
	}
	
	@Test
	public void ataqueEspecialGokuConMenosDe30PorcientoDeVidaAplicaBonus()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 80 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		goku.aumentarKi(20);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		int danioAtaqueEspecial = (PODER_GOKU_NORMAL + PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU * PODER_GOKU_NORMAL / 100 );
		int saludEsperada = PUNTOS_VIDA_CELL - ( danioAtaqueEspecial
				+ PORCENTAJE_AUMENTO_DANIO_GOKU * danioAtaqueEspecial / 100 );
		
		goku.actualizarEstado();
		goku.realizarAtaqueEspecial(cell);
		assertEquals(saludEsperada, cell.getSalud());
	}
	
	
	@Test
	public void gokuNoAplicaBonusDanioSiSuSaludAUmentaDel30Porciento()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 80 / 100), 40); //poder de pelea 40 asi no hay reduccion de ataque
		goku.aumentarKi(100);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int noventaPorciento = (int) (PUNTOS_VIDA_GOKU * 0.9); 
		goku.reducirSalud(noventaPorciento);
		
		int danioAtaqueEspecial = (PODER_GOKU_NORMAL + PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU * PODER_GOKU_NORMAL / 100 );
		int saludEsperada = PUNTOS_VIDA_CELL - ( danioAtaqueEspecial
				+ PORCENTAJE_AUMENTO_DANIO_GOKU * danioAtaqueEspecial / 100 );
		
		agrupacion1.reestablecer();
		goku.realizarAtaqueEspecial(cell);
		
		assertEquals(saludEsperada, cell.getSalud());
		
		goku.regenerarSalud(noventaPorciento); //goku con toda la salud.
		
		agrupacion1.reestablecer();
		int saludEsperadaSinBonus = saludEsperada - danioAtaqueEspecial;
		
		goku.realizarAtaqueEspecial(cell);
		
		assertEquals(saludEsperadaSinBonus, cell.getSalud());
	}
}
