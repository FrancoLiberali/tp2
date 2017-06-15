package funcionamientoPersonaje.personajes;

import static algoBall.ConstantesDelJuego.*;

import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.elementos.Ki;
import funcionamientoPersonaje.elementos.Salud;

public class Freezer extends Personaje 
{	
	
	public Freezer()
	{
		this.nombre = FREEZER_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_FREEZER);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_FREEZER, KI_ATQ_ESPECIAL_FREEZER);
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_FREEZER);
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_FREEZER_NORMAL;
		int distancia = DISTANCIA_FREEZER_NORMAL;
		int poder = PODER_FREEZER_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_FREEZER_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_FREEZER_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_FREEZER_PRIMERA_TRANSF;
		int distancia = DISTANCIA_FREEZER_PRIMERA_TRANSF;
		int poder = PODER_FREEZER_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_FREEZER_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_FREEZER_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_FREEZER_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_FREEZER_SEGUNDA_TRANSF;
		int poder = PODER_FREEZER_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}