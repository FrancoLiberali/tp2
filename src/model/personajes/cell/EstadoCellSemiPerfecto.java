package model.personajes.cell;

import static model.algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.DISTANCIA_CELL_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.KI_CELL_SEGUNDA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_CELL_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_CELL_PRIMERA_TRANSF;

import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Cell;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoCellSemiPerfecto extends EstadoTransformacion
{
	private int vidasNecesariasSegundaTranf = CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
		
	public EstadoCellSemiPerfecto(){
		this.nombre = NOMBRE_CELL_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_CELL_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_CELL_PRIMERA_TRANSF;
		this.poderDePelea = new Danio(PODER_CELL_PRIMERA_TRANSF);
		this.siguienteEstado = new EstadoCellPerfecto();
		this.kiParaTransformacion = new Ki(KI_CELL_SEGUNDA_TRANF);
		this.rutaImagen = "file:src/vista/imagenes/cellSemiperfecto.png";
	}
	
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje){
		Cell cell = (Cell)personaje;
		if (!this.seAbsorvieronVidasNecesarias(cell.getVidasAbsorvidas())){
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		super.transformar(personaje, kiPersonaje);
	}

	private boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas){
		return vidasAbsorvidas >= vidasNecesariasSegundaTranf;
	}
	
}
