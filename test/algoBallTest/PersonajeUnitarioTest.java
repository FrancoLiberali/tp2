package algoBallTest;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionamientoPersonaje.EstadoTransformacion;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;

public class PersonajeUnitarioTest {
	private EstadoTransformacion estadoX = new EstadoTransformacion("normalx",40,2,4);
	private EstadoTransformacion estadoY = new EstadoTransformacion("Y",50,3,5);

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
		assertEquals(x.getPosicion(), xy);
		
	}
	
	@Test
	public void getVelocidadDevuleveLaDelEstadoDeTranformacionActual(){
		Personaje x = new Personaje("x",estadoX);
		assertEquals(x.getVelocidad(), 4);
	}
	
	@Test
	public void getPoderDePeleaDevuleveElDelEstadoDeTranformacionActual(){
		Personaje x = new Personaje("x",estadoX);
		assertEquals(x.getPoderDePelea(), 40);
	}
	
	@Test
	public void getKiParaUnPersonajeRecienCreadoDevuelveUnKiCon0(){
		Personaje x = new Personaje("x",estadoX);
		assertEquals(x.getKi(), 0);
	}
	
	@Test
	public void AumentarKiSumarCantidadAlKi(){
		Personaje x = new Personaje("x",estadoX);
		x.aumentarKi(5);
		assertEquals(x.getKi(), 5);
	}
	
	@Test
	public void getDistanciaDeAtaqueDevuleveLaDelEstadoDeTranformacionActual(){
		Personaje x = new Personaje("x",estadoX);
		assertEquals(x.getDistanciaDeAtaque(), 2);
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
		assertTrue(x.getPosicion().esIgualA(posicionFinal));
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiHayOtroPersonajeEnElLugarAlQueNosQueremosMover()
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
	public void moverPersonajeNoFuncionaSiElLugarAlQueNosQueremosMoverSeEncuentraFueraDelTablero()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x",estadoX);
		
		Posicion posicionInicialX = new Posicion(9,2, tablero);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		
		x.moverDerecha();
		assertEquals(x.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
	@Test
	public void transformarNoFuncionaSiNoHaySiguienteTransformacion(){
		Personaje x = new Personaje("x",estadoX);
		x.transformar();
		assertEquals(x.getEstadoTransformacion(),estadoX);
	}
	
	@Test
	public void transformarNoFuncionaSiHaySiguienteEstadoPeroNoHaySuficienteKi(){
		Personaje x = new Personaje("x",estadoX);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(19);
		x.transformar();
		assertEquals(x.getEstadoTransformacion(),estadoX);
	}
	
	@Test
	public void transformarFuncionaSiHaySiguienteEstadoYKiSuficiente(){
		Personaje x = new Personaje("x",estadoX);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		x.transformar();
		assertEquals(x.getEstadoTransformacion(),estadoY);
	}
	
	@Test
	public void transformarseBajaElKiEnLaCantidadNecesariaParaLaTransformacion(){
		Personaje x = new Personaje("x",estadoX);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		x.transformar();
		assertEquals(x.getKi(),1);
	}
	
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
