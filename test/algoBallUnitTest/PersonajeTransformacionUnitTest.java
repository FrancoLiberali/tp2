package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOKU_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.KI_GOKU_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_GOKU_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_PRIMERA_TRANSF;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.KiInsuficienteException;
import model.personajes.Goku;
import model.personajes.Personaje;
import model.personajes.elementos.EstadoActividad;
import model.personajes.elementos.Ki;
import model.tablero.Posicion;
import model.tablero.Tablero;

public class PersonajeTransformacionUnitTest {
	
	@Test(expected = KiInsuficienteException.class)
	public void transformarConInsuficienteKiLanzaKiInsuficiente(){
		Personaje goku = new Goku();
		//ki nescesario = 20;
		goku.aumentarKi(new Ki(10));
		goku.transformar();
	}

	@Test
	public void transformarFuncionaSiHaySiguienteEstadoYKiSuficienteVerificarAtributos(){
		Personaje goku = new Goku();
		goku.aumentarKi(new Ki(40));
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
		goku.aumentarKi(new Ki(ki));
		goku.transformar();
		
		assertEquals(goku.getKiCantidad(), kiEsperado);
	}
	
	@Test
	public void transformarseLuegoDeMoverseSinAlcarzarElLimiteDeMovimientosAumentaLaCantidadDeMovimientosPosibles(){
		Personaje goku = new Goku();
		Equipo guerrerosZ = new Equipo("z");
		goku.setEquipo(guerrerosZ);
		goku.aumentarKi(new Ki(40));
		
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
		goku.aumentarKi(new Ki(40));
		
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
