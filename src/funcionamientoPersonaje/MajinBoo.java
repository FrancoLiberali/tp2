package funcionamientoPersonaje;

import algoBall.ConstantesDelJuego;

public class MajinBoo extends Personaje 
{	
	
	public MajinBoo()
	{
		this.nombre = "MAJIN_BOO";
		this.ki = new Ki(ConstantesDelJuego.KI_INICIAL);
		this.salud = new Salud(ConstantesDelJuego.PUNTOS_VIDA_MAJIN_BOO);
		this.estadoTransformacionActual = setEstadoNormal();
		// falta agegar la agrupacion.
	}
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
		int velocidad = ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_NORMAL;
		int distancia = ConstantesDelJuego.DISTANCIA_MAJIN_BOO_NORMAL;
		int poder = ConstantesDelJuego.PODER_MAJIN_BOO_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_MAJIN_BOO_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_MAJIN_BOO_PRIMERA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_PRIMERA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_MAJIN_BOO_PRIMERA_TRANSF;
		int poder = ConstantesDelJuego.PODER_MAJIN_BOO_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_MAJIN_BOO_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_MAJIN_BOO_SEGUNDA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_MAJIN_BOO_SEGUNDA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_MAJIN_BOO_SEGUNDA_TRANSF;
		int poder = ConstantesDelJuego.PODER_MAJIN_BOO_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}