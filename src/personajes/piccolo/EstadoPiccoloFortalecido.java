package personajes.piccolo;

import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_PRIMERA_TRANSF;

import personajes.elementos.EstadoTransformacion;

public class EstadoPiccoloFortalecido extends EstadoTransformacion {
	
	public EstadoPiccoloFortalecido()
	{
		this.nombre = NOMBRE_PICCOLO_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_PICCOLO_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_PRIMERA_TRANSF;
		this.poderDePelea = PODER_PICCOLO_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoPiccoloProtector();
	}
	
}
