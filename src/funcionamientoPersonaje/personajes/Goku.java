package funcionamientoPersonaje.personajes;

import static algoBall.ConstantesDelJuego.*;

import funcionamientoPersonaje.elementos.AtaqueEspecial;
import funcionamientoPersonaje.elementos.EstadoTransformacion;
import funcionamientoPersonaje.elementos.Ki;
import funcionamientoPersonaje.elementos.Salud;
import funcionamientoTablero.Posicion;

public class Goku extends Personaje 
{	
	
	public Goku()
	{
		this.nombre = GOKU_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOKU);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOKU, KI_ATQ_ESPECIAL_GOKU);
		this.ataqueEspecial.setPorcentaje(PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU);
		this.estadoTransformacionActual = setEstadoNormal();
		this.movimientosRestantes = estadoTransformacionActual.getVelocidad();
		
	}
	
	
	@Override
	public EstadoTransformacion setEstadoNormal()
	{
		String nombre = NOMBRE_TRANF_NORMAL;
		int velocidad = VELOCIDAD_GOKU_NORMAL;
		int distancia = DISTANCIA_GOKU_NORMAL;
		int poder = PODER_GOKU_NORMAL;
		EstadoTransformacion normal = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setPrimerEstadoTransformacion();
		normal.setSiguienteEstado(siguiente, KI_GOKU_PRIMERA_TRANF);

		return normal;
	}
	
	
	@Override 
	public EstadoTransformacion setPrimerEstadoTransformacion() 
	{
		String nombre = NOMBRE_GOKU_PRIMERA_TRANSF;
		int velocidad = VELOCIDAD_GOKU_PRIMERA_TRANSF;
		int distancia = DISTANCIA_GOKU_PRIMERA_TRANSF;
		int poder = PODER_GOKU_PRIMERA_TRANSF;
		EstadoTransformacion primeraTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);
		
		EstadoTransformacion siguiente = setSegundoEstadoTransformacion();
		primeraTranf.setSiguienteEstado(siguiente, KI_SEGUNDA_TRANF_GOKU);

		return primeraTranf;
	}
	
	
	@Override 
	public EstadoTransformacion setSegundoEstadoTransformacion()
	{
		String nombre = NOMBRE_GOKU_SEGUNDA_TRANF;
		int velocidad = VELOCIDAD_GOKU_SEGUNDA_TRANF;
		int distancia = DISTANCIA_GOKU_SEGUNDA_TRANF;
		int poder = PODER_GOKU_SEGUNDA_TRANF;
		EstadoTransformacion segundaTranf = new EstadoTransformacion(nombre, poder, distancia, velocidad);

		return segundaTranf;
	}
	
	private int bonusPorcentajeGoku()
	{
		int porcentajeExtra = 0;
		
		
		if (this.getPorcentajeSalud()< PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU )
		{
			porcentajeExtra = PORCENTAJE_AUMENTO_DANIO_GOKU;
		}
		return porcentajeExtra;
	}
	
	@Override
	public void realizarAtaqueBasico(Personaje victima)
	{
		this.verificarAtaque(victima);
		this.estadoTransformacionActual.realizarAtaqueEspecial(victima, this.bonusPorcentajeGoku());
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima)
	{
		this.verificarAtaque(victima);
		this.agrupacion.restarAtaqueRestates();
		float bonusPorPocaVida = this.bonusPorcentajeGoku();
		float bonusAtaqueEspecial = this.ataqueEspecial.getPorcentaje(this.ki);
		int bonusTotal = (int) sumarPorcentajes(bonusAtaqueEspecial, bonusPorPocaVida );
		this.estadoTransformacionActual.realizarAtaqueEspecial(victima,bonusTotal);
	}


	private float sumarPorcentajes(float porcentaje, float bonusPorcentajeGoku) {
		if (bonusPorcentajeGoku == 0){
			return (int) porcentaje;
		}
		else{
			float suma = ((porcentaje/100 + 1) * (bonusPorcentajeGoku/100 + 1) - 1);
			return suma*100;
		}
		
	}
}
