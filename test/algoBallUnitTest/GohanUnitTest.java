package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.Personaje;
import model.personajes.Piccolo;
import model.personajes.elementos.Danio;
import model.personajes.elementos.Ki;

public class GohanUnitTest {

	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void gohanSePuedeTransformarSoloUnaVezSiGokuYPiccoloEstanEnLaAgrupacionCon100PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(new Ki(10));
		
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
	
	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void gohanSePuedeTransformarSoloUnaVezSiGokuOPiccoloEstanEnLaAgrupacionCon100PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(new Ki(10));
		
		Personaje goku = new Goku();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
	}
	
	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void gohanSePuedeTransformarSoloUnaVezSiGokuOPiccoloEstanEnLaAgrupacionConMasDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(new Ki(10));
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		goku.recibirDanio(new Danio(40));
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiGokuYPiccoloEstanEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(new Ki(40));
		
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
		
		goku.recibirDanio(new Danio(480));	//salud Goku 500.
		piccolo.recibirDanio(new Danio(480)); //salud piccolo 500
		
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
	
	@Test
	public void gohanSePuedeTransformarDosVecesSiSoloSusCompanierosEstanConMenosDe20PorcientoDeSalud()
	{
		Personaje gohan = new Gohan();
		gohan.aumentarKi(new Ki(40));
		
		Personaje goku = new Goku();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(gohan);
		agrupacion1.agregarPersonaje(goku);
	
		goku.recibirDanio(new Danio(480));
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_PRIMERA_TRANSF);
		gohan.transformar();
		assertEquals(gohan.getEstado().getNombre(), NOMBRE_GOHAN_SEGUNDA_TRANSF);
	}
	
	
}
