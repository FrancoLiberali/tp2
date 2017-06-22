package model.personajes.gohan;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_NORMAL;
import static model.algoBall.ConstantesDelJuego.KI_GOHAN_PRIMERA_TRANF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_TRANF_NORMAL;
import static model.algoBall.ConstantesDelJuego.PODER_GOHAN_NORMAL;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_NORMAL;

import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoGohanNormal extends EstadoTransformacion {

	public EstadoGohanNormal()
	{	
		this.nombre = NOMBRE_TRANF_NORMAL;
		this.velocidad = VELOCIDAD_GOHAN_NORMAL;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_NORMAL;
		this.poderDePelea = new Danio(PODER_GOHAN_NORMAL);
		this.siguienteEstado = new EstadoGohanSuperSayajinFaseUno();
		this.kiParaTransformacion = new Ki(KI_GOHAN_PRIMERA_TRANF);
		this.rutaImagen = "file:src/vista/imagenes/gohanNormal.png";
	}
	
}
