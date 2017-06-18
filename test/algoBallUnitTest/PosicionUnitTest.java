package algoBallUnitTest;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import tablero.Posicion;

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
    public void distanciaEntreUnPosicionYSiMismoEsCero() {
        Posicion pos = new Posicion(1, 1);
        assertEquals(pos.distanciaALa(pos), 0);
    }


    @Test
    public void distanciaEntreDosPosicionesA2DeDistanciaHorizontalmenteEs2() {
        Posicion pos1 = new Posicion(1, 4);
        Posicion pos2 = new Posicion(3, 4);
        assertEquals(pos1.distanciaALa(pos2), 2);
    }

    @Test
    public void distanciaEntreDosPosicionesA3DeDistanciaVerticalmenteEs3() {
        Posicion pos1 = new Posicion(1, 5);
        Posicion pos2 = new Posicion(1, 2);
        assertEquals(pos1.distanciaALa(pos2), 3);
    }
	
    @Test
	public void posicionQueEquidistaTresEstaFueraDelRango2()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = new Posicion(4,2);
		assertFalse(posicionPrueba.dentroDelRango(posicionPrueba2,2));
		
	}
	
    @Test
	public void comprobarDarDerechaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darDerecha();
		Posicion posEsperada = new Posicion(1,2);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarIzquierdaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darIzquierda();
		Posicion posEsperada = new Posicion(1,0);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarArribaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darArriba();
		Posicion posEsperada = new Posicion(0,1);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarAbajoSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darAbajo();
		Posicion posEsperada = new Posicion(2,1);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarArribaIzquierdaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darArribaIzquierda();
		Posicion posEsperada = new Posicion(0,0);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarArribaDerechaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darArribaDerecha();
		Posicion posEsperada = new Posicion(0,2);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarAbajoIzquierdaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darAbajoIzquierda();
		Posicion posEsperada = new Posicion(2,0);
		assertEquals(posicionPrueba2, posEsperada);
	}
    
    @Test
	public void comprobarDarAbajoDerechaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = posicionPrueba.darAbajoDerecha();
		Posicion posEsperada = new Posicion(2,2);
		assertEquals(posicionPrueba2, posEsperada);
	}
}
