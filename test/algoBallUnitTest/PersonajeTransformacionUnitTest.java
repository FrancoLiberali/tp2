package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.KI_GOKU_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_PRIMERA_TRANSF;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Equipo;
import exceptions.KiInsuficienteException;
import personajes.Goku;
import personajes.Personaje;
import personajes.elementos.EstadoActividad;
import tablero.Posicion;
import tablero.Tablero;

public class PersonajeTransformacionUnitTest {
	
	@Test(expected = KiInsuficienteException.class)
	public void transformarConInsuficienteKiLanzaKiInsuficiente(){
		Personaje goku = new Goku();
		//ki nescesario = 20;
		goku.aumentarKi(10);
		goku.transformar();
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
		tablero.agregarPosicionable(goku, posicionInicial);
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
		tablero.agregarPosicionable(goku, posicionInicial);
		guerrerosZ.moverDerecha(goku);
		guerrerosZ.moverDerecha(goku);
		goku.transformar();
		guerrerosZ.moverDerecha(goku);
		Posicion posicionFinal = new Posicion(2,5);
		assertEquals(goku.getPosicion(),posicionFinal);
	}
}
