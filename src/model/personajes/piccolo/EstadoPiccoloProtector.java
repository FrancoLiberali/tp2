package model.personajes.piccolo;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_PICCOLO_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_PICCOLO_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;

import model.exceptions.YaNoPuedeEvolucionarException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoPiccoloProtector extends EstadoTransformacion {
	
	public EstadoPiccoloProtector()
	{
		this.nombre = NOMBRE_PICCOLO_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_PICCOLO_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_PICCOLO_SEGUNDA_TRANSF;
		this.poderDePelea = new Danio(PODER_PICCOLO_SEGUNDA_TRANSF);
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vistas/imagenes/piccoloProtector.png";
	}
	
	@Override
	public void transformar(Personaje personaje,Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}

}
