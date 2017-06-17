package personajes.goku;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.KI_GOKU_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_GOKU_NORMAL;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_NORMAL;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGokuNormal extends EstadoTransformacion {
	
	public EstadoGokuNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_GOKU_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_GOKU_NORMAL;
		this.poderDePelea = PODER_GOKU_NORMAL;
		this.siguienteEstado = new EstadoGokuKaioKen();
		this.kiParaTransformacion = new Ki(KI_GOKU_PRIMERA_TRANF);
	}
		
	@Override
	public void actualizarEstado(Personaje goku)
	{
		if(goku.getPorcentajeSalud() < PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU){
			goku.setEstado(new EstadoGokuBuffDanio(goku.getEstado()));
		}
	}

}
