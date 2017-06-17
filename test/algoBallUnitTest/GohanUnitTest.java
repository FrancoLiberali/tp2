package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_PICCOLO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Equipo;
import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Gohan;
import personajes.Goku;
import personajes.Personaje;
import personajes.Piccolo;

public class GohanUnitTest {

	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void gohanSePuedeTransformarSoloUnaVezSiGokuYPiccoloEstanEnLaAgrupacionCon100PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(10);
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		
	}
	
	@Test
	public void gohanSePuedeTransformarSoloUnaVezSiGokuOPiccoloEstanEnLaAgrupacionCon100PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(10);
		
		Personaje goku = new Goku();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarSoloUnaVezSiGokuOPiccoloEstanEnLaAgrupacionConMasDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(10);
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiGokuYPiccoloEstanEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(40);
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		piccolo.recibirDanio( (int) (PUNTOS_VIDA_PICCOLO * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiSoloGokuOPiccoloEstanEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(40);
		
		Personaje goku = new Goku();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio( (int) (PUNTOS_VIDA_GOKU * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
	
	
}
