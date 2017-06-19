package personajes.cell;

import static algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.DISTANCIA_CELL_NORMAL;
import static algoBall.ConstantesDelJuego.KI_CELL_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_CELL_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_CELL_NORMAL;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.Cell;
import personajes.Personaje;
import personajes.cell.EstadoCellSemiPerfecto;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoCellNormal extends EstadoTransformacion {
	
		private int vidasNecesariasPrimeraTransf = CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF;
	
		public EstadoCellNormal(){
			this.nombre = NOMBRE_TRANF_NORMAL;
			this.velocidad = VELOCIDAD_CELL_NORMAL;
			this.distanciaDeAtaque = DISTANCIA_CELL_NORMAL;
			this.poderDePelea = PODER_CELL_NORMAL;
			this.siguienteEstado = new EstadoCellSemiPerfecto();
			this.kiParaTransformacion = new Ki(KI_CELL_PRIMERA_TRANF);
			this.rutaImagen = "file:src/vista/imagenes/cellNormal.png";
		};
		
		@Override
		public void transformar(Personaje personaje, Ki kiPersonaje){
			Cell cell = (Cell)personaje;
			if (!this.seAbsorvieronVidasNecesarias(cell.getVidasAbsorvidas())){
				throw new NoCumpleCondicionesDeTransformacionException();
			}
			super.transformar(personaje, kiPersonaje);
		}

		private boolean seAbsorvieronVidasNecesarias(int vidasAbsorvidas){
			return vidasAbsorvidas >= vidasNecesariasPrimeraTransf;
		}
		
}
