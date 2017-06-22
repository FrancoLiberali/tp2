package model.personajes.gohan;

import static model.algoBall.ConstantesDelJuego.DISTANCIA_GOHAN_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.NOMBRE_GOHAN_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.PODER_GOHAN_SEGUNDA_TRANSF;
import static model.algoBall.ConstantesDelJuego.VELOCIDAD_GOHAN_SEGUNDA_TRANSF;

import model.exceptions.YaNoPuedeEvolucionarException;
import model.personajes.Personaje;
import model.personajes.elementos.Danio;
import model.personajes.elementos.EstadoTransformacion;
import model.personajes.elementos.Ki;

public class EstadoGohanSuperSayajinFaseDos extends EstadoTransformacion  {
	
	public EstadoGohanSuperSayajinFaseDos()
	{
		this.nombre = NOMBRE_GOHAN_SEGUNDA_TRANSF;
		this.velocidad = VELOCIDAD_GOHAN_SEGUNDA_TRANSF;
		this.distanciaDeAtaque = DISTANCIA_GOHAN_SEGUNDA_TRANSF;
		this.poderDePelea = new Danio(PODER_GOHAN_SEGUNDA_TRANSF);
		this.siguienteEstado = null;
		this.rutaImagen = "file:src/vista/imagenes/gohanSuperSaiyan2.png";
	}
	
	@Override
	public void transformar(Personaje personaje, Ki kiPersonaje) {
		throw new YaNoPuedeEvolucionarException();
	}
}
