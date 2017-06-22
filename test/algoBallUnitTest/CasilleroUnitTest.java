package algoBallUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.consumibles.Consumible;
import model.consumibles.EsferaDelDragon;
import model.exceptions.CasilleroOcupadoException;
import model.exceptions.CasilleroVacioException;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.tablero.Casillero;

public class CasilleroUnitTest
{
	@Test
	public void CasilleroRecienCreadoEstaVacio(){
		Casillero c1 = new Casillero();
		assertTrue(c1.estaVacio());
	}
	
	@Test
	public void ocupoVerificoCasilleroNoVacio(){
		Casillero c1 = new Casillero();
		Goku goku = new Goku();
		c1.ocupar(goku);
		assertTrue(!c1.estaVacio());
	}
	
	public void vaciarCasilleroVerificarQueQuedeVacio(){
		Casillero c1 = new Casillero();
		Goku goku = new Goku();
		c1.ocupar(goku);
		c1.vaciar();
		assertTrue(c1.estaVacio());
	}
	
	@Test(expected = CasilleroOcupadoException.class)
	public void tratarDeOcuparDosVecesLanzaCasilleroOcupado(){
		Casillero c1 = new Casillero();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		c1.ocupar(goku);
		c1.ocupar(gohan);
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void vaciarCasilleroVacioLanzaCasillleroVacio(){
		Casillero c1 = new Casillero();
		c1.vaciar();
	}
	
	@Test
	public void obtenerElConsumibleDeUnCasilleroQueSeLeAgregoConsumibleLoDebvuelve(){
		Casillero c1 = new Casillero();
		Consumible bola = new EsferaDelDragon();
		c1.agregarConsumible(bola);
		assertEquals((Consumible)c1.getConsumible(), bola);
	}
	
	@Test
	public void obtenerElConsumibleDeUnCasilleroVacioDevuelveNull(){
		Casillero c1 = new Casillero();
		assertEquals((Consumible)c1.getConsumible(), null);
	}
	
	@Test
	public void obtenerElConsumibleDeUnCasilleroOcupadoDevuelveNull(){
		Casillero c1 = new Casillero();
		Goku goku = new Goku();
		c1.ocupar(goku);
		assertEquals((Consumible)c1.getConsumible(), null);
	}
	
	@Test
	public void obtenerElConsumibleDeUnCasilleroOcupadoAlQueSeLeAgregaConsumibleDevuelveNull(){
		Casillero c1 = new Casillero();
		Goku goku = new Goku();
		c1.ocupar(goku);
		Consumible bola = new EsferaDelDragon();
		c1.agregarConsumible(bola);
		assertEquals((Consumible)c1.getConsumible(), null);
	}
}