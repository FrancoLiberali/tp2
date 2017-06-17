package personajes.freezer;

import static algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_FREEZER_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_FREEZER_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_PRIMERA_TRANSF;

import personajes.elementos.EstadoTransformacion;

public class EstadoFreezerSegundaForma extends EstadoTransformacion {
	
	public EstadoFreezerSegundaForma()
	{
		this.nombre = NOMBRE_FREEZER_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_FREEZER_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_PRIMERA_TRANSF;
		this.poderDePelea = PODER_FREEZER_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoFreezerDefinitivo();
	}
	
}
