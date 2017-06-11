package funcionamientoPersonaje;

import static algoBall.ConstantesDelJuego.*;

public class Piccolo extends Personaje 
{	
	
	public Piccolo()
	{
		this.nombre = PICCOLO_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_PICCOLO);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_PICCOLO, KI_ATQ_ESPECIAL_PICCOLO);
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
	}
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_PICCOLO_NORMAL;
		int distancia = DISTANCIA_PICCOLO_NORMAL;
		int poder = PODER_PICCOLO_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_PICCOLO_PRIMERA_TRANF);

		return normal;
	}
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_PICCOLO_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
		int distancia = DISTANCIA_PICCOLO_PRIMERA_TRANSF;
		int poder = PODER_PICCOLO_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_PICCOLO_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_PICCOLO_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
		int poder = PODER_PICCOLO_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}