package funcionamientoPersonaje;

import algoBall.ConstantesDelJuego;

public class Gohan extends Personaje 
{	
	
	public Gohan()
	{
		this.nombre = "GOHAN";
		this.ki = new Ki(ConstantesDelJuego.KI_INICIAL);
		this.salud = new Salud(ConstantesDelJuego.PUNTOS_VIDA_GOHAN);
		this.estadoTransformacionActual = setEstadoNormal();
		// falta agegar la agrupacion.
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
		int velocidad = ConstantesDelJuego.VELOCIDAD_GOHAN_NORMAL;
		int distancia = ConstantesDelJuego.DISTANCIA_GOHAN_NORMAL;
		int poder = ConstantesDelJuego.PODER_GOHAN_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_GOHAN_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_GOHAN_PRIMERA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_GOHAN_PRIMERA_TRANSF;
		int poder = ConstantesDelJuego.PODER_GOHAN_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_SEGUNDA_TRANF_GOHAN);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_GOHAN_SEGUNDA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_GOHAN_SEGUNDA_TRANSF;
		int poder = ConstantesDelJuego.PODER_GOHAN_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}