package personajes.cell;

import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_CELL_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_CELL_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_SEGUNDA_TRANSF;

import exceptions.YaNoPuedeEvolucionarException;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

public class EstadoCellPerfecto extends EstadoTransformacion{
	
	public EstadoCellPerfecto(){
		this.nombre = NOMBRE_CELL_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_CELL_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_CELL_SEGUNDA_TRANSF;
		this.poderDePelea = PODER_CELL_SEGUNDA_TRANSF;
		this.siguienteEstado = null;
	}
	
	@Override
	public void transformar(Personaje personaje) {
		throw new YaNoPuedeEvolucionarException();
	}
	
}
