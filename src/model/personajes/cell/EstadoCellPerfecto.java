package model.personajes.cell;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_CELL_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_CELL_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_CELL_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_CELL_SEGUNDA_TRANSF;

import model.exceptions.YaNoPuedeEvolucionarException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoCellPerfecto extends EstadoTransformacion{
	
	public EstadoCellPerfecto(){
		this.nombre = NOMBRE_CELL_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_CELL_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_CELL_SEGUNDA_TRANSF;
		this.poderDePelea = new Danio(PODER_CELL_SEGUNDA_TRANSF);
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vista/imagenes/cellPerfecto.png";
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
	
}
