package algoBallUnitTest;

import org.junit.Test;

import exceptions.KiInsuficienteException;
import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.Ki;

public class AtaqueEspecialUnitTest 
{
	
	
	@Test(expected = KiInsuficienteException.class)
	public void getAtaqueLanzaKiInsuficienteSiElKiActualEsMenorAlNecesario(){
		int kiNescesario = 10;
		int porcentaje = 20;
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",kiNescesario);
		golpe.setPorcentaje(porcentaje);
		Ki kiActual = new Ki(9);
		golpe.getPorcentaje(kiActual);
	}

}
