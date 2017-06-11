package funcionamientoPersonaje;

import algoBall.ConstantesDelJuego;

public class Piccolo extends Personaje 
{	
	
	public Piccolo()
	{
		this.nombre = "Piccolo";
		this.ki = new Ki(ConstantesDelJuego.KI_INICIAL);
		this.salud = new Salud(ConstantesDelJuego.PUNTOS_VIDA_PICCOLO);
		this.estadoTransformacionActual = setEstadoNormal();
		// falta agegar la agrupacion.
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
		int velocidad = ConstantesDelJuego.VELOCIDAD_PICCOLO_NORMAL;
		int distancia = ConstantesDelJuego.DISTANCIA_PICCOLO_NORMAL;
		int poder = ConstantesDelJuego.PODER_PICCOLO_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_PICCOLO_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_PICCOLO_PRIMERA_TRANSF;
		int poder = ConstantesDelJuego.PODER_PICCOLO_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_PICCOLO_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
		int poder = ConstantesDelJuego.PODER_PICCOLO_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}