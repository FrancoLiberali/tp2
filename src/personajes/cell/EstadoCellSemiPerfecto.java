package personajes.cell;

import static algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_CELL_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_PRIMERA_TRANSF;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Cell;
import personajes.Personaje;
import personajes.elementos.EstadoTransformacion;

public class EstadoCellSemiPerfecto extends EstadoTransformacion
{
	private int vidasNecesariasSegundaTranf = CELL_CANT_ABSORVER_VIDA_SEGUNDA_TRANSF;
		
	public EstadoCellSemiPerfecto(){
		this.nombre = NOMBRE_CELL_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_CELL_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_CELL_PRIMERA_TRANSF;
		this.poderDePelea = PODER_CELL_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoCellPerfecto();
	}
	
	@Override
	public void realizarAtaqueEspecial(Personaje atacante, Personaje victima){
		Cell cell = (Cell)atacante;
		super.realizarAtaqueBasico(victima);
		cell.absorverVida();
		cell.regenerarSalud(this.poderDePelea);
		
	}
	
	@Override
	public void transformar(Personaje personaje){
		Cell cell = (Cell)personaje;
		if (!this.seAbsorvieronVidasNecesarias(cell.getVidasAbsorvidas())){
			throw new NoCumpleCondicionesDeTransformacionException();
		}
		super.transformar(personaje);
	}

	private boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas){
		return vidasAbsorvidas >= vidasNecesariasSegundaTranf;
	}
	
}
