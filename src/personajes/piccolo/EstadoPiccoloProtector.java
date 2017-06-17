package personajes.piccolo;

import static algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_PICCOLO_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

public class EstadoPiccoloProtector extends EstadoTransformacion {
	
	public EstadoPiccoloProtector()
	{
		this.nombre = NOMBRE_PICCOLO_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
		this.poderDePelea = PODER_PICCOLO_SEGUNDA_TRANSF;
		this.siguienteEstado = null;
	}
	
	@Override
	public void transformar(Personaje personaje) {
		throw new YaNoPuedeEvolucionarException();
	}

}
