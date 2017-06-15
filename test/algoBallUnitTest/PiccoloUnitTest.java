package algoBallUnitTest;

import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOHAN;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algoBall.Agrupacion;
import exceptions.NoCumpleCondicionesDeTransformacionException;
import funcionamientoPersonaje.personajes.Gohan;
import funcionamientoPersonaje.personajes.Personaje;
import funcionamientoPersonaje.personajes.Piccolo;

public class PiccoloUnitTest {

	@Test (expected = NoCumpleCondicionesDeTransformacionException.class)
	public void piccoloSePuedeTransformarSoloUnaVezSiGohanEstaEnLaAgrupacionConMasDe20PorcientoDeVida()
	{
		Personaje piccolo = new Piccolo();
		piccolo.aumentarKi(20);
		
		Personaje gohan = new Gohan();
		
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
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
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
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
		
		
		Agrupacion agrupacion1 = new Agrupacion("buenos");
		agrupacion1.agregarPersonaje(piccolo);
		agrupacion1.agregarPersonaje(gohan);
		piccolo.transformar();
		assertEquals(piccolo.getEstadoActividad().getNombre(), NOMBRE_PICCOLO_PRIMERA_TRANSF);
		piccolo.transformar();
		assertEquals(piccolo.getEstadoActividad().getNombre(), NOMBRE_PICCOLO_SEGUNDA_TRANSF);
	}
}
