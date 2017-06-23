package model.personajes.freezer;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_FREEZER_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.KI_FREEZER_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_FREEZER_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_FREEZER_PRIMERA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_FREEZER_PRIMERA_TRANSF;

import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoFreezerSegundaForma extends EstadoTransformacion {
	
	public EstadoFreezerSegundaForma()
	{
		this.nombre = NOMBRE_FREEZER_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_FREEZER_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_FREEZER_PRIMERA_TRANSF;
		this.poderDePelea = new Danio(PODER_FREEZER_PRIMERA_TRANSF);
		this.siguienteEstado = new EstadoFreezerDefinitivo();
		this.kiParaTransformacion = new Ki(KI_FREEZER_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vistas/imagenes/freezerSegundaForma.png";
	}
	
}
