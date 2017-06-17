package personajes.goku;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOKU_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOKU_PRIMERA_TRANSF;

import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGokuKaioKen extends EstadoTransformacion {


	public EstadoGokuKaioKen()
	{
		this.nombre = NOMBRE_GOKU_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_GOKU_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOKU_PRIMERA_TRANSF;
		this.poderDePelea = PODER_GOKU_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoGokuSuperSayajin();	
	}
	
	@Override
	public void actualizarEstado(Personaje goku)
	{
		if(goku.getPorcentajeSalud() < PORCENTAJE_TOPE_VIDA_PARA_MAYOR_DANIO_GOKU){
			goku.setEstado(new EstadoGokuBuffDanio(goku.getEstado()));
		}
	}
}
