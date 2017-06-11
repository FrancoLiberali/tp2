package algoBallUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.*;
import funcionamientoPersonaje.*;
import funcionamientoTablero.*;
import static algoBall.ConstantesDelJuego.*;
import algoBall.Agrupacion;

public class PersonajeUnitTest 
{
	@Test
	public void CrearPersonajeVerificarNombre()
	{
		Personaje goku = new Goku();
		assertEquals(goku.getNombre(),GOKU_NOMBRE);
	}
	
	@Test
	public void verificarPosicion()
	{
		Personaje goku = new Goku();
		Posicion pos = new Posicion(1,1);
		goku.setPosicion(pos);
		assertEquals(goku.getPosicion(), pos);
		
	}
	
	@Test
	public void getVelocidadDevuleveLaDelEstadoDeTranformacionNromal()
	{
		Personaje gohan = new Gohan();
		assertEquals(gohan.getVelocidad(), VELOCIDAD_GOHAN_NORMAL);
	}
	
	@Test
	public void getPoderDePeleaDevuleveElDelEstadoDeTranformacionActual()
	{
		Personaje gohan = new Gohan();
		assertEquals(gohan.getPoderDePelea(), PODER_GOHAN_NORMAL);
	}
	
	@Test
	public void getKiParaUnPersonajeRecienCreadoDevuelveUnKiConCero()
	{
		Personaje gohan = new Gohan();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		Personaje piccolo = new Piccolo();
		Personaje freezer = new Freezer();
		Personaje majinBoo = new MajinBoo();
		
		assertEquals(gohan.getKi(), KI_INICIAL);
		assertEquals(goku.getKi(), KI_INICIAL);
		assertEquals(cell.getKi(), KI_INICIAL);
		assertEquals(piccolo.getKi(), KI_INICIAL);
		assertEquals(freezer.getKi(), KI_INICIAL);
		assertEquals(majinBoo.getKi(), KI_INICIAL);
	}
	
	@Test
	public void AumentarKiSumarCantidadAlKi()
	{
		Personaje goku = new Goku();
		int cant = 5;
		goku.aumentarKi(cant);
		assertEquals(goku.getKi(), cant);
	}
	
	@Test
	public void getDistanciaDeAtaqueDevuleveLaDelEstadoDeTranformacionActual()
	{
		Personaje goku = new Goku();
		assertEquals(goku.getDistanciaDeAtaque(), DISTANCIA_GOKU_NORMAL);
	}
	
	@Test
	public void transformarConINsuficienteKiQuedaEnElMismoEstadoVerificarAtributos(){
		Personaje goku = new Goku();
		//ki nescesario = 20;
		goku.aumentarKi(10);
		goku.transformar();
		EstadoTransformacion estado = goku.getEstadoTransformacion();
		assertEquals(estado.getNombre(), NOMBRE_TRANF_NORMAL);
		assertEquals(estado.getPoderDePelea(), PODER_GOKU_NORMAL);
		assertEquals(estado.getDistanciaDeAtaque(), DISTANCIA_GOKU_NORMAL);
		assertEquals(estado.getVelocidad(), VELOCIDAD_GOKU_NORMAL);
	}

	@Test
	public void transformarFuncionaSiHaySiguienteEstadoYKiSuficienteVerificarAtributos(){
		Personaje goku = new Goku();
		goku.aumentarKi(40);
		goku.transformar();
		EstadoTransformacion estado = goku.getEstadoTransformacion();
		assertEquals(estado.getNombre(), NOMBRE_GOKU_PRIMERA_TRANSF);
		assertEquals(estado.getPoderDePelea(), PODER_GOKU_PRIMERA_TRANSF);
		assertEquals(estado.getDistanciaDeAtaque(), DISTANCIA_GOKU_PRIMERA_TRANSF);
		assertEquals(estado.getVelocidad(), VELOCIDAD_GOKU_PRIMERA_TRANSF);
	}
	
	@Test
	public void transformarseBajaElKiEnLaCantidadNecesariaParaLaTransformacion(){
		Personaje goku = new Goku();
		int ki = 40;
		int kiEsperado = ki - KI_GOKU_PRIMERA_TRANF;
		goku.aumentarKi(ki);
		goku.transformar();
		
		assertEquals(goku.getKi(), kiEsperado);
	}
	
	@Test
	public void ataqueEntrePersonajesDeDistintasAgrupacionesBajaLaSalud()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - PODER_GOKU_NORMAL;
		
		goku.realizarAtaqueBasico(posicionInicialY);
		assertEquals(cell.getSalud(), saludEsperada);
		
	}
	
	@Test (expected = IntentandoAtacarAUnCompanieroException.class)
	public void ataqueEntrePersonajesDeLaMismaAgrupacionLanzaIntentandoAtacarAUnCompaniero()
	{
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(gohan, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(goku);
		agrupacion1.agregarPersonaje(gohan);
		
		goku.realizarAtaqueBasico(posicionInicialY);		
	}
	
	@Test(expected = FueraDeRangoException.class)
	public void atacarAUnaPosicionMasLejanaQueLaDistanciaDeAtaqueLanzaFueraDeRango()
	{
		Personaje goku = new Goku();
		Personaje cell = new Cell();
	
		Tablero tablero = new Tablero(10);
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(5,5);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		goku.realizarAtaqueBasico(posicionInicialY);
	}
	
	@Test(expected = CasilleroVacioException.class)
	public void atacarAUnaPosicionQueEstaDentroDelRangoPeroNoContinePersonajeLanzaCasilleroVacio()
	{
		Personaje goku = new Goku();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,3);
		posicionInicialY.setTablero(tablero);
		tablero.agregarPersonaje(goku, posicionInicialX);
		
		goku.realizarAtaqueBasico(posicionInicialY);
	}
	
	
}
