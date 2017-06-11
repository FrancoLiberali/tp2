package algoBallUnitTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import exceptions.KiInsuficienteException;
import funcionamientoPersonaje.Ki;


public class KiUnitTest {
	
	@Test
	public void CrearKiyObtenerKiInicial(){
		Ki ki = new Ki(2);
		assertEquals(ki.getKi(),2);
	} 
	@Test
	public void SumarKiDevuelveInicialMasLoAniadido(){
		Ki ki = new Ki(2);
		ki.sumar(3);
		assertEquals(ki.getKi(),5);
	}
	
	@Test
	public void siUnKiEsMayorAOtroKiDevuelveUno(){
		Ki ki1 = new Ki(3);
		Ki ki2 = new Ki(1);
		assertEquals(ki1.compareTo(ki2), 1);
	}
	
	@Test
	public void siUnKiEsMenorAOtroKiDevuelveMenosUno(){
		Ki ki1 = new Ki(3);
		Ki ki2 = new Ki(1);
		assertEquals(ki2.compareTo(ki1), -1);
	}
	
	@Test
	public void siUnKiTieneElMismoValorAOtroDevuelveCero(){
		Ki ki1 = new Ki(10);
		Ki ki2 = new Ki(10);
		assertEquals(ki2.compareTo(ki1), 0);
	}
	
	@Test
	public void RestarUnKiMenorReduceElKiDelPrimeroYNoMoficaElSegundo(){
		Ki ki1 = new Ki(3);
		Ki ki2 = new Ki(1);
		ki1.restar(ki2);
		assertEquals(ki1.getKi(),2);
		assertEquals(ki2.getKi(),1);
	}
	
	@Test
	public void RestarUnKiIgualDejaElKiDelPrimeroEnCeroYNoMoficaElSegundo(){
		Ki ki1 = new Ki(1);
		Ki ki2 = new Ki(1);
		ki1.restar(ki2);
		assertEquals(ki1.getKi(),0);
		assertEquals(ki2.getKi(),1);
	}
	
	@Test(expected = KiInsuficienteException.class)
	public void restarUnKiDeMenorValorAUnoDeMayorLevantaExcepcion(){
		Ki ki1 = new Ki(1);
		Ki ki2 = new Ki(2);
		ki1.restar(ki2);
	}

}
