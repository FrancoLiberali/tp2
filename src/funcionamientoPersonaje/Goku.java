package funcionamientoPersonaje;

import algoBall.ConstantesDelJuego;

public class Goku extends Personaje 
{	
	
	public Goku()
	{
		this.nombre = "Goku";
		this.ki = new Ki(ConstantesDelJuego.KI_INICIAL);
		this.salud = new Salud(ConstantesDelJuego.PUNTOS_VIDA_GOKU);
		this.estadoTransformacionActual = setEstadoNormal();
		// falta agegar la agrupacion.
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
		int velocidad = ConstantesDelJuego.VELOCIDAD_GOKU_NORMAL;
		int distancia = ConstantesDelJuego.DISTANCIA_GOKU_NORMAL;
		int poder = ConstantesDelJuego.PODER_GOKU_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_GOKU_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_GOKU_PRIMERA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_GOKU_PRIMERA_TRANSF;
		int poder = ConstantesDelJuego.PODER_GOKU_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_SEGUNDA_TRANF_GOKU);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_GOKU_SEGUNDA_TRANF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_GOKU_SEGUNDA_TRANF;
		int distancia = ConstantesDelJuego.DISTANCIA_GOKU_SEGUNDA_TRANF;
		int poder = ConstantesDelJuego.PODER_GOKU_SEGUNDA_TRANF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}
