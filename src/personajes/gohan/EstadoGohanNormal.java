package personajes.gohan;

import static algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_NORMAL;
import static algoBall.ConstantesDelJuego.KI_GOHAN_PRIMERA_TRANF;
import static algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_NORMAL;
import static algoBall.ConstantesDelJuego.PODER_GOHAN_NORMAL;

import personajes.elementos.EstadoTransformacion;
import personajes.elementos.Ki;

public class EstadoGohanNormal extends EstadoTransformacion {

	public EstadoGohanNormal()
	{	
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_GOHAN_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_NORMAL;
		this.poderDePelea = PODER_GOHAN_NORMAL;
		this.siguienteEstado = new EstadoGohanSuperSayajinFaseUno();
		this.kiParaTransformacion = new Ki(KI_GOHAN_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vista/imagenes/gohanNormal.png";
	}
	
}
