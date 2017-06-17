package algoBallUnitTest;

import org.junit.Test;

import consumibles.Consumible;
import consumibles.SemillaDelErmitanio;
import personajes.Goku;
import personajes.Personaje;

public class ConsumiblesUnitTest 
{
	@Test
	public void personajeAgarraUnaSemillaDelErmitanioComprobarSalud()
	{
		Consumible semilla = new SemillaDelErmitanio();
		Personaje goku = new Goku();
		
		goku.agarrarConsumible(semilla);
	}
}
