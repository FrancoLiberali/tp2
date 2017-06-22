package model.personajes.freezer;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_NORMAL;
import static model.algoBall.ConstantesDelJuego.KI_FREEZER_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_FREEZER_NORMAL;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_NORMAL;

import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoFreezerNormal extends EstadoTransformacion {
	
	public EstadoFreezerNormal(){
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_FREEZER_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_NORMAL;
		this.poderDePelea = new Danio(PODER_FREEZER_NORMAL);
		this.siguienteEstado = new EstadoFreezerSegundaForma();
		this.kiParaTransformacion = new Ki(KI_FREEZER_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vista/imagenes/freezerNormal.png";
	}

}
