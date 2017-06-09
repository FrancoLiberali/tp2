package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionamientoPersonaje.EstadoTransformacion;

public class EstadoTransformacionUnitarioTest {

	@Test
	public void crearConVelocidadYObtenerla(){
		EstadoTransformacion Normal = new EstadoTransformacion("normal",8,4,2);
		assertEquals( Normal.getVelocidad(), 2);
	}
	@Test
	public void crearConPoderYObtenerlo(){
		EstadoTransformacion Normal = new EstadoTransformacion("normal",8,4,2);
		assertEquals( Normal.getPoderDePelea(), 8);
	}
	@Test
	public void crearConDistanciaDeAtaqueYObtenerla(){
		EstadoTransformacion Normal = new EstadoTransformacion("normal",8,4,2);
		assertEquals( Normal.getDistanciaDeAtaque(), 4);
	}
	
}
