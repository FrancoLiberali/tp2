package funcionamientoPersonaje;

import static algoBall.ConstantesDelJuego.*;

public class Cell extends Personaje 
{	
	
	public Cell()
	{
		this.nombre = CELL_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_CELL);
		this.estadoTransformacionActual = setEstadoNormal();
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_CELL, KI_ATQ_ESPECIAL_CELL);
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_CELL_NORMAL;
		int distancia = DISTANCIA_CELL_NORMAL;
		int poder = PODER_CELL_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_CELL_PRIMERA_TRANF);

		return normal;
	}
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_CELL_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_CELL_PRIMERA_TRANSF;
		int distancia = DISTANCIA_CELL_PRIMERA_TRANSF;
		int poder = PODER_CELL_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_CELL_SEGUNDA_TRANF);

		return primeraTranf;
	}
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_CELL_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_CELL_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_CELL_SEGUNDA_TRANSF;
		int poder = PODER_CELL_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}