package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionamientoPersonaje.EstadoTransformacion;

public class EstadoTransformacionUnitarioTest {

	@Test
	public void agregarVelocidadYObtenerla(){
		EstadoTransformacion pepe = new EstadoTransformacion();
		pepe.setVelocidad(8);
		assertEquals( pepe.getVelocidad(), 8);
	}
	
}
