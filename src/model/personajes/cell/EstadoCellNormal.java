package model.personajes.cell;

import static model.algoBall.ConstantesDelJuego.CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.DISTANCIA_CELL_NORMAL;
import static model.algoBall.ConstantesDelJuego.KI_CELL_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_CELL_NORMAL;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_CELL_NORMAL;

import model.exceptions.NoCumpleCondicionesDeTransformacionException;
import model.personajes.Cell;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoCellNormal extends EstadoTransformacion {
	
		private int vidasNecesariasPrimeraTransf = CELL_CANT_ABSORVER_VIDA_PRIMERA_TRANSF;
	
		public EstadoCellNormal(){
			this.nombre = NOMBRE_TRANF_NORMAL;
			this.velocidad = VELOCIDAD_CELL_NORMAL;
			this.distanciaDeAtaque = DISTANCIA_CELL_NORMAL;
			this.poderDePelea = new Danio(PODER_CELL_NORMAL);
			this.siguienteEstado = new EstadoCellSemiPerfecto();
			this.kiParaTransformacion = new Ki(KI_CELL_PRIMERA_TRANF);
			this.rutaImagen = "file:src/vistas/imagenes/cellNormal.png";
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
