package algoBallUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.exceptions.KiInsuficienteException;
import model.personajes.elementos.AtaqueEspecial;
import model.personajes.elementos.Ki;

public class AtaqueEspecialUnitTest 
{
	@Test(expected = KiInsuficienteException.class)
	public void getPorcentajeLanzaKiInsuficienteSiElKiActualEsMenorAlNecesario(){
		int kiNescesario = 10;
		int porcentaje = 20;
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",kiNescesario);
		golpe.setPorcentaje(porcentaje);
		Ki kiActual = new Ki(9);
		golpe.getPorcentaje(kiActual);
	}
	
	@Test
	public void getPorcentajeDevuelveElPorcentajeDeAumentoDeDanioSiElKiEsMayorOIgualAlNecesario(){
		int kiNescesario = 10;
		int porcentaje = 20;
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",kiNescesario);
		golpe.setPorcentaje(porcentaje);
		Ki kiActual = new Ki(10);
		assertEquals(golpe.getPorcentaje(kiActual),20);
	}
	
	@Test
	public void getPorcentajeRestaEnElKiLaCantidadDeKiNecesaria(){
		int kiNescesario = 10;
		int porcentaje = 20;
		AtaqueEspecial golpe = new AtaqueEspecial("Cabezaso Tucumano",kiNescesario);
		golpe.setPorcentaje(porcentaje);
		Ki kiActual = new Ki(10);
		golpe.getPorcentaje(kiActual);
		assertEquals(kiActual.getKi(),0);
	}

}
