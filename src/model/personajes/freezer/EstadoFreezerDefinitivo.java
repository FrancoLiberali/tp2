package model.personajes.freezer;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_FREEZER_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_FREEZER_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_SEGUNDA_TRANSF;

import model.exceptions.YaNoPuedeEvolucionarException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoFreezerDefinitivo extends EstadoTransformacion {
	
	public EstadoFreezerDefinitivo() {
		this.nombre = NOMBRE_FREEZER_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_FREEZER_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_SEGUNDA_TRANSF;
		this.poderDePelea = new Danio(PODER_FREEZER_SEGUNDA_TRANSF);
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vista/imagenes/freezerFinal.png";
	}

	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
}
