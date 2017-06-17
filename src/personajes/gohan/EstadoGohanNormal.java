package personajes.gohan;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_NORMAL;
import static algoBall.ConstantesDelJuego.NOMBRE_GOHAN_PRIMERA_TRANSF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_NORMAL;

import exceptions.NoCumpleCondicionesDeTransformacionException;
import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGohanNormal extends EstadoTransformacion {

	public EstadoGohanNormal()
	{	
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_GOHAN_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_NORMAL;
		this.poderDePelea = DISTANCIA_GOHAN_NORMAL;
		this.siguienteEstado = new EstadoGohanSuperSayajinFaseUno();
	}
	
}
