package algoBallIntegrationTest;

import static org.junit.Assert.*;
import static algoBall.ConstantesDelJuego.*;

import org.junit.Test;

import algoBall.AlgoBall;
import funcionamientoTablero.Posicion;

public class AlgoBallIntegracionTest 
{	
	/*@Test
	public void pruebaDeIntegracionDeAtaques(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		int salud = PUNTOS_VIDA_GOKU;
		assertEquals(juego.obtenerSaludDe(GOKU_NOMBRE), salud);
		juego.realizarAtaqueBasico(GOKU_NOMBRE,1,0);
		assertEquals(juego.obtenerSaludDe(GOKU_NOMBRE), salud);
		//El personaje no se puede atacar a el mismo
		juego.realizarAtaqueBasico(GOKU_NOMBRE,3,0);
		int saludMajin = PUNTOS_VIDA_FREEZER - PODER_GOKU_NORMAL;
		assertEquals(juego.obtenerSaludDe(FREEZER_NOMBRE), saludMajin);
		juego.realizarAtaqueBasico(GOKU_NOMBRE,3,0);
		assertEquals(juego.obtenerSaludDe(FREEZER_NOMBRE), saludMajin);
		//El jugador ya ataco este turno por lo que el ataque no es valido
		juego.finalizarTurno();
		juego.realizarAtaqueBasico(FREEZER_NOMBRE, 1, 0);
		int saludGoku = PUNTOS_VIDA_GOKU - PODER_FREEZER_NORMAL;
		assertEquals(juego.obtenerSaludDe(GOKU_NOMBRE), saludGoku);
		
	}
	*/
	@Test
	public void pruebaDeIntegracionDeTransformaciones(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 5);
		
		juego.transformar(GOKU_NOMBRE);
		assertEquals(juego.getEstadoTransformacion(GOKU_NOMBRE).getNombre(), "Normal");
		/*La transformacion no tuvo exito porque el ki no era suficiente*/
		
		juego.finalizarTurno();
		juego.finalizarTurno();
		
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 10);
		
		juego.finalizarTurno();
		juego.finalizarTurno();
		
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 15);
		
		juego.finalizarTurno();
		juego.finalizarTurno();
		
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 20);
		
		juego.transformar(GOKU_NOMBRE);
		
		assertEquals(juego.getEstadoTransformacion(GOKU_NOMBRE).getNombre(), "Kaio-Ken");
		/*Se pudo realizar la tranformacion porque se tiene el ki suficiente*/
		
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 0);
		/* se gasto el ki para transformarse*/
		
	}
	
	/* ya no tiene sentido 
	 * @Test
	 
	public void pruebaDeIntegracionDeMovimientosAtaquesYTransforamaciones(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 5);
		
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 10);
		/*
		juego.realizarAtaqueBasico(GOKU_NOMBRE,3,0);
		int saludFreezer = PUNTOS_VIDA_FREEZER - PODER_GOKU_NORMAL;
		assertEquals(juego.obtenerSaludDe(FREEZER_NOMBRE), saludFreezer);
		
		juego.moverDerecha(GOKU_NOMBRE);
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 15);
		
		juego.moverDerecha(GOKU_NOMBRE);
		juego.moverDerecha(GOKU_NOMBRE);
		Posicion posicion = new Posicion(1,3);
		assertEquals(juego.obtenerPosicionDe(GOKU_NOMBRE), posicion);
		
		juego.moverDerecha(GOKU_NOMBRE);
		assertEquals(juego.obtenerPosicionDe(GOKU_NOMBRE), posicion);
		/* su velocidad en estado normal es 2*/
	
		/*juego.realizarAtaqueBasico(GOKU_NOMBRE,3,0);
		assertEquals(juego.obtenerSaludDe(FREEZER_NOMBRE), saludFreezer);
		//el ataque no se efectua porque la distancia es mayor que el alcance normal de goku
		 
		 
		
		juego.finalizarTurno();
		juego.finalizarTurno();
		assertEquals(juego.getKiDe(GOKU_NOMBRE), 20);
		/*
		juego.transformar(GOKU_NOMBRE);
		juego.realizarAtaqueBasico(GOKU_NOMBRE,3,0);
		saludFreezer = saludFreezer - PODER_GOKU_PRIMERA_TRANSF;
		assertEquals(juego.obtenerSaludDe(FREEZER_NOMBRE), saludFreezer);
		//al evolucionar si llega hasta antes no llegaba y le hace 40 de danio
		juego.moverDerecha(GOKU_NOMBRE);
		juego.moverDerecha(GOKU_NOMBRE);
		juego.moverDerecha(GOKU_NOMBRE);
		Posicion posicion2 = new Posicion(1,6);
		assertTrue(juego.obtenerPosicionDe(GOKU_NOMBRE).esIgualA(posicion2));
		juego.moverDerecha(GOKU_NOMBRE);
		assertTrue(juego.obtenerPosicionDe(GOKU_NOMBRE).esIgualA(posicion2));
		//en esta evolucion la velocidad es 
	}
 */
}
