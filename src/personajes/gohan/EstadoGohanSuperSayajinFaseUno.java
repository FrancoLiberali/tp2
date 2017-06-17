package personajes.gohan;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_PRIMERA_TRANSF;

import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGohanSuperSayajinFaseUno extends EstadoTransformacion {

	public EstadoGohanSuperSayajinFaseUno()
	{
		this.nombre = NOMBRE_GOHAN_PRIMERA_TRANSF;
		this.velocidad = VELOCIDAD_GOHAN_PRIMERA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_PRIMERA_TRANSF;
		this.poderDePelea = PODER_GOHAN_PRIMERA_TRANSF;
		this.siguienteEstado = new EstadoGohanSuperSayajinFaseDos();
	}

}

