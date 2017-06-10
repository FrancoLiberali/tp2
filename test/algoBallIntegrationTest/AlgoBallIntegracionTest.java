package algoBallIntegrationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algoBall.AlgoBall;
import algoBall.ConstantesDelJuego;
import funcionamientoTablero.Posicion;

public class AlgoBallIntegracionTest {
	
	@Test
	public void pruebaDeIntegracionDeMovimientos(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		juego.moverAbajo("Goku");
		Posicion posicion = new Posicion(2,0);
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion));
		juego.moverAbajo("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion));
		/*el movimiento no se realizo por alli esta MajinBoo*/
		juego.moverDerecha("Majin Boo");
		Posicion posicionMajin = new Posicion(3,0);
		assertTrue(juego.obtenerPosicionDe("Majin Boo").esIgualA(posicionMajin));
		/*no se puede mover a Majin porque no es el turno del jugador duenio*/
		juego.moverIzquierda("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion));
		/* el movimiento no se realizo porque alli termina el tablero*/
		juego.moverDerecha("Goku");
		Posicion posicion2 = new Posicion(2,1);
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion2));
		juego.moverDerecha("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion2));
		/*el movimiento no se realizo porque goku ya ha realizado la cantidad de movimientos maxima
		 * segun su velocidad*/
		juego.finalizarTurno();
		juego.moverArriba("Majin Boo");
		Posicion posicionmajin2 = new Posicion(2,0);
		assertTrue(juego.obtenerPosicionDe("Majin Boo").esIgualA(posicionmajin2));
		/* ahora si se puede mover ya que es su turno*/
		
	}
	
	@Test
	public void pruebaDeIntegracionDeAtaques(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		int salud = ConstantesDelJuego.PUNTOS_VIDA_GOKU;
		assertEquals(juego.obtenerSaludDe("Goku"), salud);
		juego.realizarAtaqueBasico("Goku",1,0);
		assertEquals(juego.obtenerSaludDe("Goku"), salud);
		/*El personaje no se puede atacar a el mismo*/
		juego.realizarAtaqueBasico("Goku",3,0);
		int saludMajin = ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO - 20;
		assertEquals(juego.obtenerSaludDe("Majin Boo"), saludMajin);
		juego.realizarAtaqueBasico("Goku",3,0);
		assertEquals(juego.obtenerSaludDe("Majin Boo"), saludMajin);
		/*El jugador ya ataco este turno por lo que el ataque no es valido*/
		juego.finalizarTurno();
		juego.realizarAtaqueBasico("Majin Boo", 1, 0);
		int saludGoku = ConstantesDelJuego.PUNTOS_VIDA_GOKU - 30;
		assertEquals(juego.obtenerSaludDe("Goku"), saludGoku);
		
	}
	
	@Test
	public void pruebaDeIntegracionDeTransformaciones(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		assertEquals(juego.getKiDe("Goku"), 5);
		juego.transformar("Goku");
		assertEquals(juego.getEstadoTransformacion("Goku").getNombre(), "Normal");
		/*La transformacion no tuvo exito porque el ki no era suficiente*/
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe("Goku"), 10);
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe("Goku"), 15);
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe("Goku"), 20);
		juego.transformar("Goku");
		assertEquals(juego.getEstadoTransformacion("Goku").getNombre(), "Kaio-Ken");
		/*Se pudo realizar la tranformacion porque se tiene el ki suficiente*/
		assertEquals(juego.getKiDe("Goku"), 0);
		/* se gasto el ki para transformarse*/
		
	}
	
	@Test
	public void pruebaDeIntegracionDeMovimientosAtaquesYTransforamaciones(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		assertEquals(juego.getKiDe("Goku"), 5);
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe("Goku"), 10);
		juego.realizarAtaqueBasico("Goku",3,0);
		int saludMajin = ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO - 20;
		assertEquals(juego.obtenerSaludDe("Majin Boo"), saludMajin);
		juego.moverDerecha("Goku");
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe("Goku"), 15);
		juego.moverDerecha("Goku");
		juego.moverDerecha("Goku");
		Posicion posicion = new Posicion(1,3);
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion));
		juego.moverDerecha("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion));
		/* su velocidad en estado normal es 2*/
		juego.realizarAtaqueBasico("Goku",3,0);
		assertEquals(juego.obtenerSaludDe("Majin Boo"), saludMajin);
		/*el ataque no se efectua porque la distancia es mayor que el alcance normal de goku*/
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe("Goku"), 20);
		juego.transformar("Goku");
		juego.realizarAtaqueBasico("Goku",3,0);
		saludMajin = saludMajin - 40;
		assertEquals(juego.obtenerSaludDe("Majin Boo"), saludMajin);
		/*al evolucionar si llega hasta antes no llegaba y le hace 40 de daño*/
		juego.moverDerecha("Goku");
		juego.moverDerecha("Goku");
		juego.moverDerecha("Goku");
		Posicion posicion2 = new Posicion(1,6);
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion2));
		juego.moverDerecha("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion2));
		/*en esta evolucion la velocidad es 3*/
	}

}
