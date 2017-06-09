package algoBallIntegrationTest;

import org.junit.Test;

import algoBall.AlgoBall;

public class AlgoBallIntegracionTest {
	
	@Test
	public void pruebaDeIntegracion(){
		AlgoBall juego = new AlgoBall("juan", "pepe");
		juego.moverAbajo("Goku");
	}

}
