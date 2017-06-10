package algoBallUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.CasilleroVacioException;
import exceptions.FueraDeRangoException;
import exceptions.IntentandoAtacarAUnCompanieroException;
import exceptions.NoQuedanMovimientosException;
import funcionamientoPersonaje.EstadoTransformacion;
import funcionamientoPersonaje.Personaje;
import funcionamientoTablero.Posicion;
import funcionamientoTablero.Tablero;
import algoBall.Agrupacion;
import algoBall.ConstantesDelJuego;

public class PersonajeUnitarioTest {
	private EstadoTransformacion estadoX = new EstadoTransformacion("normalx",40,2,2);
	private EstadoTransformacion estadoY = new EstadoTransformacion("Y",50,3,3);

	@Test
	public void CrearPersonajeVerificarNombre() {
		Personaje x = new Personaje("x", estadoX,2);
		assertEquals(x.getNombre(),"x");
	}
	
	@Test
	public void verificarPosicion(){
		Personaje x = new Personaje("x", estadoX,2);
		Posicion xy = new Posicion(1,1);
		x.setPosicion(xy);
		assertEquals(x.getPosicion(), xy);
		
	}
	
	@Test
	public void getVelocidadDevuleveLaDelEstadoDeTranformacionActual(){
		Personaje x = new Personaje("x",estadoX,2);
		assertEquals(x.getVelocidad(), 2);
	}
	
	@Test
	public void getPoderDePeleaDevuleveElDelEstadoDeTranformacionActual(){
		Personaje x = new Personaje("x",estadoX,2);
		assertEquals(x.getPoderDePelea(), 40);
	}
	
	@Test
	public void getKiParaUnPersonajeRecienCreadoDevuelveUnKiCon0(){
		Personaje x = new Personaje("x",estadoX,2);
		assertEquals(x.getKi(), 0);
	}
	
	@Test
	public void AumentarKiSumarCantidadAlKi(){
		Personaje x = new Personaje("x",estadoX,2);
		x.aumentarKi(5);
		assertEquals(x.getKi(), 5);
	}
	
	@Test
	public void getDistanciaDeAtaqueDevuleveLaDelEstadoDeTranformacionActual(){
		Personaje x = new Personaje("x",estadoX,2);
		assertEquals(x.getDistanciaDeAtaque(), 2);
	}
	
