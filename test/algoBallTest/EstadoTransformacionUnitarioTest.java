package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.KiInsuficienteException;
import exceptions.YaNoPuedeEvolucionarException;
import funcionamientoPersonaje.EstadoTransformacion;
import funcionamientoPersonaje.Ki;

public class EstadoTransformacionUnitarioTest {

	@Test
	public void crearConVelocidadYObtenerla(){
		EstadoTransformacion normal = new EstadoTransformacion("normal",8,4,2);
		assertEquals( normal.getVelocidad(), 2);
	}
	@Test
	public void crearConPoderYObtenerlo(){
		EstadoTransformacion normal = new EstadoTransformacion("normal",8,4,2);
		assertEquals( normal.getPoderDePelea(), 8);
	}
	@Test
	public void crearConDistanciaDeAtaqueYObtenerla(){
		EstadoTransformacion normal = new EstadoTransformacion("normal",8,4,2);
		assertEquals( normal.getDistanciaDeAtaque(), 4);
	}
	
	@Test(expected = YaNoPuedeEvolucionarException.class)
	public void crearEIntentarTransformarLanzaYaNoPuedeEvolucionar(){
		EstadoTransformacion normal = new EstadoTransformacion("normal",8,4,2);
		Ki ki = new Ki(0);
		normal.transformar(ki);
	}
	
	@Test(expected = KiInsuficienteException.class)
	public void IntentarTransformarConMenosKiDelNecesarioLanzaKiInsuficiente(){
		EstadoTransformacion normal = new EstadoTransformacion("normal",8,4,2);
		EstadoTransformacion ultra = new EstadoTransformacion("super",10,5,2);
		normal.setSiguienteEstado(ultra, 2);
		Ki ki = new Ki(1);
		normal.transformar(ki);
	}
	
	@Test
	public void TransformarConKiNecesarioDevuelveElSiguienteEstadoYReduceElKi(){
		EstadoTransformacion normal = new EstadoTransformacion("normal",8,4,2);
		EstadoTransformacion ultra = new EstadoTransformacion("super",10,5,2);
		normal.setSiguienteEstado(ultra, 2);
		Ki ki = new Ki(3);
		assertEquals( normal.transformar(ki), ultra);
		assertEquals( ki.getKi(), 1);
	}
	
	
	
}
