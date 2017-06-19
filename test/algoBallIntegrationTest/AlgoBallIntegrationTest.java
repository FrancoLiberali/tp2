package algoBallIntegrationTest;

import static algoBall.ConstantesDelJuego.CELL_COL;
import static algoBall.ConstantesDelJuego.CELL_FIL;
import static algoBall.ConstantesDelJuego.GOKU_COL;
import static algoBall.ConstantesDelJuego.GOKU_FIL;
import static algoBall.ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_ENEMIGOS;
import static algoBall.ConstantesDelJuego.NOMBRE_GUERREROS;
import static algoBall.ConstantesDelJuego.TAMANIO_TABLERO;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.ConstantesDelJuego;
import algoBall.Equipo;
import algoBall.Jugador;
import consumibles.Consumible;
import consumibles.EsferaDelDragon;
import consumibles.NubeVoladora;
import consumibles.SemillaDelErmitanio;
import exceptions.CasilleroOcupadoException;
import personajes.Cell;
import personajes.Gohan;
import personajes.Goku;
import personajes.Personaje;
import tablero.Casillero;
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
		enemigos.moverArriba(cell);
		assertEquals(cell.getPosicion().getColumna(),5);
		assertEquals(cell.getPosicion().getFila(),13);
	}
	
	@Test
	public void sePideQueSeMuevaUnPersonajeVerificarPosicionFinal(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		
		equipo.agregarPersonaje(goku);
		equipo.moverDerecha(goku);
		Posicion posicionEsperada = new Posicion(1,2);
		
		assertEquals(goku.getPosicion(), posicionEsperada);
	}
	
	@Test (expected = CasilleroOcupadoException.class)
	public void seVerificaQueNoPuedaHaberDosJPersonajesEnUnMismoCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Posicion posicionGokuInicial = new Posicion(1,1);
		Posicion posicionGohanInicial = new Posicion(1,2);
		tablero.agregarPosicionable(goku, posicionGokuInicial);
		tablero.agregarPosicionable(gohan, posicionGohanInicial);
		
		equipo.agregarPersonaje(goku);
		equipo.agregarPersonaje(gohan);
		
		equipo.moverDerecha(goku);

		assertEquals(goku.getPosicion(), posicionGokuInicial);
	}
	
	@Test
	public void ConsumibleDesapareceAlIrUnPersonajeASuCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		equipo.agregarPersonaje(goku);
		Consumible esfera = new EsferaDelDragon();
		Posicion posicionEsfera = posicionGoku.darDerecha();
		Casillero cas = tablero.getCasillero(posicionEsfera);
		cas.agregarConsumible(esfera);
		assertEquals(cas.getConsumible(),esfera);
		
		equipo.moverDerecha(goku);
		assertEquals(cas.getConsumible(),null);
	}
	
	@Test
	public void EsferaDelDragonAumenta25PorCientoDeDanioAlIrUnPersonajeASuCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		equipo.agregarPersonaje(goku);
		Consumible esfera = new EsferaDelDragon();
		Posicion posicionEsfera = posicionGoku.darDerecha();
		Casillero cas = tablero.getCasillero(posicionEsfera);
		cas.agregarConsumible(esfera);
		assertEquals(cas.getConsumible(),esfera);
		int poderAnt = goku.getPoderDePelea();
		int poderEsp = poderAnt + poderAnt * 25 /100;
		equipo.moverDerecha(goku);
		assertEquals(goku.getPoderDePelea(),poderEsp);
	}
	
	@Test
	public void NubeVoladoraDuplicaLaVelocidadAlIrUnPersonajeASuCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		equipo.agregarPersonaje(goku);
		Consumible nube = new NubeVoladora();
		Posicion posicionNube = posicionGoku.darDerecha();
		Casillero cas = tablero.getCasillero(posicionNube);
		cas.agregarConsumible(nube);
		assertEquals(cas.getConsumible(),nube);
		int velAnt = goku.getVelocidad();
		int velEsp = velAnt * 2;
		equipo.moverDerecha(goku);
		assertEquals(goku.getVelocidad(),velEsp);
	}
	
	@Test
	public void SemillaDelErmitanioAumenta100DeVidaAlIrUnPersonajeDaniado100OMasASuCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		equipo.agregarPersonaje(goku);
		Consumible semilla = new SemillaDelErmitanio();
		Posicion posicionSemilla = posicionGoku.darDerecha();
		Casillero cas = tablero.getCasillero(posicionSemilla);
		cas.agregarConsumible(semilla);
		assertEquals(cas.getConsumible(),semilla);
		goku.reducirSalud(200);
		int vidaEsp = PUNTOS_VIDA_GOKU -200 +100;
		equipo.moverDerecha(goku);
		assertEquals(goku.getSalud(),vidaEsp);
	}
	
	@Test
	public void SemillaDelErmitanioLlevaLaVidaAlMaximoAlIrUnPersonajeDaniadoMenosDe100ASuCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		equipo.agregarPersonaje(goku);
		Consumible semilla = new SemillaDelErmitanio();
		Posicion posicionSemilla = posicionGoku.darDerecha();
		Casillero cas = tablero.getCasillero(posicionSemilla);
		cas.agregarConsumible(semilla);
		assertEquals(cas.getConsumible(),semilla);
		goku.reducirSalud(99);
		int vidaEsp = PUNTOS_VIDA_GOKU;
		equipo.moverDerecha(goku);
		assertEquals(goku.getSalud(),vidaEsp);
	}
	
	@Test
	public void SePuedeTranformarLuegoDeConsumirUnConsumible(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		equipo.agregarPersonaje(goku);
		Consumible nube = new NubeVoladora();
		Posicion posicionNube = posicionGoku.darDerecha();
		Casillero cas = tablero.getCasillero(posicionNube);
		cas.agregarConsumible(nube);
		assertEquals(cas.getConsumible(),nube);
		equipo.moverDerecha(goku);
		goku.aumentarKi(21);
		goku.transformar();
		assertEquals(goku.getEstado().getNombre(),NOMBRE_GOKU_PRIMERA_TRANSF);
	}
	
}
