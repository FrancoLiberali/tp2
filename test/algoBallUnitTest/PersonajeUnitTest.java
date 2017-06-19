package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.GOKU_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import personajes.Cell;
import personajes.Freezer;
import personajes.Gohan;
import personajes.Goku;
import personajes.MajinBoo;
import personajes.Personaje;
import personajes.Piccolo;
import tablero.Posicion;

public class PersonajeUnitTest 
{
	@Test
	public void CrearPersonajeVerificarNombre()
	{
		Personaje goku = new Goku();
		assertEquals(goku.getNombre(),GOKU_NOMBRE);
	}
	
	@Test
	public void verificarPosicion()
	{
		Personaje goku = new Goku();
		Posicion pos = new Posicion(1,1);
		goku.setPosicion(pos);
		assertEquals(goku.getPosicion(), pos);
		
	}
	

	@Test
	public void reducirSaludPersonajeVerificarValor()
	{
		Personaje gohan = new Gohan();
		int cantidadAReducir = 100;
		int esperado = gohan.getSalud() - cantidadAReducir;
		gohan.reducirSalud(cantidadAReducir);
		assertEquals(gohan.getSalud(), esperado);
	}
	
	@Test
	public void getKiParaUnPersonajeRecienCreadoDevuelveUnKiConCero()
	{
		Personaje gohan = new Gohan();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		Personaje piccolo = new Piccolo();
		Personaje freezer = new Freezer();
		Personaje majinBoo = new MajinBoo();
		
		assertEquals(gohan.getKiCantidad(), KI_INICIAL);
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
		assertEquals(cell.getKiCantidad(), KI_INICIAL);
		assertEquals(piccolo.getKiCantidad(), KI_INICIAL);
		assertEquals(freezer.getKiCantidad(), KI_INICIAL);
		assertEquals(majinBoo.getKiCantidad(), KI_INICIAL);
	}
	
	@Test
	public void aumentarKiSumarCantidadAlKi()
	{
		Personaje goku = new Goku();
		int cant = 5;
		goku.aumentarKi(cant);
		assertEquals(goku.getKiCantidad(), cant);
	}
	
	
}
