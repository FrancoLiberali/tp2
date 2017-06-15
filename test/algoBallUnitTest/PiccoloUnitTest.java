package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOHAN;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Equipo;
import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Gohan;
import personajes.Personaje;
import personajes.Piccolo;

public class PiccoloUnitTest {

	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void piccoloSePuedeTransformarSoloUnaVezSiGohanEstaEnLaAgrupacionConMasDe20PorcientoDeVida()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(20);
		
		Personaje gohan = new Gohan();
		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		piccolo.transformar();
		assertEquals(piccolo.getEstadoActividad().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		piccolo.transformar();
		
	}
	
	@Test
	public void piccoloSePuedeTransformarAPrimeraTransSiGohanNoEstaEnLaAgrupacion()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(20);		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		piccolo.transformar();
		assertEquals(piccolo.getEstadoActividad().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		
	}
	
	@Test
	public void piccoloSePuedeTransformarDosVecesSiGohanEstaEnLaAgrupacionConMenosDe20PorcientoDeVida()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(20);
		
		Personaje gohan = new Gohan();
		gohan.recibirDanio( (int) (PUNTOS_VIDA_GOHAN * 81 / 100), 40);//poder de pelea 40 asi no hay reduccion de ataque
		
		
		Equipo agrupacion1 = new Equipo("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		piccolo.transformar();
		assertEquals(piccolo.getEstadoActividad().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		piccolo.transformar();
		assertEquals(piccolo.getEstadoActividad().getNombre(), NOMBRE_PICCOLO_SEGUNDA_TRANSF);
	}
}
