package algoBallUnitTest;

import static model.algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.algoBall.Equipo;
import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Gohan;
import model.personajes.Personaje;
import model.personajes.Piccolo;
import model.personajes.elementos.Danio;
import model.personajes.elementos.Ki;

public class PiccoloUnitTest {

	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void piccoloSePuedeTransformarSoloUnaVezSiGohanEstaEnLaAgrupacionConMasDe20PorcientoDeVida()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(new Ki(20));
		
		Personaje gohan = new Gohan();
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		piccolo.transformar();
		assertEquals(piccolo.getEstado().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		piccolo.transformar();
		
	}
	
	@Test
	public void piccoloSePuedeTransformarAPrimeraTransSiGohanNoEstaEnLaAgrupacion()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(new Ki(20));		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		piccolo.transformar();
		assertEquals(piccolo.getEstado().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		
	}
	
	@Test
	public void piccoloSePuedeTransformarDosVecesSiGohanEstaEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(new Ki(20));
		
		Personaje gohan = new Gohan();
		gohan.recibirDanio(new Danio(250));
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		piccolo.transformar();
		assertEquals(piccolo.getEstado().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		piccolo.transformar();
		assertEquals(piccolo.getEstado().getNombre(), NOMBRE_PICCOLO_SEGUNDA_TRANSF);
	}
}
