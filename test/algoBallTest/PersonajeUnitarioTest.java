package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionamientoPersonaje.EstadoTransformacion;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class PersonajeUnitarioTest {
	private EstadoTransformacion estadoX = new EstadoTransformacion("normalx",40,2,4);

	@Test
	public void CrearPersonajeVerificarNombre() {
		Personaje x = new Personaje("x", estadoX);
		assertEquals(x.getNombre(),"x");
	}
	
	@Test
	public void verificarPosicion(){
		Personaje x = new Personaje("x", estadoX);
		Tablero tablero = new Tablero(8);
		Posicion xy = new Posicion(1,1, tablero);
		x.setPosicion(xy);
		assertEquals(x.getPosicion().getFila(),1);
		assertEquals(x.getPosicion().getColumna(),1);
		
	}
	
	@Test
	public void verificarVelocidad(){
		Personaje x = new Personaje("x",estadoX);
		assertEquals(x.getVelocidad(), 4);
	}
	
	@Test
	public void moverPersonajeVerificarPosicion()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x",estadoX);
		Posicion posicionInicial = new Posicion(2,2, tablero);
		tablero.agregarPersonaje(x, posicionInicial);
		x.moverDerecha();
		Posicion posicionFinal = new Posicion(3,2, tablero);
		assertEquals(tablero.getPersonajeEn(posicionFinal).getNombre(), x.getNombre());
		
	}
	
	@Test
	public void moverPersonajeALugarInvalido()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x",estadoX);
		Personaje y = new Personaje("y",estadoX);
		
		Posicion posicionInicialX = new Posicion(2,2, tablero);
		Posicion posicionInicialY = new Posicion(3,2, tablero);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		x.moverDerecha();
		assertEquals(x.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
	@Test
	public void ataqueEntrePersonajes()
	{
		Tablero tablero = new Tablero(10);
		EstadoTransformacion estadoEspecifico = new EstadoTransformacion ("Normal",20,2,2);
		Personaje x = new Personaje("x",estadoEspecifico);
		Personaje y = new Personaje("y",estadoX);
		y.setSalud(100);
		
		Posicion posicionInicialX = new Posicion(2,2, tablero);
		Posicion posicionInicialY = new Posicion(3,2, tablero);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		x.atacar(posicionInicialY);
		assertEquals(y.getSalud(), 80);
		
	}
	
	
	
}
