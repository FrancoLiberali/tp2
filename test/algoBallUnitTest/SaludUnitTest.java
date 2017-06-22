package algoBallUnitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.personajes.elementos.Salud;

public class SaludUnitTest 
{
	@Test
	public void crearSaludConValorCienVerificarValorSaludActual()
	{
		int valor = 100;
		Salud salud = new Salud(valor);
		assertEquals(salud.getSalud(), valor);
	} 
	@Test
	public void crearSaludConValorCienVerificarValorSaludInicial()
	{
		int valor = 100;
		Salud salud = new Salud(valor);
		assertEquals(salud.getSaludInicial(), valor);
	} 
	
	@Test
	public void restarSaludVerificarSaludActual()
	{
		int valor = 100;
		int valorDisminuir = 50;
		int esperado = valor - valorDisminuir;
		Salud salud = new Salud(valor);
		salud.disminuir(new Salud(valorDisminuir));
		
		assertEquals(salud.getSalud(), esperado);
	}
	
	@Test
	public void disminuirSaludVerificarSaludInicialNoCambia()
	{
		int inicial = 100;
		int valorDisminuir = 50;
		Salud salud = new Salud(inicial);
		salud.disminuir(new Salud(valorDisminuir));
		
		assertEquals(salud.getSaludInicial(), inicial);
	}
	
	@Test
	public void aumentarSaludVerificarSaludActualEsLaInicial()
	{
		int inicial = 100;
		int valorAumentar = 70;
		Salud salud = new Salud(inicial);
		salud.aumentar(new Salud(valorAumentar));
		
		assertEquals(salud.getSalud(), inicial);
		/*Esta con su maxima vida*/
	}
	
	@Test
	public void aumentarSaludVerificarSaludInicial()
	{
		int inicial = 100;
		int valorAumentar = 70;
		Salud salud = new Salud(inicial);
		salud.aumentar(new Salud(valorAumentar));
		
		assertEquals(salud.getSaludInicial(), inicial);
	}
	
	@Test
	public void crearSaludConValorPredVerificarQueNoEsCero()
	{
		int inicial = 100;
		Salud salud = new Salud(inicial);
		
		assertTrue(!salud.esCero());
	}
	
	@Test
	public void disminuirSaludVerificarPorcentajeDeSalud()
	{
		int inicial = 300;
		int valorDisminuir = 65;
		int porcentajeEsperado = (inicial - valorDisminuir) * 100 /inicial;
		Salud salud = new Salud(inicial);
		salud.disminuir(new Salud(valorDisminuir));
		
		assertEquals(salud.getPorcentajeSalud(), porcentajeEsperado);
	}
	
	@Test
	public void disminuirYAumentarSaludVerificarPorcentajeDeSalud()
	{
		int inicial = 300;
		int valorAumentar = 65;
		int valorDisminuir = 200;
		int porcentajeEsperado = ((inicial - valorDisminuir) + valorAumentar)*100 /inicial;
		
		Salud salud = new Salud(inicial);
		salud.disminuir(new Salud(valorDisminuir));
		salud.aumentar(new Salud(valorAumentar));
		
		assertEquals(salud.getPorcentajeSalud(), porcentajeEsperado);
	}
		
	@Test
	public void disminuirYAumentarSaludAlTopeVerificarSaludActualEsInicial()
	{
		int inicial = 300;
		int valorDisminuir = 200;
		int valorAumentar = 1000;		
		Salud salud = new Salud(inicial);
		salud.disminuir(new Salud(valorDisminuir));
		salud.aumentar(new Salud(valorAumentar));
		
		assertEquals(salud.getSalud(), inicial);
	}
	
	@Test
	public void disminuirSaludAlTopeVerificarSaludActualEsCero()
	{
		int inicial = 300;
		int valorDisminuir = 1000;		
		Salud salud = new Salud(inicial);
		salud.disminuir(new Salud(valorDisminuir));
		
		assertTrue(salud.esCero());
	}
	
}
