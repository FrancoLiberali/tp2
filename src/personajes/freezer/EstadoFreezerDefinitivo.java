package personajes.freezer;

import static algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_FREEZER_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_SEGUNDA_TRANSF;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoFreezerDefinitivo extends EstadoTransformacion {
	
	public EstadoFreezerDefinitivo() {
		this.nombre = NOMBRE_FREEZER_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_FREEZER_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_SEGUNDA_TRANSF;
		this.poderDePelea = PODER_FREEZER_SEGUNDA_TRANSF;
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vista/imagenes/freezerFinal.png";
	}

	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
}
