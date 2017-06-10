package algoBallIntegrationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algoBall.AlgoBall;
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
		/*el movimiento no se realizó por alli esta MajinBoo*/
		juego.moverDerecha("Majin Boo");
		Posicion posicionMajin = new Posicion(3,0);
		assertTrue(juego.obtenerPosicionDe("Majin Boo").esIgualA(posicionMajin));
		/*no se puede mover a Majin porque no es el turno del jugador dueño*/
		juego.moverIzquierda("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion));
		/* el movimiento no se realizó porque alli termina el tablero*/
		juego.moverDerecha("Goku");
		Posicion posicion2 = new Posicion(2,1);
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion2));
		juego.moverDerecha("Goku");
		assertTrue(juego.obtenerPosicionDe("Goku").esIgualA(posicion2));
		/*el movimiento no se realizó porque goku ya ha realizado la cantidad de movimientos maxima
		 * segun su velocidad*/
		juego.finalizarTurno();
		juego.moverArriba("Majin Boo");
		Posicion posicionmajin2 = new Posicion(2,0);
		assertTrue(juego.obtenerPosicionDe("Majin Boo").esIgualA(posicionmajin2));
		/* ahora si se puede mover ya que es su turno*/
		
	}

}
