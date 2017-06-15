package algoBallIntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import algoBall.ConstantesDelJuego;
import algoBall.AlgoBall;
import funcionamientoPersonaje.personajes.Personaje;

public class AlgoBallIntegrationTest {
	
	@Test
	public void inicioJuegoYRealizarCambiosDeTurno(){
		AlgoBall juegoNuevo = new AlgoBall("Pedro","Juan");
		
		Personaje goku = juegoNuevo.getGoku();
		Personaje gohan = juegoNuevo.getGohan();
		Personaje cell = juegoNuevo.getCell();
		
		assertEquals(juegoNuevo.getCantidadDeMovimientosRestantes(),1);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		assertEquals(goku.getPosicion().getColumna(),0);
		assertEquals(goku.getPosicion().getFila(),1);
		
		
		goku.moverDerecha();
		assertEquals(goku.getPosicion().getColumna(),1);
		assertEquals(goku.getPosicion().getFila(),1);
		//como goku tiene velocidad 2 no se gasta una accion de movimiento
		assertEquals(juegoNuevo.getCantidadDeMovimientosRestantes(),1);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		
		goku.moverDerecha();
		assertEquals(goku.getPosicion().getColumna(),2);
		assertEquals(goku.getPosicion().getFila(),1);
		
		assertEquals(juegoNuevo.getCantidadDeMovimientosRestantes(),0);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		
		goku.realizarAtaqueBasico(cell);
		
		assertEquals(cell.getSalud(), ConstantesDelJuego.PUNTOS_VIDA_CELL - ConstantesDelJuego.PODER_GOKU_NORMAL);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),0);
		
		
		juegoNuevo.finalizarTurno();
		

		assertEquals(juegoNuevo.getCantidadDeMovimientosRestantes(),1);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
	}
}
