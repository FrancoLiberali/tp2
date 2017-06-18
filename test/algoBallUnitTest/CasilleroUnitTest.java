package algoBallUnitTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.CasilleroOcupadoException;
import exceptions.CasilleroVacioException;
import personajes.Gohan;
import personajes.Goku;
import tablero.Casillero;

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
}