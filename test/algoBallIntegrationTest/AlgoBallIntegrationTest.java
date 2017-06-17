package algoBallIntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.AlgoBall;
import algoBall.ConstantesDelJuego;
import algoBall.Equipo;
import personajes.Personaje;

public class AlgoBallIntegrationTest {
	
	@Test
	public void inicioJuegoYRealizarCambiosDeTurno(){
		AlgoBall juegoNuevo = new AlgoBall("Pedro","Juan");
		
		Personaje goku = juegoNuevo.getGoku();
		Personaje cell = juegoNuevo.getCell();
		Equipo guerrerosZ = juegoNuevo.getGuerrerosZ();
		Equipo enemigos = juegoNuevo.getEnemigos();
		
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		assertEquals(goku.getPosicion().getColumna(),0);
		assertEquals(goku.getPosicion().getFila(),0);
		
		guerrerosZ.moverAbajo(goku);
		assertEquals(goku.getPosicion().getColumna(),0);
		assertEquals(goku.getPosicion().getFila(),1);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		
		guerrerosZ.moverDerecha(goku);
		assertEquals(goku.getPosicion().getColumna(),1);
		assertEquals(goku.getPosicion().getFila(),1);
		
		guerrerosZ.moverDerecha(goku);
		assertEquals(goku.getPosicion().getColumna(),1);
		assertEquals(goku.getPosicion().getFila(),1);//goku ya no se puede mover
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		
		goku.realizarAtaqueBasico(cell);
		
		assertEquals(cell.getSalud(), ConstantesDelJuego.PUNTOS_VIDA_CELL - ConstantesDelJuego.PODER_GOKU_NORMAL);
		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),0);
		juegoNuevo.finalizarTurno();		

		assertEquals(juegoNuevo.getCantidadDeAtaquesRestantes(),1);
		enemigos.moverAbajo(cell);
		assertEquals(cell.getPosicion().getColumna(),0);
		assertEquals(cell.getPosicion().getFila(),4);
	}
}
