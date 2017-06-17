package personajes.goku;

import static algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.GOKU_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.KI_GOKU_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.KI_SEGUNDA_TRANF_GOKU;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.NOMBRE_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOKU_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOKU_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_AUMENTO_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;
import static algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_SEGUNDA_TRANF;

import personajes.Personaje;
import personajes.elementos.AtaqueEspecial;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;
import personajes.elementos.Salud;

public class EstadoGokuNormal extends EstadoTransformacion {
	
	public EstadoGokuNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_GOKU_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_GOKU_NORMAL;
		this.poderDePelea = PODER_GOKU_NORMAL;
		this.siguienteEstado = new EstadoGokuKaioKen();
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
		this.equipo.restarAtaqueRestates();
		this.estadoTransformacionActual.realizarAtaqueEspecial(victima, this.bonusPorcentajeGoku());
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje victima)
	{
		this.verificarAtaque(victima);
		this.equipo.restarAtaqueRestates();
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
