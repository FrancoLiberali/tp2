package algoBallUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import consumibles.Consumible;
import consumibles.EsferaDelDragon;
import consumibles.NubeVoladora;
import consumibles.SemillaDelErmitanio;
import personajes.Goku;
import personajes.Personaje;

public class ConsumiblesUnitTest 
{
	@Test
	public void personajeAgarraUnaSemillaDelErmitanioComprobarSaludAumentaCien()
	{
		Consumible semilla = new SemillaDelErmitanio();
		Personaje goku = new Goku();	
		int saludAReducir = 200;
		int esperado = goku.getSalud() - saludAReducir + 100; //semilla +100 salud
		
		goku.reducirSalud(saludAReducir);
		goku.agarrarConsumible(semilla);
		
		assertEquals(goku.getSalud(), esperado);
	}
	
	@Test
	public void personajeAgarraUnaEsferaDelDragonComprobarDanioAumentaUn25Porcien()
	{
		Consumible esfera = new EsferaDelDragon();
		Personaje goku = new Goku();
		
		int danio = goku.getPoderDePelea();
		int esperado = (int) (danio + danio * 0.25); //esfera +25% danio
		goku.agarrarConsumible(esfera);
		
		assertEquals(goku.getPoderDePelea(), esperado);
	}
	
	@Test
	public void personajeAgarraUnaNubeVoladoraVreificarQueAumentaLaVelocidadAlDoble()
	{
		Consumible nube = new NubeVoladora();
		Personaje goku = new Goku();
		
		int velocidad = goku.getVelocidad();
		int velEsperada = velocidad * 2; 
		goku.agarrarConsumible(nube);
		
		assertEquals(goku.getVelocidad(), velEsperada);
	}
	
	
	@Test
	public void personajeAgarraUnaNubeVoladoraYEsferaDelDragonVerificarReultadosAditivos()
	{
		Consumible nube = new NubeVoladora();
		Consumible esfera = new EsferaDelDragon();
		Personaje goku = new Goku();
		
		int velocidad = goku.getVelocidad();
		int velEsperada = velocidad * 2; 
		goku.agarrarConsumible(nube);
		
		int danio = goku.getPoderDePelea();
		int esperado = (int) (danio + danio * 0.25); //esfera +25% danio
		goku.agarrarConsumible(esfera);
		
		assertEquals(goku.getPoderDePelea(), esperado);
		assertEquals(goku.getVelocidad(), velEsperada);
	}
	
	
	@Test
	public void personajeAgarraDosNubesVOladorasSeCuatriplicaLaVelocidad()
	{
		Consumible nube = new NubeVoladora();
		Personaje goku = new Goku();
		
		int velocidad = goku.getVelocidad();
		int velEsperada = velocidad * 4; 
		goku.agarrarConsumible(nube);
		goku.agarrarConsumible(nube);
		
		assertEquals(goku.getVelocidad(), velEsperada);
	}
	
	@Test
	public void personajeAgarraNubeVoladoraLuegoDeDosTurnosTerminaElEfecto()
	{
		Consumible nube = new NubeVoladora();
		Personaje goku = new Goku();
		
		int velocidad = goku.getVelocidad();
		goku.agarrarConsumible(nube);
		
		//paso turnos
		goku.actualizarEstado();
		goku.actualizarEstado();	
		
		//a partir de este se termina el efecto.
		goku.actualizarEstado();

		assertEquals(goku.getVelocidad(), velocidad);
	}
	
}