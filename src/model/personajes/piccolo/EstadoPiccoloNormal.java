package model.personajes.piccolo;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_NORMAL;
import static model.algoBall.ConstantesDelJuego.KI_PICCOLO_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_PICCOLO_NORMAL;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_NORMAL;

import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoPiccoloNormal extends EstadoTransformacion {
	
	public EstadoPiccoloNormal()
	{
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_PICCOLO_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_NORMAL;
		this.poderDePelea = new Danio(PODER_PICCOLO_NORMAL);
		this.siguienteEstado = new EstadoPiccoloFortalecido();
		this.kiParaTransformacion = new Ki(KI_PICCOLO_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vistas/imagenes/piccoloNormal.png";
	}
}
