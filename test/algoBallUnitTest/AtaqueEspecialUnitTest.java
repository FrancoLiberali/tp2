package algoBallUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.KiInsuficienteException;
import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.Ki;

public class AtaqueEspecialUnitTest 
{
	
	@Test
	public void danioRealizadoPorAtaqueEspecialEsUnPorcentajeMayorAlBasico(){
		int kiNescesario = 10;
		int ataqueBasico = 100;
		int porcentaje = 20;
		Ki kiActual = new Ki(11);
		int ataqueEsperado = 120;
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",kiNescesario);
		golpe.setPorcentaje(porcentaje);

		assertEquals(golpe.getAtaque(ataqueBasico, kiActual),ataqueEsperado);
	}
	
	@Test(expected = KiInsuficienteException.class)
	public void getAtaqueLanzaKiInsuficienteSiElKiActualEsMenorAlNecesario(){
		int kiNescesario = 10;
		int ataqueBasico = 100;
		int porcentaje = 20;
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",kiNescesario);
		golpe.setPorcentaje(porcentaje);
		Ki kiActual = new Ki(9);
		golpe.getAtaque(ataqueBasico, kiActual);
	}

}
