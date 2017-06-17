package personajes;

import static algoBall.ConstantesDelJuego.GOKU_NOMBRE;
import static algoBall.ConstantesDelJuego.KI_ATQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.KI_INICIAL;
import static algoBall.ConstantesDelJuego.NOMBRE_ATQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.PORCENTAJE_AUMENTO_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.PROCENTAJE_DANIO_ATAQ_ESPECIAL_GOKU;
import static algoBall.ConstantesDelJuego.PUNTOS_VIDA_GOKU;

import personajes.elementos.AtaqueEspecial;
import personajes.elementos.Ki;
import personajes.elementos.Salud;
import personajes.goku.EstadoGokuNormal;

public class Goku extends Personaje 
{	
	
	public Goku()
	{
		this.nombre = GOKU_NOMBRE;
		this.ki = new Ki(KI_INICIAL);
		this.salud = new Salud(PUNTOS_VIDA_GOKU);
		this.ataqueEspecial = new AtaqueEspecial(NOMBRE_ATQ_ESPECIAL_GOKU, KI_ATQ_ESPECIAL_GOKU);
		this.estadoTransformacionActual = new EstadoGokuNormal();
		this.rutaImagen = "file:src/vista/imagenes/goku.png";
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
