package algoBallUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.*;
import funcionamientoPersonaje.elementos.*;
import funcionamientoPersonaje.personajes.Cell;
import funcionamientoPersonaje.personajes.Freezer;
import funcionamientoPersonaje.personajes.Gohan;
import funcionamientoPersonaje.personajes.Goku;
import funcionamientoPersonaje.personajes.MajinBoo;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoPersonaje.personajes.Piccolo;
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
	public void aumentarKiSumarCantidadAlKi()
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
		EstadoActividad estado = goku.getEstadoActividad();
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
		EstadoActividad estado = goku.getEstadoActividad();
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
	public void transformarseLuegoDeMoverseSinAlcarzarElLimiteDeMovimientosAumentaLaCantidadDeMovimientosPosibles(){
		Personaje goku = new Goku();
		Agrupacion guerrerosZ = new Agrupacion("z");
		goku.setAgrupacion(guerrerosZ);
		goku.aumentarKi(40);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(goku, posicionInicial);
		goku.moverDerecha();
		goku.transformar();
		goku.moverDerecha();
		/*aqui se abrian limitado los movimientos sin la transformacion*/
		goku.moverDerecha();
		Posicion posicionFinal = new Posicion(2,5);
		assertEquals(goku.getPosicion(),posicionFinal);
	}
	
	@Test (expected = NoQuedanMovimientosException.class)
	public void transformarseLuegoDeMoverseConAlcarzarElLimiteDeMovimientosNoAumentaLaCantidadDeMovimientosPosibles(){
		Personaje goku = new Goku();
		Agrupacion guerrerosZ = new Agrupacion("guerrerosZ");
		goku.setAgrupacion(guerrerosZ);
		goku.aumentarKi(40);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(goku, posicionInicial);
		goku.moverDerecha();
		goku.moverDerecha();
		/* se alcanza limite de movimientos*/
		Posicion posicionFinal = new Posicion(2,4);
		assertEquals(goku.getPosicion(), posicionFinal);
		goku.transformar();
		goku.moverDerecha();
	}
	
	@Test
	public void ataqueEntrePersonajesDeDistintasAgrupacionesBajaLaSaludIgualAlAtaqueSiElAtacanteEsMasFuerte()
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
		
		goku.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
		
	}
	
	@Test
	public void ataqueEntrePersonajesDeDistintasAgrupacionesBajaLaSaludMenosUn20PorCientoSiElAtacanteEsMasDebil()
	{
		Personaje gohan = new Gohan();
		Personaje cell = new Cell();
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(gohan, posicionInicialX);
		tablero.agregarPersonaje(cell, posicionInicialY);
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		Agrupacion agrupacion2 = new Agrupacion("malos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - PODER_GOHAN_NORMAL + PODER_GOHAN_NORMAL * REDUCCION_DE_ATAQUE /100;
		
		gohan.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
		
	}
	
	
	@Test (expected = NoQuedanMovimientosException.class)
	public void intentarMoverPersonajeMasVecesQueSuVelocidadActualLanzaNoQuedanMovimientos(){
		Personaje piccolo = new Piccolo();
		Agrupacion guerrerosZ = new Agrupacion("Guerreros Z");
		piccolo.setAgrupacion(guerrerosZ);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(piccolo, posicionInicial);
		piccolo.moverDerecha();
		piccolo.moverDerecha();
		/* se alcanza limite de movimientos*/
		piccolo.moverDerecha();
	}
	
	@Test (expected = NoQuedanMovimientosException.class)
	public void intentarMoverPersonajeQueHaSidoProhibidoDeMovimientosLanzaNoQuedanMovimientos(){
		Personaje majinBoo = new MajinBoo();
		Agrupacion enemigos = new Agrupacion("enemigos");
		majinBoo.setAgrupacion(enemigos);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(majinBoo, posicionInicial);
		majinBoo.prohibirMovimientos();
		majinBoo.moverDerecha();
	}
	
	@Test
	public void moverPersonajeVerificarPosicion()
	{
		
		Tablero tablero = new Tablero(10);
		Agrupacion guerrerosZ = new Agrupacion("GuerrerosZ");
		Personaje goku = new Goku();
		goku.setAgrupacion(guerrerosZ);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(goku, posicionInicial);
		goku.moverDerecha();
		Posicion posicionFinal = new Posicion(2,3);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiHayOtroPersonajeEnElLugarAlQueNosQueremosMover()
	{
		Tablero tablero = new Tablero(10);
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(piccolo, posicionInicialY);
		
		goku.moverAbajo();
		assertEquals(goku.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiElLugarAlQueNosQueremosMoverSeEncuentraFueraDelTablero()
	{
		Tablero tablero = new Tablero(10);
		Personaje piccolo = new Piccolo();
		
		Posicion posicionInicialX = new Posicion(9,2);
		
		tablero.agregarPersonaje(piccolo, posicionInicialX);
		
		piccolo.moverAbajo();
		assertEquals(piccolo.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
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
		
		goku.realizarAtaqueBasico(gohan);		
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
		
		goku.realizarAtaqueBasico(cell);
	}
	
	
	
}
