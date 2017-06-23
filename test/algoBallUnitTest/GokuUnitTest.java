package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static model.algoBall.ConstantesDelJuego.PORCENTAJE_AUMENTO_DANIO_GOKU;
import static model.algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_CELL;
import static model.algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static model.algoBall.ConstantesDelJuego.TAMANIO_TABLERO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.personajes.Cell;
import model.personajes.Goku;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.Ki;
import model.personajes.elementos.Salud;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class GokuUnitTest 
{
	@Test
	public void ataqueEspecialGokuConVidaMayorA30PorCientoNoAplicaBonus()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		goku.aumentarKi(new Ki(20));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
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
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
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

		goku.recibirDanio(new Danio(480)); //salud goku = 500;
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
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
		
		goku.recibirDanio(new Danio(480)); //salud goku = 500;
		goku.aumentarKi(new Ki(20));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
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
		
		goku.recibirDanio(new Danio(40));
		goku.aumentarKi(new Ki(100));
		
		Tablero tablero = Tablero.createInstance(TAMANIO_TABLERO);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPosicionable(goku, posicionInicialX);
		tablero.agregarPosicionable(cell, posicionInicialY);
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int noventaPorciento = (int) (PUNTOS_VIDA_GOKU * 0.9); 
		goku.reducirSalud(new Salud(noventaPorciento));
		
		int danioAtaqueEspecial = (PODER_GOKU_NORMAL + PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU * PODER_GOKU_NORMAL / 100 );
		int saludEsperada = PUNTOS_VIDA_CELL - ( danioAtaqueEspecial
				+ PORCENTAJE_AUMENTO_DANIO_GOKU * danioAtaqueEspecial / 100 );
		
		agrupacion1.reestablecer();
		goku.realizarAtaqueEspecial(cell);
		
		assertEquals(saludEsperada, cell.getSalud());
		
		goku.regenerarSalud(new Salud(noventaPorciento)); //goku con toda la salud.
		
		agrupacion1.reestablecer();
		int saludEsperadaSinBonus = saludEsperada - danioAtaqueEspecial;
		
		goku.realizarAtaqueEspecial(cell);
		
		assertEquals(saludEsperadaSinBonus, cell.getSalud());
	}
}
