package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_PICCOLO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Agrupacion;
import funcionamientoPersonaje.Gohan;
import funcionamientoPersonaje.Goku;
import funcionamientoPersonaje.Personaje;
import funcionamientoPersonaje.Piccolo;

public class GohanUnitTest {

	@Test
	public void gohanSePuedeTransformarSoloUnaVezSiGokuYPiccoloEstanEnLaAgrupacionCon100PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(10);
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarSoloUnaVezSiGokuOPiccoloEstanEnLaAgrupacionCon100PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(10);
		
		Personaje goku = new Goku();
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarSoloUnaVezSiGokuOPiccoloEstanEnLaAgrupacionConMasDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(10);
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiGokuYPiccoloEstanEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(40);
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		piccolo.recibirDanio( (int) (PUNTOS_VIDA_PICCOLO * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiSoloGokuOPiccoloEstanEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(40);
		
		Personaje goku = new Goku();
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiNiGokuNiPiccoloEstanEnLaAgrupacion()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(40);		
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(gohan);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstadoTransformacion().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
}
