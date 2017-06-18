package algoBallIntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Equipo;
import personajes.Gohan;
import personajes.Goku;
import personajes.Personaje;
import tablero.Posicion;
import tablero.Tablero;

public class algoBallIntegrationTest1 {
	
	@Test
	public void sePideQueSeMuevaUnPersonajeVerificarPosicionFinal(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Posicion posicionGoku = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGoku);
		
		equipo.agregarPersonaje(goku);
		equipo.moverDerecha(goku);
		Posicion posicionEsperada = new Posicion(1,2);
		
		assertEquals(goku.getPosicion(), posicionEsperada);
	}
	
	@Test
	public void seVerificaQueNoPuedaHaberDosJPersonajesEnUnMismoCasillero(){
		Tablero tablero = new Tablero(10);
		Equipo equipo = new Equipo("buenos");
		
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Posicion posicionGokuInicial = new Posicion(1,1);
		Posicion posicionGohanInicial = new Posicion(1,2);
		tablero.agregarPosicionable(goku, posicionGokuInicial);
		tablero.agregarPosicionable(gohan, posicionGohanInicial);
		
		equipo.agregarPersonaje(goku);
		equipo.agregarPersonaje(gohan);
		
		equipo.moverDerecha(goku);

		assertEquals(goku.getPosicion(), posicionGokuInicial);
	}
	
	/*
	public void seUbicaUnPersonajeSeLoTransformaVerificarQueSePuedaTransformar(){
		Tablero tablero = new Tablero(10);
		
		Personaje goku = new Goku();
		EstadoTransformacion estadoInicial = new EstadoGokuNormal();
		
		Posicion posicionGokuInicial = new Posicion(1,1);
		tablero.agregarPosicionable(goku, posicionGokuInicial);

		assertEquals(goku.getKiCantidad(), 0);
		
		goku.transformar();
		assertEquals(goku.getEstado().getNombre(), estadoInicial.getNombre());
		
		EstadoTransformacion estadoTransfUno = new EstadoGokuKaioKen();
		assertEquals(goku.getEstado().getNombre(), estadoTransfUno.getNombre());

	}*/
	
	
}
