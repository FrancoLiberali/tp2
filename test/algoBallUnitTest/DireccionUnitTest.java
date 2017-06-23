package algoBallUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.personajes.elementos.Direccion;
import model.tablero.Posicion;

public class DireccionUnitTest {
	@Test
	public void comprobarDarDerechaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 = Direccion.derecha().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(1,2);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarIzquierdaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.izquierda().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(1,0);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarArribaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.arriba().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(0,1);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarAbajoSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.abajo().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(2,1);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarArribaIzquierdaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.arribaIzquierda().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(0,0);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarArribaDerechaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.arribaDerecha().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(0,2);
		assertEquals(posicionPrueba2, posEsperada);
	}
	
    @Test
	public void comprobarDarAbajoIzquierdaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.abajoIzquierda().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(2,0);
		assertEquals(posicionPrueba2, posEsperada);
	}
    
    @Test
	public void comprobarDarAbajoDerechaSeaCorrecto()
	{
		Posicion posicionPrueba = new Posicion(1,1);
		Posicion posicionPrueba2 =  Direccion.abajoDerecha().proximaPosicion(posicionPrueba);
		Posicion posEsperada = new Posicion(2,2);
		assertEquals(posicionPrueba2, posEsperada);
	}
}
