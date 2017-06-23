package algoBallUnitTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.tablero.Posicion;

public class PosicionUnitTest {

	@Test
	public void obtenerFilaColumna(){
		Posicion posicionPrueba = new Posicion(1,2);
		assertEquals(posicionPrueba.getFila(), 1);
		assertEquals(posicionPrueba.getColumna(), 2);
	}
	
	@Test
	public void posicionQueEquidistaDosEstaDentroDelRango2()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = new Posicion(3,2);
		assertTrue(posicionPrueba.dentroDelRango(posicionPrueba2,2));
	}
	
	@Test
	public void comprobarQueDosPosicionesConLaMismaFilaYColumnaSonIguales()
	{
		Posicion pos1 = new Posicion(1,1);
		Posicion pos2 = new Posicion(1,1);
		assertEquals(pos1, pos2);
	}

    @Test
    public void insertarPosicionEnUnHasheableSeHasheanIgualLosPosicionIguales() {
        Set<Posicion> hashPosiciones = new HashSet<>();
        Posicion posPrueba = new Posicion(1, 1);
        Posicion posPrueba2 = new Posicion(1, 1);
        hashPosiciones.add(posPrueba);

        assertTrue(hashPosiciones.contains(posPrueba2));
    }
	
    @Test
	public void posicionQueEquidistaTresEstaFueraDelRango2()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = new Posicion(4,2);
		assertFalse(posicionPrueba.dentroDelRango(posicionPrueba2,2));
		
	}
}
