package funcionamientoPersonaje;

import static algoBall.ConstantesDelJuego.*;

public class Gohan extends Personaje 
{	
	
	public Gohan()
	{
		this.nombre = GOHAN_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOHAN);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOHAN, KI_ATQ_ESPECIAL_GOHAN);
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_GOHAN_NORMAL;
		int distancia = DISTANCIA_GOHAN_NORMAL;
		int poder = PODER_GOHAN_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_GOHAN_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() {
		String nombre = NOMBRE_GOHAN_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_GOHAN_PRIMERA_TRANSF;
		int distancia = DISTANCIA_GOHAN_PRIMERA_TRANSF;
		int poder = PODER_GOHAN_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_SEGUNDA_TRANF_GOHAN);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion() {
		String nombre = NOMBRE_GOHAN_SEGUNDA_TRANSF;
		int velocidad = VELOCIDAD_GOHAN_SEGUNDA_TRANSF;
		int distancia = DISTANCIA_GOHAN_SEGUNDA_TRANSF;
		int poder = PODER_GOHAN_SEGUNDA_TRANSF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
}