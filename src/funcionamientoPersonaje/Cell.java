package funcionamientoPersonaje;

import algoBall.ConstantesDelJuego;

public class Cell extends Personaje 
{	
	
	public Cell()
	{
		this.nombre = "Cell";
		this.ki = new Ki(ConstantesDelJuego.KI_INICIAL);
		this.salud = new Salud(ConstantesDelJuego.PUNTOS_VIDA_CELL);
		this.estadoTransformacionActual = setEstadoNormal();
		// falta agegar la agrupacion.
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
		int velocidad = ConstantesDelJuego.VELOCIDAD_CELL_NORMAL;
		int distancia = ConstantesDelJuego.DISTANCIA_CELL_NORMAL;
		int poder = ConstantesDelJuego.PODER_CELL_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_CELL_PRIMERA_TRANF);

		return normal;
	}
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_CELL_PRIMERA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_CELL_PRIMERA_TRANSF;
		int poder = ConstantesDelJuego.PODER_CELL_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, ConstantesDelJuego.KI_CELL_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = ConstantesDelJuego.NOMBRE_CELL_SEGUNDA_TRANSF;
		int velocidad = ConstantesDelJuego.VELOCIDAD_CELL_SEGUNDA_TRANSF;
		int distancia = ConstantesDelJuego.DISTANCIA_CELL_SEGUNDA_TRANSF;
		int poder = ConstantesDelJuego.PODER_CELL_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}