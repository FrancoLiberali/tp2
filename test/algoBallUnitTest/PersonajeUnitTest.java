package algoBallUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import exceptions.*;
import personajes.Cell;
import personajes.Freezer;
import personajes.Gohan;
import personajes.Goku;
import personajes.MajinBoo;
import personajes.Personaje;
import personajes.Piccolo;
import personajes.elementos.*;
import tablero.*;

import static algoBall.ConstantesDelJuego.*;
import algoBall.Equipo;

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
	public void reducirSaludPersonajeVerificarValor()
	{
		Personaje gohan = new Gohan();
		int cantidadAReducir = 100;
		int esperado = gohan.getSalud() - cantidadAReducir;
		gohan.reducirSalud(cantidadAReducir);
		assertEquals(gohan.getSalud(), esperado);
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
		
		assertEquals(gohan.getKiCantidad(), KI_INICIAL);
		assertEquals(goku.getKiCantidad(), KI_INICIAL);
		assertEquals(cell.getKiCantidad(), KI_INICIAL);
		assertEquals(piccolo.getKiCantidad(), KI_INICIAL);
		assertEquals(freezer.getKiCantidad(), KI_INICIAL);
		assertEquals(majinBoo.getKiCantidad(), KI_INICIAL);
	}
	
	@Test
	public void aumentarKiSumarCantidadAlKi()
	{
		Personaje goku = new Goku();
		int cant = 5;
		goku.aumentarKi(cant);
		assertEquals(goku.getKiCantidad(), cant);
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
		EstadoActividad estado = goku.getEstado();
		assertEquals(estado.getNombre(), NOMBRE_TRANF_NORMAL);
		assertEquals(estado.getPoderDePelea(), PODER_GOKU_NORMAL);
		assertEquals(estado.getDistanciaDeAtaque(), DISTANCIA_GOKU_NORMAL);
		assertEquals(estado.getVelocidad(), VELOCIDAD_GOKU_NORMAL);
	}

	@Test
	public void transformarFuncionaSiHaySiguienteEstadoYKiSuficienteVerificarAtributos(){
		Personaje goku = new Goku();
		goku.aumentarKi(40);
		Equipo guerrerosZ = new Equipo("z");
		goku.setEquipo(guerrerosZ);
		goku.transformar();
		EstadoActividad estado = goku.getEstado();
		assertEquals(estado.getNombre(), NOMBRE_GOKU_PRIMERA_TRANSF);
		assertEquals(estado.getPoderDePelea(), PODER_GOKU_PRIMERA_TRANSF);
		assertEquals(estado.getDistanciaDeAtaque(), DISTANCIA_GOKU_PRIMERA_TRANSF);
		assertEquals(estado.getVelocidad(), VELOCIDAD_GOKU_PRIMERA_TRANSF);
	}
	
	@Test
	public void transformarseBajaElKiEnLaCantidadNecesariaParaLaTransformacion(){
		Personaje goku = new Goku();
		Equipo guerrerosZ = new Equipo("z");
		goku.setEquipo(guerrerosZ);
		int ki = 40;
		int kiEsperado = ki - KI_GOKU_PRIMERA_TRANF;
		goku.aumentarKi(ki);
		goku.transformar();
		
		assertEquals(goku.getKiCantidad(), kiEsperado);
	}
	
	@Test
	public void transformarseLuegoDeMoverseSinAlcarzarElLimiteDeMovimientosAumentaLaCantidadDeMovimientosPosibles(){
		Personaje goku = new Goku();
		Equipo guerrerosZ = new Equipo("z");
		goku.setEquipo(guerrerosZ);
		goku.aumentarKi(40);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(goku, posicionInicial);
		guerrerosZ.moverDerecha(goku);
		goku.transformar();
		guerrerosZ.moverDerecha(goku);
		/*aqui se abrian limitado los movimientos sin la transformacion*/
		guerrerosZ.moverDerecha(goku);
		Posicion posicionFinal = new Posicion(2,5);
		assertEquals(goku.getPosicion(),posicionFinal);
	}
	
	@Test
	public void transformarseLuegoDeMoverseConAlcarzarElLimiteDeMovimientosAumentLaCantidadDeMovimientosPosibles(){
		
		Personaje goku = new Goku();
		Equipo guerrerosZ = new Equipo("z");
		goku.setEquipo(guerrerosZ);
		goku.aumentarKi(40);
		
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(goku, posicionInicial);
		guerrerosZ.moverDerecha(goku);
		guerrerosZ.moverDerecha(goku);
		goku.transformar();
		guerrerosZ.moverDerecha(goku);
		Posicion posicionFinal = new Posicion(2,5);
		assertEquals(goku.getPosicion(),posicionFinal);
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
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
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
		
		Equipo agrupacion1 = new Equipo("buenos");
		Equipo agrupacion2 = new Equipo("malos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion2.agregarPersonaje(cell);
		
		int saludEsperada = PUNTOS_VIDA_CELL - PODER_GOHAN_NORMAL + PODER_GOHAN_NORMAL * REDUCCION_DE_ATAQUE /100;
		
		gohan.realizarAtaqueBasico(cell);
		assertEquals(cell.getSalud(), saludEsperada);
		
	}
	
	
	@Test
	public void noSePuedeMoverPersonajeMasVecesQueSuVelocidadActual(){
		Personaje piccolo = new Piccolo();
		Equipo guerrerosZ = new Equipo("Guerreros Z");
		piccolo.setEquipo(guerrerosZ);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(piccolo, posicionInicial);
		guerrerosZ.moverDerecha(piccolo);
		guerrerosZ.moverDerecha(piccolo);
		Posicion posAnt = piccolo.getPosicion();
		/* se alcanza limite de movimientos*/
		guerrerosZ.moverDerecha(piccolo);
		assertEquals(piccolo.getPosicion(), posAnt);
	}
	
	@Test 
	public void noSePuedeMoverPersonajeLuegoDeMoverAOtroEnEsteTurno(){
		Personaje majinBoo = new MajinBoo();
		Personaje cell = new Cell();
		Equipo enemigos = new Equipo("enemigos");
		majinBoo.setEquipo(enemigos);
		Tablero tablero = new Tablero(10);
		Posicion posicionInicialM = new Posicion(2,2);
		Posicion posicionInicialC = new Posicion(3,2);
		tablero.agregarPersonaje(majinBoo, posicionInicialM);
		tablero.agregarPersonaje(cell, posicionInicialC);
		enemigos.moverDerecha(majinBoo);
		Posicion pos = cell.getPosicion();
		enemigos.moverDerecha(cell);
		assertEquals(cell.getPosicion(),pos);
	}
	
	@Test
	public void moverPersonajeVerificarPosicion()
	{
		
		Tablero tablero = new Tablero(10);
		Equipo guerrerosZ = new Equipo("GuerrerosZ");
		Personaje goku = new Goku();
		goku.setEquipo(guerrerosZ);
		Posicion posicionInicial = new Posicion(2,2);
		tablero.agregarPersonaje(goku, posicionInicial);
		guerrerosZ.moverDerecha(goku);
		Posicion posicionFinal = new Posicion(2,3);
		assertEquals(goku.getPosicion(), posicionFinal);
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiHayOtroPersonajeEnElLugarAlQueNosQueremosMover()
	{
		Tablero tablero = new Tablero(10);
		Equipo guerrerosZ = new Equipo("GuerrerosZ");
		Personaje goku = new Goku();
		goku.setEquipo(guerrerosZ);
		Personaje piccolo = new Piccolo();
		
		Posicion posicionInicialX = new Posicion(2,2);
		Posicion posicionInicialY = new Posicion(3,2);
		
		tablero.agregarPersonaje(goku, posicionInicialX);
		tablero.agregarPersonaje(piccolo, posicionInicialY);
		
		guerrerosZ.moverAbajo(goku);
		assertEquals(goku.getPosicion(), posicionInicialX);
		/*es decir, el movimiento no se realizo*/
		
	}
	
	@Test
	public void moverPersonajeNoFuncionaSiElLugarAlQueNosQueremosMoverSeEncuentraFueraDelTablero()
	{
		Tablero tablero = new Tablero(10);
		Personaje piccolo = new Piccolo();
		Equipo guerrerosZ = new Equipo("GuerrerosZ");
		piccolo.setEquipo(guerrerosZ);
		
		Posicion posicionInicialX = new Posicion(9,2);
		
		tablero.agregarPersonaje(piccolo, posicionInicialX);
		
		guerrerosZ.moverAbajo(piccolo);
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
		
		Equipo agrupacion1 = new Equipo("buenos");
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
