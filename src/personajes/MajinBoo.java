package personajes;

import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_MAJIN_BOO;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.KI_MAJIN_BOO_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.KI_MAJIN_BOO_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.MAJIN_BOO_NOMBRE;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_MAJIN_BOO;
import static algoBall.ConstantesDelJuego.NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_MAJIN_BOO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;

import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.elementos.Ki;
import funcionamientoPersonaje.elementos.Salud;

public class MajinBoo extends Personaje 
{	
	
	public MajinBoo()
	{
		this.nombre = MAJIN_BOO_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_MAJIN_BOO);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_MAJIN_BOO, KI_ATQ_ESPECIAL_MAJIN_BOO);
		this.estadoTransformacionActual = setEstadoNormal();
	}
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_MAJIN_BOO_NORMAL;
		int distancia = DISTANCIA_MAJIN_BOO_NORMAL;
		int poder = PODER_MAJIN_BOO_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_MAJIN_BOO_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;
		int distancia = DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
		int poder = PODER_MAJIN_BOO_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_MAJIN_BOO_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
		int poder = PODER_MAJIN_BOO_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima)
	{	
		this.equipo.restarAtaqueRestates();
		victima.convertirAChocolate();
		this.ki.restar( new Ki(KI_ATQ_ESPECIAL_MAJIN_BOO));
		
		
	}
}