package personajes.cell;

import static algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.KI_CELL_SEGUNDA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_PRIMERA_TRANSF;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Cell;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoCellSemiPerfecto extends EstadoTransformacion
{
	private int vidasNecesariasSegundaTranf = CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
		
	public EstadoCellSemiPerfecto(){
		this.nombre = NOMBRE_CELL_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_CELL_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_CELL_PRIMERA_TRANSF;
		this.poderDePelea = PODER_CELL_PRIMERA_TRANSF;
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