	@Test
	public void moverPersonajeVerificarPosicion()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x",estadoX,2);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(x, posicionInicial);
		x.moverDerecha();
		Posicion posicionFinal = new Posicion(2,3);
		assertTrue(x.getPosicion().esIgualA(posicionFinal));
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiHayOtroPersonajeEnElLugarAlQueNosQueremosMover()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x",estadoX,2);
		Personaje y = new Personaje("y",estadoX,2);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		x.moverAbajo();
		assertEquals(x.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiElLugarAlQueNosQueremosMoverSeEncuentraFueraDelTablero()
	{
		Tablero tablero = new Tablero(10);
		Personaje x = new Personaje("x",estadoX,2);
		
		Posicion posicionInicialX = new Posicion(9,2);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		
		x.moverAbajo();
		assertEquals(x.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
	@Test (expected = NoQuedanMovimientosException.class)
	public void intentarMoverPersonajeMasVecesQueSuVelocidadActualLanzaNoQuedanMovimientos(){
		Personaje x = new Personaje("x",estadoX,2);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(x, posicionInicial);
		x.moverDerecha();
		x.moverDerecha();
		/* se alcanza limite de movimientos*/
		x.moverDerecha();
	}
	
	@Test (expected = NoQuedanMovimientosException.class)
	public void intentarMoverPersonajeQueHaSidoProhibidoDeMovimientosLanzaNoQuedanMovimientos(){
		Personaje x = new Personaje("x",estadoX,2);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(x, posicionInicial);
		x.prohibirMovimientos();
		x.moverDerecha();
	}
	
	@Test
	public void transformarNoFuncionaSiNoHaySiguienteTransformacion(){
		Personaje x = new Personaje("x",estadoX,2);
		x.transformar();
		assertEquals(x.getEstadoTransformacion(),estadoX);
	}
	
	@Test
	public void transformarNoFuncionaSiHaySiguienteEstadoPeroNoHaySuficienteKi(){
		Personaje x = new Personaje("x",estadoX,2);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(19);
		x.transformar();
		assertEquals(x.getEstadoTransformacion(),estadoX);
	}
	
	@Test
	public void transformarFuncionaSiHaySiguienteEstadoYKiSuficiente(){
		Personaje x = new Personaje("x",estadoX,2);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		x.transformar();
		assertEquals(x.getEstadoTransformacion(),estadoY);
	}
	
	@Test
	public void transformarseBajaElKiEnLaCantidadNecesariaParaLaTransformacion(){
		Personaje x = new Personaje("x",estadoX,2);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		x.transformar();
		assertEquals(x.getKi(),1);
	}
	
	@Test
	public void transformarseModificaLosValoresDePoderVelocidadYDistancia(){
		Personaje x = new Personaje("x",estadoX,2);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		x.transformar();
		assertEquals(x.getPoderDePelea(),50);
		assertEquals(x.getDistanciaDeAtaque(),3);
		assertEquals(x.getVelocidad(),3);
	}
	
	@Test
	public void transformarseLuegoDeMoverseSinAlcarzarElLimiteDeMovimientosAumentaLaCantidadDeMovimientosPosibles(){
		Personaje x = new Personaje("x",estadoX,2);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(x, posicionInicial);
		x.moverDerecha();
		x.transformar();
		x.moverDerecha();
		/*aqui se abrian limitado los movimientos sin la transformacion*/
		x.moverDerecha();
		Posicion posicionFinal = new Posicion(2,5);
		assertTrue(x.getPosicion().esIgualA(posicionFinal));
	}
	
	@Test (expected = NoQuedanMovimientosException.class)
	public void transformarseLuegoDeMoverseConAlcarzarElLimiteDeMovimientosNoAumentaLaCantidadDeMovimientosPosibles(){
		Personaje x = new Personaje("x",estadoX,2);
		estadoX.setSiguienteEstado(estadoY, 20);
		x.aumentarKi(21);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(x, posicionInicial);
		x.moverDerecha();
		x.moverDerecha();
		/* se alcanza limite de movimientos*/
		Posicion posicionFinal = new Posicion(2,4);
		assertTrue(x.getPosicion().esIgualA(posicionFinal));
		x.transformar();
		x.moverDerecha();
	}
	
	
	@Test
	public void ataqueEntrePersonajesDeDistintasAgrupacionesBajaLaSalud()
	{
		int poder = ConstantesDelJuego.PODER_GOKU_NORMAL;
		
		Tablero tablero = new Tablero(10);
		EstadoTransformacion estadoEspecifico = new EstadoTransformacion ("Normal",poder,10,10);
		Personaje x = new Personaje("x",estadoEspecifico,2);
		Personaje y = new Personaje("y",estadoX, ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(x);
		agrupacion2.agregarPersonaje(y);
		
		x.atacar(posicionInicialY);
		assertEquals(y.getSalud(), 280);
		
	}
	
	@Test (expected = IntentandoAtacarAUnCompanieroException.class)
	public void ataqueEntrePersonajesDeLaMismaAgrupacionLanzaIntentandoAtacarAUnCompaniero()
	{
		int poder = ConstantesDelJuego.PODER_GOKU_NORMAL;
		
		Tablero tablero = new Tablero(10);
		EstadoTransformacion estadoEspecifico = new EstadoTransformacion ("Normal",poder,10,10);
		Personaje x = new Personaje("x",estadoEspecifico,2);
		Personaje y = new Personaje("y",estadoX, ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(x);
		agrupacion1.agregarPersonaje(y);
		
		x.atacar(posicionInicialY);		
	}
	
	@Test(expected = FueraDeRangoException.class)
	public void atacarAUnaPosicionMasLejanaQueLaDistanciaDeAtaqueLanzaFueraDeRango()
	{
		Tablero tablero = new Tablero(10);
		EstadoTransformacion estadoEspecifico = new EstadoTransformacion ("Normal",20,2,2);
		Personaje x = new Personaje("x",estadoEspecifico,2);
		Personaje y = new Personaje("y",estadoX,100);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(5,5);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		tablero.agregarPersonaje(y, posicionInicialY);
		
		x.atacar(posicionInicialY);
		
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void atacarAUnaPosicionQueEstaDentroDelRangoPeroNoContinePersonajeLanzaCasilleroVacio()
	{
		Tablero tablero = new Tablero(10);
		EstadoTransformacion estadoEspecifico = new EstadoTransformacion ("Normal",20,2,2);
		Personaje x = new Personaje("x",estadoEspecifico,100);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,3);
		posicionInicialY.setTablero(tablero);
		
		tablero.agregarPersonaje(x, posicionInicialX);
		
		x.atacar(posicionInicialY);
		
	}
	
	
}
