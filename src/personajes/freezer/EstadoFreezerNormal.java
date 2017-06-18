package personajes.freezer;

import static algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_NORMAL;
import static algoBall.ConstantesDelJuego.KI_FREEZER_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_FREEZER_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_NORMAL;

import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoFreezerNormal extends EstadoTransformacion {
	
	public EstadoFreezerNormal(){
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_FREEZER_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_NORMAL;
		this.poderDePelea = PODER_FREEZER_NORMAL;
		this.siguienteEstado = new EstadoFreezerSegundaForma();
		this.kiParaTransformacion = new Ki(KI_FREEZER_PRIMERA_TRANF);
	}

}
