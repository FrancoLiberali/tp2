package personajes.freezer;

import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

import static algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_SEGUNDA_TRANSF;

import exceptions.YaNoPuedeEvolucionarException;

public class EstadoFreezerDefinitivo extends EstadoTransformacion {
	
	public EstadoFreezerDefinitivo() {
		this.nombre = NOMBRE_FREEZER_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_FREEZER_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_SEGUNDA_TRANSF;
		this.poderDePelea = PODER_FREEZER_SEGUNDA_TRANSF;
		this.siguienteEstado = null;
	}

	@Override
	public void transformar(Personaje personaje) {
		throw new YaNoPuedeEvolucionarException();
	}
}
