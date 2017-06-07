package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algoBall.Personaje;
import algoBall.Posicion;
import algoBall.Tablero;

public class PersonajeUnitarioTest {

	@Test
	public void CrearPersonaje() {
		Personaje x = new Personaje("x");
		assertEquals(x.getNombre(),"x");
	}
	
	@Test
	public void verificarPosicion(){
		Personaje x = new Personaje("x");
		Tablero tablero = new Tablero(8);
		Posicion xy = new Posicion(1,1, tablero);
		x.setPosicion(xy);
		assertEquals(x.getPosicion().getFila(),1);
		assertEquals(x.getPosicion().getColumna(),1);
		
	}
	
	@Test
	public void verificarVelocidad(){
		Personaje x = new Personaje("x");
		x.setVelocidad(5);
		assertEquals(x.getVelocidad(), 5);
	}
	
	@Test
	public void moverPersonajeVerificarPosicion()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x");
		Posicion posicionInicial = new Posicion(2,2, tablero);
		tablero.agregarPersonaje(x, posicionInicial);
		x.mover_derecha();
		Posicion posicionFinal = new Posicion(3,2, tablero);
		assertEquals(tablero.getPersonajeEn(posicionFinal).getNombre(), x.getNombre());
		
	}
	
	@Test
	public void moverPersonajeALugarInvalido()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x");
		Personaje y = new Personaje("y");
		
		Posicion posicionInicialX = new Posicion(2,2, tablero);
		Posicion posicionInicialY = new Posicion(3,2, tablero);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		x.mover_derecha();
		assertEquals(x.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
}
