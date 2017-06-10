package algoBallUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.KiInsuficienteException;
import funcionamientoPersonaje.AtaqueEspecial;
import funcionamientoPersonaje.Ki;

public class AtaqueEspecialUnitarioTest {
	
	@Test
	public void getAtaqueDevuelveElAtaqueQueRecibeMasElPorcentajeSiElKiEsMayorAlNecesario(){
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",10);
		golpe.setPorcentaje(0.5);
		Ki kiActual = new Ki(11);
		assertEquals(golpe.getAtaque(10, kiActual),15);
	}
	
	@Test(expected = KiInsuficienteException.class)
	public void getAtaqueLanzaKiInsuficienteSiElKiActualEsMenorAlNecesario(){
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",10);
		golpe.setPorcentaje(0.5);
		Ki kiActual = new Ki(9);
		golpe.getAtaque(10, kiActual);
	}

}
